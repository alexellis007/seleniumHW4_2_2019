Feature: E-Shop Automation
  As a user I want to make an order
  and submit it

  Scenario Outline: Make an order and submit
    Given user navigate to the app url
    When user signs in with values "<userEmail>" and "<userPassword>"
    And user selects 'Women' menu
    And user selects product
    And user adds product to you cart
    And user clicks on 'Proceed to checkout'
    And user verifies cart, clicks on 'Proceed to checkout'
    And user verifies delivery/billing address, clicks on 'Proceed to checkout'
    And user agrees on terms and clicks on 'Proceed to checkout'
    And user gets the order amount and selects 'Pay by Check'
    And user clicks to confirm order
    And user checks on order completion
    And user returns to the order
    And user verifies order and total price
    Then user logout from account

    Examples:
      |userEmail    |userPassword|
      |ade@gmail.com|qwertyuiop2 |

