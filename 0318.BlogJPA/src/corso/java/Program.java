package corso.java;

import java.time.LocalDateTime;

import corso.java.entities.Article;
import jakarta.persistence.Persistence;

public class Program {

	private static final String JPA_UNIT = "JPAUnit";
	public static void main(String[] args) {
		var emf = Persistence.createEntityManagerFactory(JPA_UNIT);
		var em = emf.createEntityManager();
		
		var a1 = Article.builder() //
				//.withId(1) //
				.withAuthor("Nello") //
				.withBody("Contenuto dell'articolo n. 1") //
				.withPublishedAt(LocalDateTime.now()) //
				.withTitle("Articolo n. 1") //
				.build();
		var trans = em.getTransaction();
		trans.begin();
		em.persist(a1);
		trans.commit();
		
		var entity = em.find(Article.class, 1);
		System.out.println(entity);
	}

}
