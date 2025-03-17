package corso.java.first.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import corso.java.first.runners.Article;

public class PostgreSqlArticlesDAO implements ArticlesDAO {
	private final Logger log = LoggerFactory.getLogger(PostgreSqlArticlesDAO.class);
	private final String URL = "jdbc:postgresql://localhost:5432/postgres";
	private final String USER = "postgres";
	private final String PASSWORD = "postgres";
	private Connection connection;

	private final String INSERT = //
			"insert into articles(title, body, author, published_at) " //
					+ "values (?,?,?,?)";
	private final String SELECT = "select " //
			+ "	id, title, body, author, published_at " //
			+ "from " //
			+ "	articles";
	private final String SELECT_FILTERED = "select " //
			+ "	id, title, body, author, published_at " //
			+ "from " //
			+ "	articles " //
			+ "where title like ?";

	public PostgreSqlArticlesDAO() {
		log.info("Sto usando PostgreSQL");
		try {
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			connection = null;
			log.error("Errore di connessione", e);
		}
	}

	@Override
	public void save(Article a) {
		try {
			var stmt = connection.prepareStatement(INSERT);
			stmt.setString(1, a.getTitle());
			stmt.setString(2, a.getBody());
			stmt.setString(3, a.getAuthor());
			stmt.setTimestamp(4, Timestamp.valueOf(LocalDateTime.now()));
			stmt.execute();
		} catch (Exception e) {
			log.error("Errore nel salvataggio", e);
		}
	}

	@Override
	public List<Article> findAll() {
		var result = new ArrayList<Article>();
		try {
			var stmt = connection.prepareStatement(SELECT);
			var rs = stmt.executeQuery();
			while (rs.next()) {
				result.add( //
						new Article(rs.getInt(1), //
								rs.getString(2), //
								rs.getString(3), //
								rs.getString(4), //
								rs.getTimestamp(5).toLocalDateTime()) //
				);
			}
		} catch (Exception e) {
			log.error("Errore nel recupero", e);
		}
		return result;
	}

	@Override
	public List<Article> findAllByTitleContains(String title) {
		var result = new ArrayList<Article>();
		try {
			var stmt = connection.prepareStatement(SELECT_FILTERED);
			stmt.setString(1, "%" + title + "%");
			var rs = stmt.executeQuery();
			while (rs.next()) {
				result.add( //
						new Article(rs.getInt(1), //
								rs.getString(2), //
								rs.getString(3), //
								rs.getString(4), //
								rs.getTimestamp(5).toLocalDateTime()) //
				);
			}
		} catch (Exception e) {
			log.error("Errore nel recupero", e);
		}
		return result;
	}

}
