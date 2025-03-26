package corso.java.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import corso.java.entities.AuthorEntity;
import corso.java.repositories.AuthorsRepository;

/*
	x Aggiunta di un Autore
	x Elenco di tutti gli Autori
 */
@RestController
@RequestMapping("/api/authors")
public class AuthorsController {

	private final AuthorsRepository authors;

	public AuthorsController(AuthorsRepository authors) {
		this.authors = authors;
	}

	@PostMapping("register")
	public AuthorEntity registerAuthor(@RequestBody AuthorEntity a) {
		return authors.save(a);
	}

	@GetMapping
	public List<AuthorEntity> list() {
		return authors.findAll();
	}
}
