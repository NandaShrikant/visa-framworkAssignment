package com.visa.assignment.PageObjects;

import org.openqa.selenium.WebDriver;

import com.visa.assignment.DOM.MainMenu_DOM;
import com.visa.assignment.SeleniumDSL.BasePage;

public class MainMenu_PO extends BasePage {

	public MainMenu_PO(WebDriver driver) {
		super(driver, MainMenu_DOM.class);
	}
	
	public void checkMenuEnabled() throws InterruptedException{
		validateElementVisible(MainMenu_DOM.menuHome, "home menu");
		validateElementVisible(MainMenu_DOM.menuProductCategory, "product category menu");
		validateElementVisible(MainMenu_DOM.menuAllProducts, "all products menu");
		validateElementVisible(MainMenu_DOM.menuBasket, "basket menu");
	}
	
public void selectSpecificMenuItem(String arg) throws InterruptedException, Throwable {
		
		if (arg.equalsIgnoreCase(MainMenu_DOM.home))
			click(MainMenu_DOM.menuHome);
		
		if (arg.equalsIgnoreCase(MainMenu_DOM.allProduct))
			click(MainMenu_DOM.menuAllProducts);
		
		if (arg.equalsIgnoreCase(MainMenu_DOM.accessories)){
			performActionsClick(MainMenu_DOM.menuProductCategory, MainMenu_DOM.menuAccessories);
		}
		
		if (arg.equalsIgnoreCase(MainMenu_DOM.iMacs)){
			performActionsClick(MainMenu_DOM.menuProductCategory, MainMenu_DOM.menuiMacs);
		}
			
		if (arg.equalsIgnoreCase(MainMenu_DOM.iPads)){
			performActionsClick(MainMenu_DOM.menuProductCategory, MainMenu_DOM.menuiPads);
		}
		
		if (arg.equalsIgnoreCase(MainMenu_DOM.iPhones)){
			performActionsClick(MainMenu_DOM.menuProductCategory, MainMenu_DOM.menuiPhones);
		}
			
		if (arg.equalsIgnoreCase(MainMenu_DOM.iPods)){
			performActionsClick(MainMenu_DOM.menuProductCategory, MainMenu_DOM.menuiPods);
		}
		
		if (arg.equalsIgnoreCase(MainMenu_DOM.macBooks)){
			performActionsClick(MainMenu_DOM.menuProductCategory, MainMenu_DOM.menuMacBooks);
		}
	}

}
