Feature: Organization Structure Module Scenarios

  Background: Login to MIS
    Given Login to MIS with Username tushar.chauhan and password R2VtaW5pQDEyMw==
    When Click on Signin button
    Then Validate login successful

 Scenario Outline: Search for Employee with Designation
   Given Navigate to Organization Structure
   When Entered employee name <empname> in search field
   Then Validate availability of Employee <empname> and Designation <designation>
   Examples:
     | empname             | designation|
     | Tushar Chauhan      |  Software Engineer -L2 |
