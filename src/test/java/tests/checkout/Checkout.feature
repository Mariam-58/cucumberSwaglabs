Feature: checkout

  Scenario Outline: checkout with 1 product
    Given site is opened
    When enter "<user>" and "<pass>"
    And click on login button
    And select "<productName>"
    And click on add to cart button
    And click on cart button
    And click on checkout button
    And enter "<firstName>" and "<lastName>" and "<zipcode>"
    And click on continue button
    And click on Finish button
    Then checkout complete
    Examples:
      |user|pass|productName|firstName|lastName|zipcode|
      |username|password|prdName|firstName|lastName|zipCode|