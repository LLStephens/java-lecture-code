package com.techelevator.model.jdbc;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.DollarAmount;
import com.techelevator.model.Item;
import com.techelevator.model.ItemLoader;

@Component
@Qualifier("Database")
public class JDBCItemLoader implements ItemLoader {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	private void setDataSource(BasicDataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Item> loadItems() {
		System.out.println("----- Loading items from database -----");
		
		List<Item> items = new ArrayList<>();
		
		String sqlGetItems = "SELECT * FROM items";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetItems);
		
		while(results.next()) {
			Item item = new Item();
			item.setSlot(results.getString("slot"));
			item.setName(results.getString("name"));
			
			float priceFloat = results.getFloat("price");
			int priceInPennies = (int)(priceFloat * 100);
			item.setPrice(new DollarAmount(priceInPennies));
			
			items.add(item);
		}
		
		return items;
	}

}
