package corso.java.first;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import corso.java.first.dao.ArticlesDAO;
import corso.java.first.dao.MySqlArticlesDAO;
import corso.java.first.dao.PostgreSqlArticlesDAO;

@Configuration
public class ApplicationConfig {

	private boolean useMySql = false;

	@Bean
	ArticlesDAO getBean() {
		if (useMySql)
			return new MySqlArticlesDAO();
		return new PostgreSqlArticlesDAO();
	}
}
