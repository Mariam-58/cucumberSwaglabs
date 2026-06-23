Feature: Add to cart
  Scenario Outline: Add products to cart
    Given site is opened
    When enter "<user>" and "<pass>"
    And click on login button
    And select "<productName>"
    And press on add to cart button
    Then error message is appeared
    Examples:
      |user|pass|productName|
      |username|password|prdName|