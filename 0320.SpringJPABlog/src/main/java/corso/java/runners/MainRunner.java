package corso.java.runners;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.stream.IntStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import corso.java.entities.Article;
import corso.java.entities.Comment;
import corso.java.entities.User;
import corso.java.repositories.ArticlesRepository;
import corso.java.repositories.CommentsRepository;
import corso.java.repositories.UsersRepository;

@Component
public class MainRunner implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(MainRunner.class);
	@Autowired
	ArticlesRepository articles;
	@Autowired
	UsersRepository users;
	@Autowired
	CommentsRepository comments;

	private static final Random rnd = new Random(1);

	@Override
	public void run(String... args) throws Exception {
		var nello = User.builder() //
				.withEmail("nellorizzo@live.it") //
				.withPassword("password") //
				.withUsername("Nello") //
				.build();
		users.save(nello);
		var nellorizzo = User.builder() //
				.withEmail("nello.rizzo@libero.it") //
				.withPassword("password") //
				.withUsername("Nello Rizzo") //
				.build();
		users.save(nellorizzo);
		users.findAll().forEach(u -> log.info("{}", u));

		var lu = users.findAll();
		IntStream.rangeClosed(1, 10).forEach(n -> {
			var a = Article.builder() //
					.withAuthor(lu.get(rnd.nextInt(lu.size()))) //
					.withTitle(String.format("Titolo n. %s", n)) //
					.withContent(String.format("Contenuto dell'articolo n. %s", n)) //
					.withPublishedAt(LocalDateTime.now().minusDays(rnd.nextInt(10))) //
					.build();
			articles.save(a);
		});

		var la = articles.findAll();
		IntStream.range(0, 100).forEach(n -> {
			var c = Comment.builder() //
					.withAuthor(lu.get(rnd.nextInt(lu.size()))) //
					.withContent(String.format("Contenuto generato automaticamente n. %s", n)) //
					.withArticle(la.get(rnd.nextInt(la.size()))) //
					.withPublishedAt(LocalDateTime.now()) //
					.build();
			comments.save(c);
		});

		articles.findAll().forEach(a -> {
			log.info("{}", a);
			a.getComments().forEach(c -> log.info("\t{}", c));
		});

		users.findOneByUsername("Nello").ifPresentOrElse( //
				u -> log.info("{}", u), // if present
				() -> log.warn("Attenzione, l'utente non esiste"));
		users.findOneByUsername("non esiste").ifPresentOrElse( //
				u -> log.info("{}", u), // if present
				() -> log.warn("Attenzione, l'utente non esiste"));
		log.info("Articoli pubblicati negli ultimi 5 giorni");
		articles.findAllByPublishedAtBetween(LocalDateTime.now().minusDays(5), LocalDateTime.now()) //
				.forEach(a -> log.info("{}", a));
		log.info("Articoli pubblicati dopo il 16/03/2025");
		articles.findAllByPublishedAtGreaterThan(LocalDateTime.of(2025, 03, 16, 0, 0, 0)) //
				.forEach(a -> log.info("{}", a));
		log.info("Articoli che contengono un 1 nel contenuto");
		articles.findAllByContentContains("1") //
				.forEach(a -> log.info("{}", a));
		log.info("Articoli pubblicati da Nello Rizzo");
		articles.findAllByAuthorUsername("Nello Rizzo").forEach(a -> log.info("{}", a));
		log.info("Articoli pubblicati da Nello Rizzo o da un utente in cui l'email contenga 'live'");
		articles.findAllByAuthorUsernameOrAuthorEmailContains("Nello Rizzo", "live").forEach(a -> log.info("{}", a));
		log.info("Articoli pubblicati da Nello Rizzo dal 17 ad oggi");
		articles.findAllByAuthorUsernameAndPublishedAtBetween("Nello Rizzo", LocalDateTime.of(2025, 3, 17, 0, 0, 0),
				LocalDateTime.now()).forEach(a -> log.info("{}", a));
	}

}
