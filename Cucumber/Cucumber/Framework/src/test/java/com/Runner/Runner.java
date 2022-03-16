package com.Runner;

import org.testng.annotations.DataProvider;

import com.BasePackage.BaseDriver;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = {"src/test/resources/Feature Files/loginPage.feature",
				"src/test/resources/Feature Files/searchPage.feature",
				"src/test/resources/Feature Files/Mobile_Search.feature"},
		glue = {"com.StepDefinitions","com.Runner"},
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		)

public class Runner extends BaseDriver {
	
	
	 @Override
	 @DataProvider(parallel = false) 
	 public Object[][] scenarios() {
		 return super.scenarios();
	}
	 
}
