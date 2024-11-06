Feature: Home Loan

  @regression
  Scenario: Extracting the table
    Given the user navigates to HomeLoanPage
    When the user scroll the table
    Then printing the table
