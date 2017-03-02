package com.techelevator;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		VendingMachineCLI cli = context.getBean(VendingMachineCLI.class);
		cli.run();
	}
}
