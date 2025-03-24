package corso.java.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import corso.java.data.entities.OrderEntity;

public interface OrdersRepository extends JpaRepository<OrderEntity, Integer>{

}
