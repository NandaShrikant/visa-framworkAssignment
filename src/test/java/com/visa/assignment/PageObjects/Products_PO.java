package com.visa.assignment.PageObjects;

import org.openqa.selenium.WebDriver;
import com.visa.assignment.DOM.Products_DOM;
import com.visa.assignment.SeleniumDSL.BasePage;

public class Products_PO extends BasePage {

	public Products_PO(WebDriver driver) {
		super(driver, Products_DOM.class);
	}

	public void checkPageDisplayed(String arg) throws InterruptedException {
		validatePageTitleEquals(arg + Products_DOM.productTitle);
		validateElementTextEquals(Products_DOM.productHeader, arg);

	}
}
