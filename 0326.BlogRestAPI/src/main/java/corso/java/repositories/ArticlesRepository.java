package corso.java.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import corso.java.entities.ArticleEntity;

public interface ArticlesRepository extends JpaRepository<ArticleEntity, Integer>{

}
