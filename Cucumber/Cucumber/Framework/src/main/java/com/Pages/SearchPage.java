package com.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage {
	
	private WebDriver driver;
	
	private By locationAberDeen = By.xpath("//span[text()='ABERDEEN']");
	private By locationBelfast = By.xpath("//span[text()='BELFAST']");
	private By buttonSearch = By.xpath("//button[text()='Search']");
	
	
	public SearchPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	public void clickLocation() {
		driver.findElement(locationAberDeen).click();
		System.out.println("Clicked on ABERDEEN location");
		driver.findElement(locationBelfast).click();
		System.out.println("Clicked on BELFAST location");
	}
	
	public void clickSearchButton() {
		driver.findElement(buttonSearch).click();
		System.out.println("Clicked on Search Button");
	}
	
	public void searchResults() {
		List<WebElement> listSearchProducts = driver.findElements(By.xpath("//td[@data-header='Product name']/span"));
		System.out.println("The total number of products displayed in sear tab is : "+listSearchProducts.size());
		System.out.println("The products displayed are : ");
		for(int i=0;i<listSearchProducts.size();i++) {
			System.out.println(listSearchProducts.get(i).getText().trim());
		}
	}
}
