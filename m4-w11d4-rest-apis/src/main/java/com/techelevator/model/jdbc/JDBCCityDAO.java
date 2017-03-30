package com.techelevator.model.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.City;
import com.techelevator.model.CityDAO;

@Component
public class JDBCCityDAO implements CityDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JDBCCityDAO(DataSource datasource) {
		jdbcTemplate = new JdbcTemplate(datasource);
	}
	
	public List<City> getAllCities() {
		List<City> cities = new ArrayList<City>();
		
		String sql = "SELECT * FROM city";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		
		while(results.next()) {
			cities.add(mapRowToCity(results));
		}
		
		return cities;
	}
	
	private City mapRowToCity(SqlRowSet row) {
		City city = new City();
		
		city.setId(row.getLong("id"));
		city.setName(row.getString("name"));
		city.setCountryCode(row.getString("countryCode"));
		city.setDistrict(row.getString("district"));
		city.setPopulation(row.getLong("population"));
		
		return city;
	}
}
