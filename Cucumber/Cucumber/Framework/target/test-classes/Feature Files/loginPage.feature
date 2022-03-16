Feature: Login Page feature

Scenario: Login Page fields displayed
Given User is in Login Page
Then Email field is displayed
And Password field is displayed
And Login button is displayed

Scenario: Login with correct credentials
Given User is in Login Page
When user enters username "Username"
And user enters password "Password"
And user clicks on Login button
When user gets the title of the Page
Then Page title should be "Login"
