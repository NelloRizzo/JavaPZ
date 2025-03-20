package corso.java.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import corso.java.entities.Category;

public interface CategoriesRepository extends JpaRepository<Category, Integer> {
	/**
	 * Cerca le categorie che in cui il campo PARENT è NULL. <br/>
	 * Si tratta di un esempio per mostrare l'uso di @Query: avremmo ottenuto lo
	 * stesso risultato scrivendo un metodo che si chiamasse findAllByParentIsNull()
	 */
	@Query("FROM Category c WHERE c.parent IS NULL")
	List<Category> findMainCategories();
}
