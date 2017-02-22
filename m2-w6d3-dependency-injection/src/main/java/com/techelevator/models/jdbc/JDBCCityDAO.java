package com.techelevator.models.jdbc;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.models.City;
import com.techelevator.models.CityDAO;

@Component
@Primary
public class JDBCCityDAO implements CityDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDatasource(BasicDataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void save(City newCity) {
		String sqlInsertCity = "INSERT INTO city(id, name, countrycode, district, population) " +
							   "VALUES(?, ?, ?, ?, ?)";
		newCity.setId(getNextCityId());
		jdbcTemplate.update(sqlInsertCity, newCity.getId(),
										  newCity.getName(),
										  newCity.getCountryCode(),
										  newCity.getDistrict(),
										  newCity.getPopulation());
	}
	
	@Override
	public City findCityById(long id) {
		City theCity = null;
		String sqlFindCityById = "SELECT id, name, countrycode, district, population "+
							   "FROM city "+
							   "WHERE id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindCityById, id);
		if(results.next()) {
			theCity = mapRowToCity(results);
		}
		return theCity;
	}

	@Override
	public List<City> findCityByCountryCode(String countryCode) {
		ArrayList<City> cities = new ArrayList<>();
		String sqlFindCityByCountryCode = "SELECT id, name, countrycode, district, population "+
										   "FROM city "+
										   "WHERE countrycode = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindCityByCountryCode, countryCode);
		while(results.next()) {
			City theCity = mapRowToCity(results);
			cities.add(theCity);
		}
		return cities;
	}

	@Override
	public List<City> findCityByDistrict(String district) {
		ArrayList<City> cities = new ArrayList<City>();
		
		String sqlFindCityByDistrict = "SELECT id, name, countrycode, district, population " +
										"FROM city " +
										"WHERE district = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindCityByDistrict, district);
		while(results.next()) {
			City theCity = mapRowToCity(results);
			cities.add(theCity);
		}
		
		return cities;
	}

	@Override
	public void update(City city) {
		String sqlUpdateCity = "UPDATE city " +
								"SET (name, countrycode, district, population) = (?, ?, ?, ?) " +
								"WHERE id = ?";
		jdbcTemplate.update(sqlUpdateCity, city.getName(), city.getCountryCode(), city.getDistrict(), city.getPopulation(), city.getId());
	}

	@Override
	public void delete(long id) {
		String sqlDeleteCity = "DELETE FROM city WHERE id = ?";
		jdbcTemplate.update(sqlDeleteCity, id);
	}

	private long getNextCityId() {
		SqlRowSet nextIdResult = jdbcTemplate.queryForRowSet("SELECT nextval('seq_city_id')");
		if(nextIdResult.next()) {
			return nextIdResult.getLong(1);
		} else {
			throw new RuntimeException("Something went wrong while getting an id for the new city");
		}
	}

	private City mapRowToCity(SqlRowSet results) {
		City theCity;
		theCity = new City();
		theCity.setId(results.getLong("id"));
		theCity.setName(results.getString("name"));
		theCity.setCountryCode(results.getString("countrycode"));
		theCity.setDistrict(results.getString("district"));
		theCity.setPopulation(results.getInt("population"));
		return theCity;
	}
}














