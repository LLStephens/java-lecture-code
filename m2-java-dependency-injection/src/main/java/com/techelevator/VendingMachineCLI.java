package com.techelevator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.techelevator.view.Menu;

@Component
public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS,
													    MAIN_MENU_OPTION_PURCHASE };
	
	private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
	private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
	private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";
	private static final String[] PURCHASE_MENU_OPTIONS = { PURCHASE_MENU_OPTION_FEED_MONEY,
															PURCHASE_MENU_OPTION_SELECT_PRODUCT,
															PURCHASE_MENU_OPTION_FINISH_TRANSACTION};
	
	private Menu menu;
	@Autowired
	private VendingMachine vendingMachine;
	
	public VendingMachineCLI() {
		menu = new Menu(System.in, System.out);
	}

	public void run() {
		while(true) {
			String choice = (String)menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			
			if(choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				System.out.println();
				vendingMachine.printInventory();
			} else if(choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				doPurchaseMenu();
			}
		}
	}
	
	private void doPurchaseMenu() {
		while(true) {
			System.out.print("\nCurrent Money Provided: " + vendingMachine.getBalance());
			
			String choice = (String)menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
			
			if(choice.equals(PURCHASE_MENU_OPTION_FEED_MONEY)) {
				feedMoney();
			} else if(choice.equals(PURCHASE_MENU_OPTION_SELECT_PRODUCT)) {
				selectProduct();
			} else if(choice.equals(PURCHASE_MENU_OPTION_FINISH_TRANSACTION)) {
				returnChange();
				break;
			}
		}
	}
	
	private void feedMoney() {
		int dollars = menu.getMoney();
		vendingMachine.addMoney(new DollarAmount(dollars * 100));
	}
	
	private void selectProduct() {
		System.out.println();
		vendingMachine.printInventory();
		String selection = menu.getProductSelection();
		vendingMachine.vendProduct(selection);
	}
	
	private void returnChange() {
		DollarAmount change = vendingMachine.cashOut();
		
		if(change.equals(DollarAmount.ZERO_DOLLARS)) {
			return;
		}
		
		int changeInPennies = change.getDollars() * 100 + change.getCents();
		int quarters = changeInPennies / 25;
		changeInPennies %= 25;
		int dimes = changeInPennies / 10;
		changeInPennies %= 10;
		int nickels = changeInPennies / 5;
		changeInPennies %= 5;
		
		System.out.print("\nYour change is ");
		
		if(quarters > 0) {
			System.out.print(quarters + " Quarter" + (quarters > 1 ? "s " : " "));
		}
		if(dimes > 0) {
			System.out.print(dimes + " Dime" + (dimes > 1 ? "s " : " "));
		}
		if(nickels > 0) {
			System.out.print(nickels + " Nickel" + (nickels > 1 ? "s " : " "));
		}
		if(changeInPennies > 0) {
			System.out.print(changeInPennies + " Penn" + (changeInPennies > 1 ? "ies " : "y "));
		}
		
		System.out.println();
	}
}













