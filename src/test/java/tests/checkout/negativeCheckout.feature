Feature: checkout

  Scenario Outline: checkout with 1 product
    Given site is opened
    When enter "<user>" and "<pass>"
    And click on login button
    And select "<productName>"
    And click on add to cart button
    And click on cart button
    And click on checkout button
    Then error checkout message is appeared
    Examples:
      |user|pass|productName|
      |username|password|prdName|