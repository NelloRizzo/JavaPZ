package corso.java.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import corso.java.entities.Article;

@Repository
public interface ArticlesRepository extends JpaRepository<Article, Integer> {
	List<Article> findAllByPublishedAtBetween(LocalDateTime from, LocalDateTime to);
	List<Article> findAllByPublishedAtGreaterThan(LocalDateTime from);
	List<Article> findAllByContentContains(String content);
	List<Article> findAllByAuthorUsername(String username);
	List<Article> findAllByAuthorUsernameOrAuthorEmailContains(String username, String email);
	List<Article> findAllByAuthorUsernameAndPublishedAtBetween(String username, LocalDateTime from, LocalDateTime to);
}
