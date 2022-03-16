package com.Runner;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.BasePackage.ConfigReader;
import com.BasePackage.DriverFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class EnvironmentHooks {
	
	private DriverFactory driverFactory;
	private WebDriver driver ;
	private ConfigReader configReader;
	
	@Before(order=0)
	public void launchBrowser() {
		configReader = new ConfigReader();
		String browserName = configReader.initialiseProperties("Browser");
		driverFactory = new DriverFactory();
		driver = driverFactory.initiateDriver(browserName);
	}

	@After(order=0)
	public void quitBroswer() {
		driver.quit();
	}
	
	@After
	public void screenShot(Scenario scenario) {
		String screenshotName = scenario.getName().replaceAll(" ", "_");
		byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(sourcePath, "image/png", screenshotName);
	}
}
