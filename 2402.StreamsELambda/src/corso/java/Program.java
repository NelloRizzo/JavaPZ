package corso.java;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

public class Program {

	public static void main(String[] args) {
		var li = new ArrayList<Integer>();
		var rnd = new Random(1);
		for (var counter = 0; counter < 30; ++counter)
			li.add(rnd.nextInt(0, 100));
		System.out.println("Tutti gli elementi");
		li.forEach(c -> System.out.println(c));
		System.out.println("Dopo le operazioni di streaming");
		int pageSize = 4;
		int page = 2;
		var l = li.stream() //
				// boolean test(Integer n) { return n > 50; }
				.filter(n -> n > 1) //
				.distinct() //
				.skip(page * pageSize) //
				.limit(pageSize) //
				.map(n -> n * n) //
				.map(n -> String.format("Numero: %s", n)) //
				.collect(Collectors.toList())
		// .forEach(c -> System.out.println(c))
		;
		Optional<String> first = l.stream().findAny();
		if (first.isEmpty())
			System.out.println("Nessun elemento trovato");
		else 
			System.out.println("Primo elemento: " + first.get());
		// .forEach(c -> System.out.println(c));
	}

}
