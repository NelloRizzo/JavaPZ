package corso.java.first.runners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import corso.java.first.FirstSpringProjectApplication;
import corso.java.first.dao.ArticlesDataAccess;

@Component
public class SampleRunner implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(SampleRunner.class);

	@Autowired
	private ArticlesDataAccess articles;
   
	@Override
	public void run(String... args) throws Exception {
		for (int i = 1; i <= 10; i++) {
			var a = new Article(0, "Articolo n. " + i, "Testo n. " + i, "Nello", null);
			articles.save(a);
		}
		
		articles.findAll().stream() //
			.forEach(article -> log.info("{}", article));

	}

}
