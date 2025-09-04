Feature: User Login
Scenario: Login user with required fields
Given Login Page should be opened
When Enter <email1> and <password1> and then click login button
Then login successful
Examples:
|email1|password1
|devendra7981676@gmail.com|deva
