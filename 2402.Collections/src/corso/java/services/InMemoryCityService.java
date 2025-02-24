package corso.java.services;

import java.util.ArrayList;
import java.util.List;

import corso.java.data.City;

public class InMemoryCityService //
		implements CityService {

	private List<City> cities = new ArrayList<City>();

	@Override
	public void addCity(City c) {
		cities.add(c);
	}

	@Override
	public List<City> getAllCities() {
		return cities.stream().toList();
	}

	@Override
	public List<City> getAllCitiesByProvince(String province) {
		return cities.stream() //
				.filter(c -> c.getProvince().equals(province)) //
				.toList();
	}

	@Override
	public int count() {
		return cities.size();
	}

}
