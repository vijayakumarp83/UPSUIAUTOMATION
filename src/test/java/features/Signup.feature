
Feature: Signup for UPS

  Scenario: Create the customer
    Given Open the Signup Page
    When Enter the name
    And Enter the email
    And Enter the Phone
    And Enter the UserID
    And Enter the Password
    And Scroll the page
    And Select the Agreement Checkbox   
    And Submit the Button
    Then the result
   
   Scenario:Create the Customer  without name
    Given Open the Signup Page
    When Edit the name field
    And  Enter the email
    And Enter the Phone
    And Enter the UserID
    And Enter the Password
    And Select the Agreement Checkbox
    Then Assert the name error
    
    
    Scenario:Create the Customer  without Email
    Given Open the Signup Page
    When Enter the name
    And  Enter the email
    And Enter the Phone
    And Enter the UserID
    And Enter the Password
    And Select the Agreement Checkbox
    Then Assert the email error
    
    
    Scenario: Create the Customer  without UserID
    Given Open the Signup Page
    When Enter the name
    And  Enter the email
    And Enter the Phone
    And Edit the UserID field
    And Enter the Password
    And Select the Agreement Checkbox
    Then Assert the UserID error
   
    
    Scenario: Create the Customer  without Password
    Given Open the Signup Page
    When Enter the name
    And Enter the email
    And Enter the Phone
    And Enter the UserID
    And Edit the Password field
    And Select the Agreement Checkbox
    Then Assert the Password error
    
    Scenario: Create the Customer by unselecting AgreementCheckbox
    Given Open the Signup Page
    When Enter the name
    And Enter the email
    And Enter the Phone
    And Enter the UserID
    And Enter the Password
    And Scroll the page
    And Select the Agreement Checkbox
    And Deselect the Agreement Checkbox
    Then Assert the AgreementCheckbox error
   