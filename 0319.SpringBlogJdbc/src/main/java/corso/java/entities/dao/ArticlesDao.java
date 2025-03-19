package corso.java.entities.dao;

import java.util.List;
import java.util.Optional;

import corso.java.entities.Article;

public interface ArticlesDao {
	void publish(Article article);

	List<Article> getArticles();

	Optional<Article> getArticleById(int id);

	List<Article> getArticleByTitleContains(String title);
}
