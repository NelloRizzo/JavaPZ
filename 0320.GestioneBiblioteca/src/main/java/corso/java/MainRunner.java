package corso.java;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import corso.java.entities.Author;
import corso.java.entities.Book;
import corso.java.entities.BookCopy;
import corso.java.entities.Category;
import corso.java.entities.Loan;
import corso.java.entities.Location;
import corso.java.repositories.AuthorsRepository;
import corso.java.repositories.BooksRepository;
import corso.java.repositories.CategoriesRepository;
import corso.java.repositories.CopiesRepository;
import corso.java.repositories.LoansRepository;

@Component
public class MainRunner implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(MainRunner.class);
	@Autowired
	private AuthorsRepository authors;
	@Autowired
	private BooksRepository books;
	@Autowired
	private CategoriesRepository categories;
	@Autowired
	private CopiesRepository copies;
	@Autowired
	private LoansRepository loans;

	@Override
	public void run(String... args) throws Exception {
		var literature = Category.builder() //
				.withName("Letteratura") //
				.build();
		var literature_classics = Category.builder() //
				.withName("Classici") //
				.withParent(literature) //
				.build();
		var literature_italian_classics = Category.builder() //
				.withName("Italiani") //
				.withParent(literature_classics) //
				.build();
		var sciFi = Category.builder() //
				.withName("Fantascienza") //
				.build();
		var programming = Category.builder() //
				.withName("Programmazione") //
				.build();
		var programming_languages = Category.builder() //
				.withName("Linguaggi") //
				.withParent(programming) //
				.build();
		var programming_analisys = Category.builder() //
				.withName("Analisi") //
				.withParent(programming) //
				.build();
		var programming_languages_c = Category.builder() //
				.withName("ANSI C") //
				.withParent(programming_languages) //
				.build();

		categories.save(literature);
		categories.save(literature_classics);
		categories.save(sciFi);
		categories.save(literature_italian_classics);
		categories.save(programming);
		categories.save(programming_languages);
		categories.save(programming_analisys);
		categories.save(programming_languages_c);

		categories.findMainCategories().forEach(c -> showCategory(c, 0));
		log.info("Nome completo per {}: [{}]", programming_languages_c, categoryFullName(programming_languages_c));

		authors.saveAll(List.of( //
				Author.builder().withFirstName("Umberto").withLastName("Eco").withCountry("ITA").withYearOfBirth(1903)
						.withYearOfDeath(2016).build(),
				Author.builder().withFirstName("George").withLastName("Orwell").withCountry("ENG").withYearOfBirth(1903)
						.withYearOfDeath(1950).build(),
				Author.builder().withFirstName("Jane").withLastName("Austen").withCountry("ENG").withYearOfBirth(1775)
						.withYearOfDeath(1817).build(),
				Author.builder().withFirstName("Antoine").withLastName("de Saint-Exupéry").withCountry("FRA")
						.withYearOfBirth(1900).withYearOfDeath(1944).build(),
				Author.builder().withFirstName("Herman").withLastName("Melville").withCountry("USA")
						.withYearOfBirth(1819).withYearOfDeath(1891).build(),
				Author.builder().withFirstName("Miguel").withLastName("de Cervantes").withCountry("ESP")
						.withYearOfBirth(1547).withYearOfDeath(1616).build(),
				Author.builder().withFirstName("Dante").withLastName("Alighieri").withCountry("ITA")
						.withYearOfBirth(1265).withYearOfDeath(1321).build(),
				Author.builder().withFirstName("Lev").withLastName("Tolstoj").withCountry("RUS").withYearOfBirth(1828)
						.withYearOfDeath(1910).build(),
				Author.builder().withFirstName("Francis").withMiddleName("Scott").withLastName("Fitzgerald")
						.withCountry("USA").withYearOfBirth(1896).withYearOfDeath(1940).build(),
				Author.builder().withFirstName("Marta").withLastName("Wells").withCountry("USA").withYearOfBirth(1964)
						.build(),
				Author.builder().withFirstName("Andy").withLastName("Weir").withCountry("USA").withYearOfBirth(1972)
						.build(),
				Author.builder().withFirstName("Charles").withLastName("Petzold").withCountry("USA")
						.withYearOfBirth(1953).build(),
				Author.builder().withFirstName("William").withLastName("Shakespeare").withCountry("ENG")
						.withYearOfBirth(1564).withYearOfDeath(1616).build()));
		books.saveAll(List.of( //
				Book.builder() //
						.withAuthor(authors.findFirstByLastNameStartsWith("Eco"))//
						.withCategory(literature_italian_classics) //
						.withTitle("Il Nome della Rosa") //
						.withIsbn("978-8807887665") //
						.withPages(512).withYear(1980).build(),
				Book.builder() //
						.withAuthor(authors.findFirstByLastNameStartsWith("Orw"))//
						.withCategory(literature_classics) //
						.withTitle("1984") //
						.withIsbn("978-0451524935") //
						.withPages(328).withYear(1949).build(),
				Book.builder() //
						.withAuthor(authors.findFirstByLastNameStartsWith("Aus"))//
						.withCategory(literature_classics) //
						.withTitle("Orgoglio e Pregiudizio") //
						.withIsbn("978-0141439518") //
						.withPages(279).withYear(1813).build(),
				Book.builder() //
						.withAuthor(authors.findFirstByLastNameStartsWith("de S"))//
						.withCategory(literature_classics) //
						.withTitle("Il Piccolo Principe") //
						.withIsbn("978-0156012195") //
						.withPages(96).withYear(1943).build(),
				Book.builder() //
						.withAuthor(authors.findFirstByLastNameStartsWith("Mel"))//
						.withCategory(literature_classics) //
						.withTitle("Moby Dick") //
						.withIsbn("978-1503280786") //
						.withPages(635).withYear(1951).build(),
				Book.builder() //
						.withAuthor(authors.findFirstByLastNameStartsWith("de C"))//
						.withCategory(literature_classics) //
						.withTitle("Don Chisciotte della Mancia") //
						.withIsbn("978-0060934347") //
						.withPages(992).withYear(1605).build(),
				Book.builder() //
						.withAuthor(authors.findFirstByLastNameStartsWith("Alig"))//
						.withCategory(literature_italian_classics) //
						.withTitle("La Divina Commedia") //
						.withIsbn("978-8807900333") //
						.withPages(432).withYear(1320).build(),
				Book.builder() //
						.withAuthor(authors.findFirstByLastNameStartsWith("Tol"))//
						.withCategory(literature_classics) //
						.withTitle("Guerra e Pace") //
						.withIsbn("978-0199232765") //
						.withPages(1225).withYear(1869).build(),
				Book.builder() //
						.withAuthor(authors.findFirstByLastNameStartsWith("Fit"))//
						.withCategory(literature_classics) //
						.withTitle("Il Grande Gatsby") //
						.withIsbn("978-0743273565") //
						.withPages(180).withYear(1925).build(),
				Book.builder() //
						.withAuthor(authors.findFirstByLastNameStartsWith("Sha"))//
						.withCategory(literature_classics) //
						.withTitle("Amleto") //
						.withIsbn("978-0140714548") //
						.withPages(342).withYear(1603).build(),
				Book.builder() //
						.withAuthor(authors.findFirstByLastNameStartsWith("Wells"))//
						.withCategory(sciFi) //
						.withTitle("Murderbot: I Diari della Macchina Assassina") //
						.withIsbn("978-8804727767") //
						.withPages(480).withYear(2020).build(),
				Book.builder() //
						.withAuthor(authors.findFirstByLastNameStartsWith("Pet"))//
						.withCategory(programming_languages_c) //
						.withTitle("Programming Windows") //
						.withIsbn("978-8804727767") //
						.withPages(1528).withYear(1999).build(),
				Book.builder() //
						.withAuthor(authors.findFirstByLastNameStartsWith("Weir"))//
						.withCategory(sciFi) //
						.withTitle("Project Hail Mary") //
						.withIsbn("978-0593395561") //
						.withPages(496).withYear(2021).build()));

		books.findAll().forEach(b -> log.info("{}", b));

		log.info("Autori in vita");
		authors.findAllByYearOfDeathIsNull().forEach(a -> {
			log.info("{}", a);
			books.findAllByAuthor(a).forEach(b -> log.info("  - {}", b));
		});

		copies.saveAll(List.of(//
				BookCopy.builder() //
						.withBook(books.findById(1).orElseThrow()) //
						.withLocation( //
								Location.builder().withIndex("1").build()) //
						.build(),
				BookCopy.builder() //
						.withBook(books.findById(1).orElseThrow()) //
						.withLocation( //
								Location.builder().withIndex("2").build()) //
						.build(),
				BookCopy.builder() //
						.withBook(books.findById(2).orElseThrow()) //
						.withLocation( //
								Location.builder().withIndex("3").build()) //
						.build() //
		));

		copies.findAll().forEach(c -> log.info("{}", c));

		loans.saveAll(List.of( //
				Loan.builder() //
						.withBook(copies.findById(1).orElseThrow()) //
						.withFrom(LocalDate.now()) //
						.withTo(LocalDate.now().plusDays(10)) //
						.build(), //
				Loan.builder() //
						.withBook(copies.findById(2).orElseThrow()) //
						.withFrom(LocalDate.now().minusDays(1)) //
						.withTo(LocalDate.now().plusDays(15)) //
						.build() //
		));
		loans.findAll().forEach(l -> log.info("{}", l));
	}

	private void showCategory(Category c, int deep) {
		log.info("{}{}", "  ".repeat(deep), c);
		c.getChildren().forEach(cat -> showCategory(cat, deep + 1));
	}

	private StringBuilder categoryFullName(Category c) {
		var sb = new StringBuilder(c.getName());
		if (c.getParent() == null)
			return sb;
		return sb.insert(0, " > ") //
				.insert(0, categoryFullName(c.getParent()));
	}
}
