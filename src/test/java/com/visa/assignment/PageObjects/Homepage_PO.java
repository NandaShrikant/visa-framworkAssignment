package com.visa.assignment.PageObjects;

import org.openqa.selenium.WebDriver;

import com.visa.assignment.DOM.Homepage_DOM;
import com.visa.assignment.SeleniumDSL.BasePage;

public class Homepage_PO extends BasePage{

	public Homepage_PO(WebDriver driver) {
		super(driver, Homepage_DOM.class);
	}
	
	public void checkPageDisplayed(){
		validatePageTitleEquals(Homepage_DOM.pageTitle);
		validateElementVisible(Homepage_DOM.logo, "logo");
	}

}
