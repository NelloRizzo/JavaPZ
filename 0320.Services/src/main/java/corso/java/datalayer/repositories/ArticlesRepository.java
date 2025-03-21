package corso.java.datalayer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import corso.java.datalayer.entities.ArticleEntity;

public interface ArticlesRepository extends JpaRepository<ArticleEntity, Integer> {

}
