package com.visa.assignment.Cucumber;


import java.io.IOException;
import java.net.InetAddress;
import java.util.Properties;

import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import com.visa.assignment.SeleniumDSL.Screenshot;
import com.visa.assignment.Utils.Environment;
import com.visa.assignment.Utils.Log;
public class Hooks
{
	public static WebDriver driver;
	public static String targetURL;
	Scenario scenario;
	//-----------Before Hook-----------------------------//
	static // This block is of only use to disable the unnecessary html unit browser logs.
	{
	 //java.util.logging.Logger.getLogger("com.gargoylesoftware.htmlunit").setLevel(java.util.logging.Level.OFF);
	 LogFactory.getFactory().setAttribute("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.NoOpLog");
	}
	@Before
	public void beforestartUp(Scenario scenario) throws IOException {
		Log.startTestScenario(scenario.getName());
		this.scenario = scenario;
		Properties env  = Environment.getProperties();
		targetURL = env.getProperty("URL");
		if(env.getProperty("Browser").equalsIgnoreCase("firefox")){
			 driver = new FirefoxDriver();
			 driver.manage().window().maximize();
		}
			
		 
		if(env.getProperty("Browser").equalsIgnoreCase("chrome")){
			System.out.println( System.getProperty("user.dir")+"//"+env.getProperty("chromeDriver"));
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//"+env.getProperty("chromeDriver"));
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}
		
		if(env.getProperty("Browser").equalsIgnoreCase("htmlunit")){ //Handled the proxy for berjenk server- SN
			driver = new HtmlUnitDriver();
		}
		
		
	}
	//-----------After Hook-----------------------------//
	
	@After
	public void after (Scenario scenario) throws IOException, InterruptedException {
		Log.endTestScenario(scenario.getName());
		Properties env  = Environment.getProperties();
		if (scenario.isFailed() && !env.getProperty("Browser").equalsIgnoreCase("htmlunit") ) 
			Screenshot.grabScreenshotForReport(driver, scenario);	
			driver.quit();	
	}
}
