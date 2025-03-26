package corso.java.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import corso.java.entities.ArticleEntity;
import corso.java.repositories.ArticlesRepository;

/*
	x Aggiunta di un Articolo
	Commento ad un Articolo
	Elenco di tutti gli Articoli
	Recupero di un Articolo 
 */
@RestController
@RequestMapping("/api/articles")
public class ArticlesController {

	private final ArticlesRepository articles;

	public ArticlesController(ArticlesRepository articles) {
		this.articles = articles;
	}

	@PostMapping
	public ArticleEntity publish(@RequestBody ArticleEntity a) {
		return articles.save(a);
	}
}
