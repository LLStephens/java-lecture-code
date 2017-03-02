package com.techelevator;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

import com.techelevator.model.Item;

@Component
public class TransactionLogger {
	private static final String LOG_FILE = "TransactionLog.txt";
	private PrintWriter output;
	private DateTimeFormatter formatter;

	public TransactionLogger() {
		formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm A");

		try {
			output = new PrintWriter(new File(LOG_FILE));
		} catch(IOException ex) {
			System.err.println("Failed to create Transaction Log!");
		}
	}
	
	public void logMoneyFeed(DollarAmount amount) {
		timeStampLog("FEED MONEY " + amount);
	}
	
	public void logVendProduct(Item item) {
		timeStampLog(String.format("%s %s %s", item.getName(), item.getSlot(), item.getPrice()));
	}
	
	public void logCashOut(DollarAmount amount) {
		timeStampLog("CASH OUT " + amount);
	}
	
	private void timeStampLog(String value) {
		if(output != null) {
			LocalDateTime now = LocalDateTime.now();
			output.print(now.format(formatter));
			output.print(" ");
			output.println(value);
			output.flush();
		}
	}
}
