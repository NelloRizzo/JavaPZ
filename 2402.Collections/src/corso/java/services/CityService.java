package corso.java.services;

import java.util.List;

import corso.java.data.City;

public interface CityService {
	void addCity(City c);
	
	int count();

	List<City> getAllCities();

	List<City> getAllCitiesByProvince(String province);
}
