Feature: Loan Amt Calculator  UI

  @regression
  Scenario: Extracting the results
    Given user click the loan amount calculator button
    When user validates emi textbox and slider of Loan Amount Calculator Page
    And user validates interest rate textbox and slider of Loan Amount Calculator Page
    And user validates scale change for interest rate textbox and slider of Loan Amount Calculator Page
    And user validates loan tenure textbox and slider of Loan Amount Calculator Page
    #And user validates scale change for  loan tenure textbox and slider of Loan Amount Calculator Page
    And user validates year and month option of Loan Amount Calculator Page
    And user validates fees and charges textbox and slider of Loan Amount Calculator Page
    And user validates scale change for fees and charges textbox and slider of Loan Amount Calculator Page
    Then loan amount calculator ui check validation is successful
    
