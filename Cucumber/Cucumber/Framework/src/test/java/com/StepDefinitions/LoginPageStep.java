package com.StepDefinitions;

import org.testng.Assert;

import com.BasePackage.ConfigReader;
import com.BasePackage.DriverFactory;
import com.Pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageStep {
	
	private ConfigReader configReader;
	private String pageTtile;
	private String userName;
	private String passWord;
	
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	
	@Given("User is in Login Page")
	public void user_is_in_login_page() {
		configReader = new ConfigReader();
		String url = configReader.initialiseProperties("URL");
		DriverFactory.getDriver().get(url);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@When("user gets the title of the Page")
	public void user_gets_the_title_of_the_page() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pageTtile = loginPage.getPageTitle();
		System.out.println("The Page title is displayed as "+pageTtile);  
	}

	@Then("Page title should be {string}")
	public void page_title_should_be(String expectedTitle) {
		Assert.assertEquals(expectedTitle,pageTtile);
		
	}

	@Then("Email field is displayed")
	public void email_field_is_displayed() {
		Assert.assertTrue(loginPage.isEmailTxtBoxPresent());
		System.out.println("Email field is present"); 
	    
	}

	@Then("Password field is displayed")
	public void password_field_is_displayed() {
		Assert.assertTrue(loginPage.isPasswordTxtBoxPresent());
		System.out.println("Password field is present");
	    
	}

	@Then("Login button is displayed")
	public void login_button_is_displayed() {
		Assert.assertTrue(loginPage.isLoginButtonPresent());
		System.out.println("Login button is present");
	    
	}

	@When("user enters username {string}")
	public void user_enters_username(String user) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		configReader = new ConfigReader();
		userName = configReader.initialiseProperties(user);
	    loginPage.enterUsername(userName); 
	}

	@When("user enters password {string}")
	public void user_enters_password(String pwd) {
		configReader = new ConfigReader();
		passWord = configReader.initialiseProperties(pwd);
	    loginPage.enterPassword(passWord);	    
	}

	@When("user clicks on Login button")
	public void user_clicks_on_login_button() {
		loginPage.clickLoginButton();   
	}

}
