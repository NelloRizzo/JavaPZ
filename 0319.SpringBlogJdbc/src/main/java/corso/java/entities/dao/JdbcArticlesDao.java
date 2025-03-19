package corso.java.entities.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import corso.java.entities.Article;
import corso.java.entities.User;

@Component
public class JdbcArticlesDao implements ArticlesDao {

	/*
	 * CREATE TABLE `articles` ( `id` int NOT NULL AUTO_INCREMENT, `title`
	 * varchar(80) NOT NULL, `content` longtext NOT NULL, `published_at`
	 * timestamp(6) NOT NULL, `author_id` int NOT NULL, PRIMARY KEY (`id`) )
	 */
	private final JdbcTemplate jdbcTemplate;

	private static String INSERT_ARTICLE = //
			"INSERT INTO spring_blog.articles(title, content, published_at, author_id) " + "VALUES(?, ?, ?, ?)";

	private static String SELECT_ALL_ARTICLES = //
			"select " //
					+ "a.id, a.title, a.content, a.published_at, " //
					+ "u.id, u.username, u.password, u.friendly_name " // F
					+ "from articles a join users u on a.author_id = u.id";

	private static class ArticleRowMapper implements RowMapper<Article> {

		@Override
		public Article mapRow(ResultSet rs, int rowNum) throws SQLException {
			return Article.builder() //
					.withAuthor(User.builder() //
							.withFriendlyName(rs.getString(8)) //
							.withId(rs.getInt(5)) //
							.withPassword(rs.getString(7)) //
							.withUsername(rs.getString(6)) //
							.build())//
					.withContent(rs.getString(3)) //
					.withId(rs.getInt(1)) //
					.withPublishedAt(rs.getTimestamp(4).toLocalDateTime()) //
					.withTitle(rs.getString(2))//
					.build();
		}

	}

	public JdbcArticlesDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void publish(Article article) {
		jdbcTemplate.update(INSERT_ARTICLE, //
				article.getTitle(), article.getContent(), article.getPublishedAt(), //
				article.getAuthor().getId());

	}

	@Override
	public List<Article> getArticles() {
		return jdbcTemplate.query(SELECT_ALL_ARTICLES, new ArticleRowMapper());
	}

	@Override
	public Optional<Article> getArticleById(int id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public List<Article> getArticleByTitleContains(String title) {
		// TODO Auto-generated method stub
		return null;
	}

}
