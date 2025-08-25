Feature: Placeholder

Scenario Outline:Placing the order Successfully 
Given user is on the login page
When user enters username as "<Username>" and password as "<Password>" and click login button
And the user selects the product
And the user clicks on Add to Cart button
And the user clicks on the Cart icon
And the user clicks on the Checkout button
And the user enters customer information and click continue button
And the user verifies the product and click Finish button
And the user clicks the logout button
Then the user validates the login button in the login page

Examples:
|Username|Password|
|standard_user|secret_sauce|