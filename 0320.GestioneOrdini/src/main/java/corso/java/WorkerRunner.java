package corso.java;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import corso.java.data.entities.CustomerEntity;
import corso.java.data.entities.DishEntity;
import corso.java.data.entities.DrinkEntity;
import corso.java.data.entities.OrderEntity;
import corso.java.data.entities.OrderedProductEntity;
import corso.java.data.repositories.CustomersRepository;
import corso.java.data.repositories.OrderedProductsRepository;
import corso.java.data.repositories.OrdersRepository;
import corso.java.data.repositories.ProductsRepository;

@Component
public class WorkerRunner implements CommandLineRunner {
	private static final Logger log = LoggerFactory.getLogger(WorkerRunner.class);
	@Autowired
	private CustomersRepository customers;
	@Autowired
	private OrderedProductsRepository orderedProducts;
	@Autowired
	private ProductsRepository products;
	@Autowired
	private OrdersRepository orders;

	@Override
	public void run(String... args) throws Exception {
		products.saveAll(List.of( //
				DishEntity.builder().withName("Panino").withUnitPrice(BigDecimal.valueOf(2.5)).withUnitMeasure("pz")
						.build(),
				DishEntity.builder().withName("Pizzetta").withUnitPrice(BigDecimal.valueOf(1.5)).withUnitMeasure("pz")
						.build(),
				DishEntity.builder().withName("Pasta").withUnitPrice(BigDecimal.valueOf(4.5)).withUnitMeasure("piatto")
						.build(),
				DishEntity.builder().withName("Carne").withUnitPrice(BigDecimal.valueOf(5)).withUnitMeasure("pz")
						.build(),
				DrinkEntity.builder().withName("Coca Cola").withMl(33).withUnitPrice(BigDecimal.valueOf(1.5)).build(),
				DrinkEntity.builder().withName("The alla pesca").withMl(33).withUnitPrice(BigDecimal.valueOf(1.5))
						.build(),
				DrinkEntity.builder().withName("The al limone").withMl(33).withUnitPrice(BigDecimal.valueOf(1.5))
						.build(),
				DrinkEntity.builder().withName("Birra Peroni").withMl(33).withUnitPrice(BigDecimal.valueOf(1.8))
						.build(),
				DrinkEntity.builder().withName("Birra Peroni").withMl(75).withUnitPrice(BigDecimal.valueOf(3))
						.build()));
		products.findAll().forEach(p -> log.info("{}", p));

		customers.save(CustomerEntity.builder().withFirstName("Nello").withLastName("Rizzo").build());
		orders.save(OrderEntity.builder() //
				.withCompleted(false) //
				.withCustomer(customers.findById(1).orElseThrow()) //
				.withDateTime(LocalDateTime.now()) //
				.withNumber("2503210001") //
				.build());

		var o = orders.findById(1).orElseThrow();
		orderedProducts.save(OrderedProductEntity.builder() //
				.withOrder(o) //
				.withProduct(products.findById(1).orElseThrow()) //
				.withQuantity(1) //
				.build());
		orderedProducts.save(OrderedProductEntity.builder() //
				.withOrder(o) //
				.withProduct(products.findById(2).orElseThrow()) //
				.withQuantity(2) //
				.build());
		orderedProducts.save(OrderedProductEntity.builder() //
				.withOrder(o) //
				.withProduct(products.findById(3).orElseThrow()) //
				.withQuantity(3) //
				.build());
		log.info("Ordine: {}", o);
		log.info("Prodotti:");
		orderedProducts.findAllByOrderId(o.getId()).forEach(i -> log.info("{}", i));;
	}

}
