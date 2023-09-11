Feature: Test Automation – Assessment

  Scenario: Test Case 1: Adding a Book to Cart
    Given Navigate to official Amazon site
    When Select the Category as Books
    And Search for the search term as Automation
    And Click search button
    When Select Customer Reviews as 4 Stars & Up
    And Select Language as English
    Then Get the name of the second item from the Product List page
    And Click the name of the second item from the Product List page
    Then Get the Unit price of the item displayed in the Product Detail page
    And Verify whether the item name of the Product Detail page and the item name obtained from the Product List page is same
    When Set the Quantity as 2
    And Click on Add to Cart
    And Click on Go to Cart
    Then Verify whether the cart details are correct
    And Clear the cart
    And Verify the total amount is equal to $0.00
    And Close browser


