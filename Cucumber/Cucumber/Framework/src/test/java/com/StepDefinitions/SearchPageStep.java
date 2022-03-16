package com.StepDefinitions;

import com.BasePackage.DriverFactory;
import com.Pages.SearchPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class SearchPageStep {
	
	private SearchPage searchPage = new SearchPage(DriverFactory.getDriver());

	@And("user select search location")
	public void user_select_search_location() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    searchPage.clickLocation();
	}

	@And("user clicks on Search button")
	public void user_clicks_on_search_button() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    searchPage.clickSearchButton();
	}

	@Then("The search results are to be displayed")
	public void the_search_results_are_to_be_displayed() {
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    searchPage.searchResults();
	}

}
