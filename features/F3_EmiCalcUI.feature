Feature: EMI Calculator  UI

  @regression
  Scenario: Extracting the results
    Given user navigates to EMI Calc Page
    When user validates loan amount textbox and slider of EMI Calculator page
    And user validates scale change for loan amount textbox and slider of EMI Calculator page
    And user validates interest rate textbox and slider of EMI Calculator page
    And user validates scale change for interest rate textbox and slider of EMI Calculator page
    And user validates loan tenure textbox and slider of EMI Calculator page
    And user validates scale change for loan tenure textbox and slider of EMI Calculator page
    And user validates year and month option of EMI Calculator page
    And user validates fees and charges textbox and slider of EMI Calculator page
    And user validates scale change for fees and charges textbox and slider of EMI Calculator page
    Then Emi Calculator ui check validation is successful
