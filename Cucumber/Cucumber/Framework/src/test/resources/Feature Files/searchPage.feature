Feature: Search Product

Scenario: Search Product with Selected Location
Given User is in Login Page
When user enters username "Username"
And user enters password "Password"
And user clicks on Login button
And user select search location
And user clicks on Search button
Then The search results are to be displayed