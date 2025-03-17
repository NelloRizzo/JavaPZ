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
import org.springframework.stereotype.Component;

import corso.java.first.runners.Article;

@Component
public class MySqlArticlesDataAccess implements ArticlesDataAccess {
	private final Logger log = LoggerFactory.getLogger(MySqlArticlesDataAccess.class);
	private final String URL = "jdbc:mysql://localhost:3306/blog";
	private final String USER = "root";
	private final String PASSWORD = "";
	private Connection connection;

	private final String INSERT = //
			"insert into blog.articles(title, body, author, published_at) " //
					+ "values (?,?,?,?)";
	private final String SELECT = "select " //
			+ "	id, title, body, author, published_at " //
			+ "from " //
			+ "	blog.articles";
	private final String SELECT_FILTERED = "select " //
			+ "	id, title, body, author, published_at " //
			+ "from " //
			+ "	blog.articles " //
			+ "where title like ?";

	public MySqlArticlesDataAccess() {
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
