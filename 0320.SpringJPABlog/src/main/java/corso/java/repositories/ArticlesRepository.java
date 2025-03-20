package corso.java.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import corso.java.entities.Article;

@Repository
public interface ArticlesRepository extends JpaRepository<Article, Integer>{

}
