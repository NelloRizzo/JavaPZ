package corso.java.first.dao;

import java.util.List;

import corso.java.first.runners.Article;

public interface ArticlesDataAccess {
	void save(Article a);

	List<Article> findAll();
}
