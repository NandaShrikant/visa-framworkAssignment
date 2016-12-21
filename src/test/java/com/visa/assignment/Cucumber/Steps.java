package com.visa.assignment.Cucumber;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import com.visa.assignment.PageObjects.Homepage_PO;
import com.visa.assignment.PageObjects.MainMenu_PO;
import com.visa.assignment.PageObjects.Products_PO;
import cucumber.api.Scenario;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Steps {

	WebDriver driver = Hooks.driver;
	Scenario scenario;
	String targetURL = Hooks.targetURL;
	public static Properties env;
	
	@When("^a user launches the application$")
	public void startUp() throws Throwable {	
		driver.get(targetURL);
	}

	@Then("^the homepage is displayed$")
	public void getHomePage() throws Throwable {
		Homepage_PO objHP = new Homepage_PO(driver);
		objHP.checkPageDisplayed();
	}
		 
	@Then("^the main menu is available$")
	public void checkMainMenu() throws Throwable {
		MainMenu_PO objMenu = new MainMenu_PO(driver);
		objMenu.checkMenuEnabled();
	}
	
	@When("^a user selects \"(.*)\" from the menu$")
	public void selectMenuItem(String arg) throws Throwable {		
		MainMenu_PO objMenu = new MainMenu_PO(driver);
		objMenu.selectSpecificMenuItem(arg);
	}

	@Then("^the correct \"(.*)\" is displayed$")
	public void checkCorrectPageDisplayed(String arg) throws Throwable {		
		if (arg.equalsIgnoreCase("home")){
			Homepage_PO objHP = new Homepage_PO(driver);
		   objHP.checkPageDisplayed();
		}
		else
		{
			Products_PO objProduct = new Products_PO(driver);
			objProduct.checkPageDisplayed(arg);	
			
		}
	}

}
