package corso.java.services;

import java.util.List;

import corso.java.data.MenuItem;

public interface MenuService {
	void add(MenuItem item);

	List<MenuItem> getAll();

	List<MenuItem> getAllByNameContains(String name);
}
