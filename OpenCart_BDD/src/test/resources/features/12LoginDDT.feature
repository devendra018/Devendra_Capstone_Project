Feature: validate login page
Scenario Outline: Check for valid and invalid credentials
Given login page should be open in default browser
When click on username button and enter <email1> and <password1> and click signin button
Then login successfully and open home page
Examples:
|email1|password1|status|
|muktha|Devendra@0018|fail|
|devendra|676904|fail|
|dvd34|455354|fail|
|devendra7981676@gmail.com|deva|success|