Feature: Login into Application

Scenario Outline: Positive test validating login
Given Initialize the browser with chrome
And Navigate to "http://www.qaclickacademy.com/" site
And click on login link in home page to land on secure sign in page
When user enters <userName> and <password> and logs in
Then close browser

Examples:
|userName			|password	|
|test99@gmail.com	|123456		|
|test123@gmail.com	|2423243	|
