package corso.java.data.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import corso.java.data.entities.OrderedProductEntity;

public interface OrderedProductsRepository extends JpaRepository<OrderedProductEntity, Integer>{

	List<OrderedProductEntity> findAllByOrderId(int i);

}
