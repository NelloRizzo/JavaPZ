package corso.java;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Program {

	public static void main(String[] args) {
		Collection<String> c = new ArrayList<String>(20);
		c.add("Uno");
		c.add("Due");
		c.add("Tre");
		System.out.printf("Totale elementi: %d%n", c.size());
		if (c.contains("Tre"))
			System.out.println("La collection contiene l'elemento");
		else
			System.out.println("L'elemento non è presente");

		c.remove("Due");
		System.out.printf("Totale elementi: %d%n", c.size());
		System.out.println("Attravesamento tramite iteratore");
		var it = c.iterator();
		while (it.hasNext())
			System.out.println(it.next());
		System.out.println("Attraversamento tramite enhanced-for");
		// enhanced for
		for (var item : c) {
			System.out.println(item);
		}
		List<String> ls = new ArrayList<String>();
		ls.add("Uno");
		ls.add("Due");
		ls.add("Tre");
		System.out.printf("Secondo elemento: %s%n", ls.get(1));
		ls.add(2, "Due e mezzo");
		for (var i : ls) {
			System.out.println(i);
		}
		ls.set(1, "DUE");
		for (var i : ls) {
			System.out.println(i);
		}
		Set<String> s = new HashSet<String>();
		s.add("Uno");
		s.add("Uno");
		s.add("Uno");
		s.add("Uno");
		s.add("Uno");
		System.out.println(s.size());

		Deque<String> st = new LinkedList<String>();
		st.offer("Uno");
		st.offer("Due");
		st.push("Tre");

		for (var i : st) {
			System.out.println(i);
		}
		System.out.println("Rimozione da testa " + st.pop());
		System.out.println("Rimozione da coda " + st.removeLast());
	}

}
