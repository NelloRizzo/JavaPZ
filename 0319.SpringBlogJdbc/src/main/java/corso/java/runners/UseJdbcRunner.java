package corso.java.runners;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import corso.java.Application;
import corso.java.entities.Article;
import corso.java.entities.dao.ArticlesDao;
import corso.java.entities.dao.JdbcArticlesDao;
import corso.java.entities.dao.JdbcUsersDao;
import corso.java.entities.dao.UsersDao;

@Component
public class UseJdbcRunner implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(UseJdbcRunner.class);
	private final JdbcArticlesDao jdbcArticlesDao;

	private final JdbcUsersDao jdbcUsersDao;

	public UseJdbcRunner(UsersDao usersDao, ArticlesDao articlesDao, JdbcUsersDao jdbcUsersDao,
			JdbcArticlesDao jdbcArticlesDao, Application application) {
		this.jdbcUsersDao = jdbcUsersDao;
		this.jdbcArticlesDao = jdbcArticlesDao;
	}

	@Override
	public void run(String... args) throws Exception {
//		var nello = User.builder() //
//				.withFriendlyName("Nello") //
//				.withPassword("password") //
//				.withUsername("nello") //
//				.build();
//		jdbcUsersDao.registerUser(nello);
		jdbcUsersDao.getUserByUsername("nello") //
				.ifPresent(user -> {
					jdbcArticlesDao.publish(Article.builder() //
							.withAuthor(user) //
							.withContent("Contenuto dell'articolo") //
							.withPublishedAt(LocalDateTime.now()) //
							.withTitle("Titolo dell'articolo") //
							.build());
				});
		jdbcArticlesDao.getArticles().forEach(a -> log.info("{}", a));
	}

}
