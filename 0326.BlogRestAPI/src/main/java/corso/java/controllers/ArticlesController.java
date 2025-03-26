package corso.java.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import corso.java.controllers.models.WroteArticleModel;
import corso.java.entities.ArticleEntity;
import corso.java.repositories.ArticlesRepository;
import corso.java.repositories.AuthorsRepository;

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
	private final AuthorsRepository authors;

	public ArticlesController(AuthorsRepository authors, ArticlesRepository articles) {
		this.articles = articles;
		this.authors = authors;
	}

//	@PostMapping("{authorId}")
//	public ArticleEntity publish(@PathVariable int authorId,
//			@RequestBody ArticleEntity a) {
//		var author = authors.findById(authorId).orElseThrow();
//		a.setAuthor(author);
//		return articles.save(a);
//	}

	@PostMapping
	public ArticleEntity publish(@RequestBody WroteArticleModel a) {
		var author = authors.findById(a.getAuthorId()).orElseThrow();
		var article = ArticleEntity.builder() //
				.withAuthor(author) //
				.withBody(a.getBody()) //
				.withTitle(a.getTitle()) //
				.build();
		return articles.save(article);
	}
}
