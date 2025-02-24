package corso.java;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class Program {

	static void print(Collection<Integer> coll) {
		for (var c : coll)
			System.out.println(c);
	}

	public static void main(String[] args) {
		var li = new ArrayList<Integer>();
		var rnd = new Random(1);
		for (var i = 0; i < 10; ++i) {
			li.add(rnd.nextInt(0, 1000));
		}
		print(li);
		var le = new ArrayList<Integer>();
		for (var c : li) {
			if (c % 2 == 0)
				le.add(c);
		}
		System.out.println("Lista con tutti i numeri pari");
		print(le);
		System.out.println("Uso di stream");
		var s = li.stream() //
				.filter(c -> c % 2 == 0) //
				.filter(a -> a > 300) //
				.map(e -> String.format("Numero: %d", e)) //
				.filter(c -> c.contains("4"))
				;
		
		li.add(1231);
		li.add(1232);
		li.add(1233);
		
		s.forEach(c -> System.out.println(c));
	}

}
