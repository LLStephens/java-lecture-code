package com.techelevator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.techelevator.models.CityDAO;

@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:beans.xml")
public class DependencyInjectionExampleTests {

	@Autowired
	@Qualifier("Mock")
	private CityDAO cityDao;
	
	private DependencyInjectionExample example;
	
	@Before
	public void setup() {
		example = new DependencyInjectionExample();
		example.setCityDAO(cityDao);
	}
	
	@Test
	public void testStart() {
		example.start();
	}
}
