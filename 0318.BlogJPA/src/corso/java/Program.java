package corso.java;

import java.time.LocalDateTime;

import corso.java.entities.Article;
import corso.java.entities.Role;
import corso.java.entities.User;
import jakarta.persistence.Persistence;

public class Program {

	private static final String JPA_UNIT = "JPAUnit";

	public static void main(String[] args) {
		var emf = Persistence.createEntityManagerFactory(JPA_UNIT);
		var em = emf.createEntityManager();
		var trans = em.getTransaction();
		trans.begin();

		var u1 = User.builder() //
				.withFriendlyName("Nello") //
				.withPassword("password") //
				.withUsername("nello") //
				.build();
		var u2 = User.builder() //
				.withFriendlyName("Ollen") //
				.withPassword("password") //
				.withUsername("nello") //
				.build();
		em.persist(u1);
		var a1 = Article.builder() //
				// .withId(1) //
				// .withAuthor("Nello") //
				.withAuthor(u1) //
				.withBody("Contenuto dell'articolo n. 1") //
				.withPublishedAt(LocalDateTime.now()) //
				.withTitle("Articolo n. 1") //
				.build();
		var a2 = Article.builder() //
				// .withId(1) //
				// .withAuthor("Nello") //
				.withAuthor(u1) //
				.withBody("Contenuto dell'articolo n. 2") //
				.withPublishedAt(LocalDateTime.now()) //
				.withTitle("Articolo n. 2") //
				.build();
		em.persist(a1);
		em.persist(a2);

		u1.getRoles().add(Role.builder().withName("admin").build());
		u1.getRoles().add(Role.builder().withName("users").build());
		em.persist(u1);
		var admins = em.find(Role.class, 1);
		u2.getRoles().add(admins);
		em.persist(u2);
		trans.commit();

		var entity = em.find(Article.class, a1.getId());
		System.out.println(entity);

		em.refresh(u1);
		u1.getArticles().stream().forEach(System.out::println);
		em.refresh(admins);
		admins.getUsers().stream().forEach(System.out::println);
	}

}
