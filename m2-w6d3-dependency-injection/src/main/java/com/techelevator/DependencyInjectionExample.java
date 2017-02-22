package com.techelevator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.techelevator.models.City;
import com.techelevator.models.CityDAO;

@Component
public class DependencyInjectionExample {

	private CityDAO cityDao;
	
	@Autowired
	public void setCityDAO(CityDAO cityDao) {
		this.cityDao = cityDao;
	}
	
	public void start() {
		List<City> ohioCities = cityDao.findCityByDistrict("Ohio");
		
		for(City city : ohioCities) {
			System.out.println(city.getName());
		}
	}
}
