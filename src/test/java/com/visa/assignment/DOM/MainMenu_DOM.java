package com.visa.assignment.DOM;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class MainMenu_DOM {
	
	public static final String home 		= "home";
	public static final String allProduct 	= "all products";
	public static final String accessories 	= "product category - accessories";
	public static final String iMacs 		= "product category - iMacs";
	public static final String iPads 		= "product category - iPads";
	public static final String iPhones 		= "product category - iPhones";
	public static final String iPods 		= "product category - iPods";
	public static final String macBooks 	= "product category - MacBooks";
	
	@FindBy(id="menu-item-15") 		public static 		WebElement menuHome;	
	@FindBy(id="menu-item-33") 		public static 		WebElement menuProductCategory;	
	@FindBy(id="menu-item-72") 		public static 		WebElement menuAllProducts;	
	@FindBy(id="header_cart") 		public static 		WebElement menuBasket;
	@FindBy(linkText="Accessories") public static 		WebElement menuAccessories;
	@FindBy(linkText="iMacs") 		public static 		WebElement menuiMacs;
	@FindBy(linkText="iPads") 		public static 		WebElement menuiPads;
	@FindBy(linkText="iPhones") 	public static 		WebElement menuiPhones;
	@FindBy(linkText="iPods") 		public static 		WebElement menuiPods;
	@FindBy(linkText="MacBooks")	public static 		WebElement menuMacBooks;
	
	@FindAll(@FindBy(xpath="//li[starts-with(@id,'menu-item-33')]//ul[starts-with(@class, 'sub-menu')]/li")) public static List<WebElement> allMenuItems;
	
	@FindBy(xpath=".//*[@id='header_cart']/a/span[1]") public static 		WebElement basketButton;
	
	
	
}
