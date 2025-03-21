package corso.java.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import corso.java.entities.mappedsuperclass.ProductEntity;

public interface ProductEntitiesRepositories extends JpaRepository<ProductEntity, Integer>{

}
