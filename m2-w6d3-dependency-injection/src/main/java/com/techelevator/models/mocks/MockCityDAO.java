package com.techelevator.models.mocks;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.techelevator.models.City;
import com.techelevator.models.CityDAO;

@Component
@Qualifier("Mock")
public class MockCityDAO implements CityDAO {

	List<City> cities = new ArrayList<City>();

	public MockCityDAO() {
		cities.add(createCity(1l, "Athens", "USA", "Ohio", 24122));
		cities.add(createCity(2l, "Canton", "USA", "Ohio", 72535));
		cities.add(createCity(3l, "Peebles", "USA", "Ohio", 1771));
		cities.add(createCity(4l, "Beevercreek", "USA", "Ohio", 45712));
	}

	@Override
	public void save(City newCity) {
		cities.add(newCity);
	}

	@Override
	public City findCityById(long id) {
		for(City city : cities) {
			if(city.getId().equals(id)) {
				return city;
			}
		}
		return null;
	}

	@Override
	public List<City> findCityByCountryCode(String countryCode) {
		List<City> citiesInCountry = new ArrayList<City>();
		
		for(City city : cities) {
			if(city.getCountryCode().equals(countryCode)) {
				citiesInCountry.add(city);
			}
		}
		
		return citiesInCountry;
	}

	@Override
	public List<City> findCityByDistrict(String district) {
		List<City> citiesInCountry = new ArrayList<City>();
		
		for(City city : cities) {
			if(city.getDistrict().equals(district)) {
				citiesInCountry.add(city);
			}
		}
		
		return citiesInCountry;
	}

	@Override
	public void update(City city) {
		delete(city.getId());
		cities.add(city);
	}

	@Override
	public void delete(long id) {
		City oldCity = findCityById(id);
		cities.remove(oldCity);
	}
	
	private City createCity(Long id, String name, String countryCode, String district, int population) {
		City theCity = new City();
		theCity.setId(id);
		theCity.setName(name);
		theCity.setCountryCode(countryCode);
		theCity.setDistrict(district);
		theCity.setPopulation(population);
		return theCity;
	}
}
