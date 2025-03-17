package corso.java.first.dao;

import java.util.List;

import corso.java.first.runners.Article;

public interface ArticlesDAO {
	void save(Article a);

	List<Article> findAll();
	
	List<Article> findAllByTitleContains(String title);
}
