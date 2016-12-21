package com.visa.assignment.Cucumber;

import org.apache.log4j.BasicConfigurator;
import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = "./Features"
		,glue = "com.visa.assignment.Cucumber"
		,plugin={"pretty", "json:Reports/JSON/cucumber.json"}
		,tags="@StartUp"
		)

public class TestRunner {	
	public static void main(String[] args) throws Exception{
		BasicConfigurator.configure(); 
		JUnitCore.main("com.visa.assignment.Cucumber.TestRunner");
	}

}

