package com.techelevator.model.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.techelevator.DollarAmount;
import com.techelevator.model.Item;
import com.techelevator.model.ItemLoader;

@Component
@Qualifier("File")
public class FileItemLoader implements ItemLoader {

	private static final String FILE_PATH = "vendingmachine.csv";

	@Override
	public List<Item> loadItems() {
		System.out.println("----- Loading items from file -----");
		
		List<Item> items = new ArrayList<>();
		File itemFile = new File(FILE_PATH);
		
		try(Scanner input = new Scanner(itemFile)) {
			while(input.hasNextLine()) {
				String line = input.nextLine();
				String[] parts = line.split("\\|");
				
				Item item = new Item();
				item.setSlot(parts[0]);
				item.setName(parts[1]);
				
				float priceFloat = Float.parseFloat(parts[2]);
				int priceInPennies = (int)(priceFloat * 100);
				item.setPrice(new DollarAmount(priceInPennies));
				
				items.add(item);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return items;
	}
}
