package corso.java.dao;

import java.util.List;
import java.util.Optional;

import corso.java.entities.Article;

public interface ArticleDao {

	void dropTable();

	void createTable();

	void save(Article article);

	List<Article> findAll();

	Optional<Article> findById(int id);
}
