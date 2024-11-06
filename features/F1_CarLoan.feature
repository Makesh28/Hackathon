Feature: Car Loan

  #Scenario: Extracting the results
  #Given the user navigates to CarLoanPage
  #When the user enters the value of Car Loan Page
  #| LoanAmt | 1500000 |
  #| LoanInt |     9.5 |
  #| LoanTen |    -375 |
  #Then printing the data
  @smoke
  Scenario Outline: Extracting the results
    Given the user navigates to CarLoanPage
    Then enter the values with excel row "<row_index>"
    And the user clicks on the year button
    Then the user scroll to the table
    And display the EMI data

    Examples: 
      | row_index |
      |         1 |
