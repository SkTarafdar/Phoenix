package com.BasePackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	public WebDriver driver;
	
	public static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();
	
	/**This method is used to initiate the threadlocal driver on the basis of given browser**/
	public WebDriver initiateDriver(String browserName) {
		
		System.out.println("The browser name is : "+browserName );
		
		if(browserName.equals("Chrome")) {
			WebDriverManager.chromedriver().setup();
			threadLocalDriver.set(new ChromeDriver());
		}
		else if (browserName.equals("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			threadLocalDriver.set(new FirefoxDriver());
		}
		else {
			System.out.println("The browser name entered is not correct "+browserName);
		}
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();
	}
	/**this is used to get the driver with ThreadLocal**/
	public static synchronized WebDriver getDriver() {
		return threadLocalDriver.get();
	}
}
