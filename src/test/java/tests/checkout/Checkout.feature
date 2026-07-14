Feature: checkout

  Scenario Outline: checkout with 1 product
    Given site is opened
    When enter "<user>" and "<pass>"
    And click on login button
    And select "<productName>"
    And click on add to cart button
    And click on cart button
    And click on checkout button
    And enter "<fName>" and "<lName>" and "<zCode>"
    And click on continue button
    And click on Finish button
    Then checkout complete
    Examples:
      |user|pass|productName|fName|lName|zCode|
      |username|password|prdName|firstName|lastName|zipCode|