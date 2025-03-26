package corso.java.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import corso.java.controllers.models.WroteArticleModel;
import corso.java.controllers.models.WroteCommentModel;
import corso.java.entities.ArticleEntity;
import corso.java.entities.CommentEntity;
import corso.java.repositories.ArticlesRepository;
import corso.java.repositories.AuthorsRepository;
import corso.java.repositories.CommentsRepository;

/*
	x Aggiunta di un Articolo
	x Commento ad un Articolo
	x Elenco di tutti gli Articoli
	x Recupero di un Articolo 
 */
@RestController
@RequestMapping("/api/articles")
public class ArticlesController {

	private final ArticlesRepository articles;
	private final AuthorsRepository authors;
	private final CommentsRepository comments;

	public ArticlesController(CommentsRepository comments, AuthorsRepository authors, ArticlesRepository articles) {
		this.articles = articles;
		this.authors = authors;
		this.comments = comments;
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

	@GetMapping
	public List<ArticleEntity> list() {
		return articles.findAll();
	}

	@GetMapping("{id}")
	public ArticleEntity findById(@PathVariable int id) {
		return articles.findById(id).orElseThrow();
	}

	@PostMapping("{articleId}/comments")
	public ArticleEntity comment(@PathVariable int articleId, //
			@RequestBody WroteCommentModel c) {
		var article = articles.findById(articleId).orElseThrow();
		var author = authors.findById(c.getAuthorId()).orElseThrow();
		var comment = CommentEntity.builder() //
				.withArticle(article) //
				.withAuthor(author) //
				.withBody(c.getContent()) //
				.build();
		comments.save(comment);
		
		return articles.findById(articleId).orElseThrow();
	}
}
