package corso.java;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import corso.java.entities.joined.Car;
import corso.java.entities.joined.Vehicle;
import corso.java.entities.mappedsuperclass.ProductEntity;
import corso.java.entities.singletable.Apple;
import corso.java.entities.singletable.Book;
import corso.java.entities.singletable.Product;
import corso.java.entities.table.CreditCardPayment;
import corso.java.entities.table.Payment;
import corso.java.repositories.PaymentsRepository;
import corso.java.repositories.ProductEntitiesRepositories;
import corso.java.repositories.ProductsRepository;
import corso.java.repositories.VehiclesRepository;

@Component
public class MainRunner implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(MainRunner.class);
	@Autowired
	private ProductsRepository products;

	@Autowired
	private VehiclesRepository vehicles;

	@Autowired
	private PaymentsRepository payments;

	@Autowired
	private ProductEntitiesRepositories pe;

	@Override
	public void run(String... args) throws Exception {
		var p = Product.builder().withName("Prodotto").withPrice(10.0).build();
		var b = new Book("Libro", 10.0, "Autore", 2025);
		var a = new Apple(5.0, "Gloden delicious", 5);
		products.saveAll(List.of(p, b, a));

		products.findAll().forEach(i -> log.info("{}", i));

		var v = new Vehicle("Fabbrica");
		var c = new Car("Fiat", 5);
		vehicles.saveAll(List.of(v, c));
		vehicles.findAll().forEach(i -> log.info("{}", i));

		vehicles.findById(2).ifPresent(veh -> {
			if (veh instanceof Car car)
				log.info("{}", car);
		});

		var pay = new Payment(10.0);
		var cpay = new CreditCardPayment(20.0, "12345");
		payments.saveAll(List.of(pay, cpay));
		payments.findAll().forEach(i -> log.info("{}", i));

		pe.save(new ProductEntity("Prodotto 1", 1.0));
		pe.save(new ProductEntity("Prodotto 2", 2.0));
		
		pe.findAll().forEach(i -> log.info("{}", i));

	}

}
