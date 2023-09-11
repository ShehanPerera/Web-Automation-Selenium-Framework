
# Test Automation – Assessment

This is Selenium,BDD based automation framework to test Amazon adding to cart

## Pre requisites
1. java : 1.8
2. mvn : 3.6.1
3. Internet connection 
4. Firefox (88.0) or Chrome (81.0) browsers. 
If browser versions are different than this please download relevant driver from below links and replace to drivers 
folder.
* Chrome driver : https://chromedriver.chromium.org/
* Firefox driver : https://github.com/mozilla/geckodriver/releases

## Configurations

1. Check config/config.properties to setup url , browser and headed.
2. Using features/WebAutomation.feature can change some test data.
Eg : 
Changing "And Search for the search term as Automation" to "And Search for the search term as Java" will allowed to use search keyword as Java.

## How Run Test

1. In Web-Automation-Selenium-Framework folder run below command

```
mvn clean install
```
2. Open below file on browser to check html reports.

```Web-Automation-Selenium-Framework/target/reports/cucumber-html-reports/file-Features-WebAutomation-feature.html``` 

## Issues faced

1. I have noticed that the price element on the Detail page is charging inconsistently. It sometimes has an ID and sometimes does not. To manage this, I have created a function called "findDynamicElement." If an ID is available, it will use it; otherwise, it will use XPath.

2. When the step "Verify whether the cart details are correct" is running, if the book name is too long, the full name will not be displayed on the cart page. 

Eg: 
Detail Page name: "The Automation Advantage: Embrace the Future of Productivity and Improve Speed, Quality, and Customer Experience Through AI" 
Cart Page name: "The Automation Advantage: Embrace the Future of Productivity and Improve Speed, Quality, and Customer Experience Throug…".

To handle this situation, I perform a soft assertion and check it after closing the browser.