package corso.java.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import corso.java.entities.singletable.Product;

public interface ProductsRepository extends JpaRepository<Product, Integer> {

}
