package com.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Mobile_SearchPage {
	
private WebDriver driver;
	
	private By txtBoxUserName = By.xpath("//input[@id='Input_UsernameVal3']");
	private By txtBoxPassword = By.xpath("//input[@id='Input_Password']");
	private By btnLogin = By.xpath("//button[text()='Login']");
	private By locationAberDeen = By.xpath("//span[text()='ABERDEEN']");
	private By locationBelfast = By.xpath("//span[text()='BELFAST']");
	
	
	public Mobile_SearchPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public void enterUsername(String userName) {
		WebElement iFrame = driver.findElement(By.xpath("//iframe[@id='contents_frame']"));
		driver.switchTo().frame(iFrame);
		driver.findElement(txtBoxUserName).clear();
		driver.findElement(txtBoxUserName).sendKeys(userName);
		System.out.println("Entered username");
	}
	
	public void enterPassword(String password) {
		driver.findElement(txtBoxPassword).clear();
		driver.findElement(txtBoxPassword).sendKeys(password);
		System.out.println("Entered password");
	}
	
	public void clickLoginButton() {
		driver.findElement(btnLogin).click();
		System.out.println("Clicked on Login button");
	}
	
	public void clickLocation() {
		driver.findElement(locationAberDeen).click();
		System.out.println("Clicked on ABERDEEN location");
		driver.findElement(locationBelfast).click();
		System.out.println("Clicked on BELFAST location");
	}
	
	public void clickSearchButton() {
		WebElement buttonSearch = driver.findElement(By.xpath("//button[text()='Search']"));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Scrolling down the page till the element is found		
        js.executeScript("arguments[0].scrollIntoView();", buttonSearch);
//		Actions act = new Actions(driver);
//		act.moveToElement(buttonSearch).build().perform();
//		act.click(buttonSearch).build().perform();
		buttonSearch.click();
		System.out.println("Clicked on Search Button");
	}
	
	public void searchResults() {
		List<WebElement> listSearchProducts = driver.findElements(By.xpath("//div[@class='custom-align-center']//span"));
		System.out.println("The total number of products displayed in sear tab is : "+listSearchProducts.size());
		System.out.println("The products displayed are : ");
		for(int i=0;i<listSearchProducts.size();i++) {
			System.out.println(listSearchProducts.get(i).getText().trim());
		}
	}

}
