Feature: Add to cart
  Scenario Outline: Add products to cart
    Given site is opened
    When enter "<user>" and "<pass>"
    And click on login button
    And try to select "<productName>"
    Then user should remain on products page
    Examples:
      |user|pass|productName|
      |username|password|NonExistentProduct123|