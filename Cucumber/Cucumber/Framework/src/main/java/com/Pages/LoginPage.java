package com.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

private WebDriver driver;
	
	//WebApp
	private By txtBoxEmail = By.xpath("//input[@id='b3-InputUsername']");
	private By txtBoxPassword = By.xpath("//input[@id='b3-InputPassword']");
	private By btnLogin = By.xpath("//button[@type='submit']");
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public boolean isEmailTxtBoxPresent() {
		return driver.findElement(txtBoxEmail).isDisplayed();
	}
	
	public boolean isPasswordTxtBoxPresent() {
		return driver.findElement(txtBoxPassword).isDisplayed();
	}
	
	public boolean isLoginButtonPresent() {
		return driver.findElement(btnLogin).isDisplayed();
	}
	
	public void enterUsername(String userName) {
		driver.findElement(txtBoxEmail).clear();
		driver.findElement(txtBoxEmail).sendKeys(userName);
		System.out.println("Entered email id");
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
}