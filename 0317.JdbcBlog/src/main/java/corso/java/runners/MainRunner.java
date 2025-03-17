package corso.java.runners;

import java.util.Random;
import java.util.stream.IntStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import corso.java.dao.ArticleDao;
import corso.java.dao.CommentDao;
import corso.java.entities.Article;
import corso.java.entities.Comment;

@Component
public class MainRunner implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(MainRunner.class);
	@Autowired
	private ArticleDao articles;
	@Autowired
	private CommentDao comments;

	private static final Random rnd = new Random();

	@Override
	public void run(String... args) throws Exception {
		comments.dropTable();
		articles.dropTable();
		articles.createTable();
		comments.createTable();

		IntStream.range(1, 101).forEach(n -> {
			articles.save( //
					Article.builder() //
							.withAuthor("nello") //
							.withTitle(String.format("Titolo n %s", n)) //
							.withBody(String.format("Contenuto dell'articolo n. %s.", n).repeat(rnd.nextInt(50))) //
							.build() //
			);
		});

		articles.findById(3).ifPresent(a -> {
			IntStream.range(0, 5).forEach(n -> {
				comments.save( //
						Comment.builder() //
								.withArticleId(a.getId()) //
								.withAuthor("nello") //
								.withBody("Commento all'articolo") //
								.build());
			});
		});

		articles.findById(3).ifPresent(a -> {
			log.info("{}", a);
			log.info("Commenti:");
			comments.findAllByArticleId(a.getId()).forEach(c -> {
				log.info("{}", c);
			});
		});
	}

}
