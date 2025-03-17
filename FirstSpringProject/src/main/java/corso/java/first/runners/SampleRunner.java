package corso.java.first.runners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import corso.java.first.dao.ArticlesDAO;

@Component
public class SampleRunner implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(SampleRunner.class);

	private final ArticlesDAO articles;
	
	public SampleRunner(ArticlesDAO articles) {
		this.articles = articles;
	}
   
	@Override
	public void run(String... args) throws Exception {
		for (int i = 1; i <= 10; i++) {
			var a = new Article(0, "Articolo n. " + i, "Testo n. " + i, "Nello", null);
			articles.save(a);
		}
		log.info("Tutti gli articoli");
		articles.findAll().stream() //
			.forEach(article -> log.info("{}", article));
		log.info("Tutti gli articoli che contengono 1 nel titolo");
		articles.findAllByTitleContains("1").stream() //
		.forEach(article -> log.info("{}", article));

	}

}
