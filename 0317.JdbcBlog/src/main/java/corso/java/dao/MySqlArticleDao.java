package corso.java.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import corso.java.entities.Article;

@Component
public class MySqlArticleDao extends DaoTemplate<Article> implements ArticleDao {
	private static final Logger log = LoggerFactory.getLogger(MySqlArticleDao.class);

	private static final String URL = "jdbc:mysql://localhost:3306/blog";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "";

	private static final String CREATE_TABLE = " CREATE TABLE `blog`.`articles` (" //
			+ "`id` INT NOT NULL AUTO_INCREMENT," //
			+ "`title` VARCHAR(45) NOT NULL," //
			+ "`body` TEXT NOT NULL," //
			+ "`author` VARCHAR(20) NOT NULL," //
			+ "`published_at` TIMESTAMP(6) NOT NULL," //
			+ "PRIMARY KEY (`id`))";
	private static final String DROP_TABLE = "DROP TABLE `blog`.`articles`";

	private static final String INSERT = "INSERT INTO `blog`.`articles`(title, body, author, published_at)"
			+ " VALUES(?,?,?,?)";
	private static final String SELECT = "SELECT " + "id, title, body, author, published_at "
			+ "FROM `blog`.`articles` " + "ORDER BY published_at DESC";
	private static final String SELECT_BY_ID = "SELECT " + "id, title, body, author, published_at "
			+ "FROM `blog`.`articles` " + "WHERE id = ?";

	public MySqlArticleDao() {
		super(URL, USERNAME, PASSWORD);
	}

	@Override
	public void dropTable() {
		dropTable(DROP_TABLE);
	}

	@Override
	public void createTable() {
		createTable(CREATE_TABLE);
	}

	@Override
	public void save(Article article) {
		try (var stmt = getConnection().prepareStatement(INSERT)) {
			stmt.setString(1, article.getTitle());
			stmt.setString(2, article.getBody());
			stmt.setString(3, article.getAuthor());
			stmt.setTimestamp(4, Timestamp.valueOf(LocalDateTime.now()));
			stmt.execute();
		} catch (SQLException e) {
			log.error("Exception saving entity", e);
		}

	}

	@Override
	protected Article map(ResultSet rs) throws SQLException {
		return Article.builder() //
				.withAuthor(rs.getString(4)) //
				.withBody(rs.getString(3)) //
				.withId(rs.getInt(1)) //
				.withPublishedAt(rs.getTimestamp(5).toLocalDateTime()) //
				.withTitle(rs.getString(2)) //
				.build();
	}

	@Override
	public List<Article> findAll() {
		return findAll(SELECT);
	}

	@Override
	public Optional<Article> findById(int id) {
		return findById(SELECT_BY_ID, id);
	}

}
