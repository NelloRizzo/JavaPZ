package corso.java.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import corso.java.data.entities.ProductEntity;

public interface ProductsRepository extends JpaRepository<ProductEntity, Integer> {

}
