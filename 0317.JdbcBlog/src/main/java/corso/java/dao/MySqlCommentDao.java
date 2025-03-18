package corso.java.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import corso.java.entities.Comment;

@Component
public class MySqlCommentDao extends DaoTemplate<Comment> implements CommentDao {
	private static final Logger log = LoggerFactory.getLogger(MySqlArticleDao.class);

	private static final String URL = "jdbc:mysql://localhost:3306/blog";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "";

	private static final String CREATE_TABLE = " CREATE TABLE `blog`.`comments` (" //
			+ "`id` INT NOT NULL AUTO_INCREMENT," //
			+ "`article_id` INT NOT NULL," //
			+ "`body` TEXT NOT NULL," //
			+ "`author` VARCHAR(20) NOT NULL," //
			+ "`published_at` TIMESTAMP(6) NOT NULL," //
			+ "PRIMARY KEY (`id`))";
	private static final String DROP_TABLE = "DROP TABLE `blog`.`comments`";

	private static final String INSERT = "INSERT INTO `blog`.`comments`(body, author, article_id, published_at)" //
			+ " VALUES(?,?,?,?)";
	private static final String SELECT_BY_ARTICLE_ID = "SELECT " //
			+ "id, body, author, article_id, published_at " //
			+ "FROM `blog`.`comments` " //
			+ "WHERE article_id = ? " //
			+ "ORDER BY published_at DESC";

	public MySqlCommentDao() {
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
	public void save(Comment comment) {
		try (var stmt = getConnection().prepareStatement(INSERT)) {
			stmt.setString(1, comment.getBody());
			stmt.setString(2, comment.getAuthor());
			stmt.setInt(3, comment.getArticleId());
			stmt.setTimestamp(4, Timestamp.valueOf(LocalDateTime.now()));
			stmt.execute();
		} catch (SQLException e) {
			log.error("Exception saving entity", e);
		}
	}

	@Override
	protected Comment map(ResultSet rs) throws SQLException {
		return Comment.builder() //
				.withArticleId(rs.getInt(4)) //
				.withAuthor(rs.getString(3)) //
				.withBody(rs.getString(2)) //
				.withId(rs.getInt(1)) //
				.withPublishedAt(rs.getTimestamp(5).toLocalDateTime()) //
				.build();
	}

	@Override
	public List<Comment> findAllByArticleId(int articleId) {
		var result = new ArrayList<Comment>();
		try (var stmt = getConnection().prepareStatement(SELECT_BY_ARTICLE_ID)) {
			stmt.setInt(1, articleId);
			try (var rs = stmt.executeQuery()) {
				while (rs.next()) {
					result.add(map(rs));
				}
			}
		} catch (SQLException e) {
			log.error("Exception getting all articles", e);
		}
		return result;
	}
}
