package com.StepDefinitions;

import com.BasePackage.ConfigReader;
import com.BasePackage.DriverFactory;
import com.Pages.Mobile_SearchPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Mobile_SearchPageStep {
	
	private ConfigReader configReader;
	private String userName;
	private String passWord;
	
	private Mobile_SearchPage mobile_SearchPage = new Mobile_SearchPage(DriverFactory.getDriver());
	
	
	@Given("User is in Mobile App")
	public void user_is_in_mobile_app() {
		
		configReader = new ConfigReader();
		String url = configReader.initialiseProperties("MobileURL");
		DriverFactory.getDriver().get(url);
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	@When("user enters username {string} in app")
	public void user_enters_username_in_app(String string) {
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		configReader = new ConfigReader();
		userName = configReader.initialiseProperties(string);
		mobile_SearchPage.enterUsername(userName);
	}

	@When("user enters password {string} in app")
	public void user_enters_password_in_app(String string) {
		configReader = new ConfigReader();
		passWord = configReader.initialiseProperties(string);
		mobile_SearchPage.enterPassword(passWord);
		
	}

	@When("user clicks on Login button in app")
	public void user_clicks_on_login_button_in_app() {
		mobile_SearchPage.clickLoginButton();   
	}

	@When("user select search location in app")
	public void user_select_search_location_in_app() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		mobile_SearchPage.clickLocation();
	}

	@When("user clicks on Search button in app")
	public void user_clicks_on_search_button_in_app() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		mobile_SearchPage.clickSearchButton();
	}

	@Then("The search results are displayed in app")
	public void the_search_results_are_displayed_in_app() {
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		mobile_SearchPage.searchResults();
	}
	

}
