Feature: Loan Tenure Calculator  UI

  @regression
  Scenario: Checking the UI of Loan Tenure Calculator page
    Given user click the loan tenure calculator button of Loan Tenure Page
    When user validates loan amount textbox and slider of Loan Tenure Page
    And user validates scale change for loan amount textbox and slider of Loan Tenure Page
    And user validates emi textbox andslider of Loan Tenure Page
    And user validates interest rate textbox and slider of Loan Tenure Page
    And user validates scale change for interest rate textbox and slider of Loan Tenure Page
    And user validates fees and charges textbox and slider of Loan Tenure Page
    And user validates scale change for fees and charges textbox and slider of Loan Tenure Page
    Then loan tenure ui check validation is successful
