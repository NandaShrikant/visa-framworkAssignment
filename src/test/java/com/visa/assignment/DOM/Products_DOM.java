package com.visa.assignment.DOM;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class Products_DOM {

	public static final String productTitle = " | ONLINE STORE";

	@FindBy(xpath = "//article[starts-with(@id, 'post-')]/header/h1")
	public static WebElement productHeader;

	@FindBy(xpath = "//form[@name='product_32']/div/div/span/input")
	public static WebElement iphoneBuy;
	@FindBy(xpath = "//form[@name='product_40']/div/div/span/input")
	public static WebElement magicMouseBuy;
	@FindBy(xpath = "//form[@name='product_64']/div/div/span/input")
	public static WebElement iPodNanoBuy;

	@FindBy(xpath = "//a[contains(text(),'iPhone 5')]")
	public static WebElement iphoneSelect;
	@FindBy(xpath = "//a[contains(text(),'Magic Mouse')]")
	public static WebElement magicMouseSelect;
	@FindBy(xpath = "//a[contains(text(),'iPod Nano')]")
	public static WebElement iPodNanoSelect;
	@FindBy(xpath = "//input[@name='Buy']")
	public static WebElement genericBuy;

	@FindAll(@FindBy(xpath = "//div[2]/h2/a"))
	public static List<WebElement> productList;
	@FindAll(@FindBy(xpath = "//div[2]/form/div[2]/div[1]/span/input"))
	public static List<WebElement> buyButtons;

}
