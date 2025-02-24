package corso.java.services;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import corso.java.data.MenuItem;

public class InMemoryMenuService implements MenuService {

	private Set<MenuItem> menu = new HashSet<MenuItem>();

	@Override
	public void add(MenuItem item) {
		menu.add(item);
	}

	@Override
	public List<MenuItem> getAll() {
		return menu.stream().toList();
	}

	@Override
	public List<MenuItem> getAllByNameContains(String name) {
		return menu.stream() //
				.filter(i -> i.getName().contains(name)) //
				.toList();
	}

}
