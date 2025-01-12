Feature: End-to-End Testing for Login and Add to Cart and ordering

Background:
    Given open the url and click on login link
    When login to the application with valid 
    And select Samsung galaxy S6 and adding to cart
    Then go to cart  and check if product is present

Scenario: Place order for Galaxy phone with valid details
    And go order then enter details
    And print the purchase id
 
Scenario: Place order for Galaxy phone with valid empty fields
  Then place order assert alert is shown

    
    
