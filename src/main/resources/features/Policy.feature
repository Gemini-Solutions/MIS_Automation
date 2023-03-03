#Author: charu.garg@geminisolutions.com
#Keyword: Policy

Feature: Policy

#  Background: Login
#    When User enters "username" as "charu.garg"
#    Then User enters "password" as "R2VtaW5pQDEyMw=="
#    Then Click on Sign In Button
#    Then Verify User is on "MIS Home" Page
  Background: Login to MIS
    Given Login to MIS with Username tushar.chauhan and password R2VtaW5pQDEyMw==
    When Click on Signin button
    Then User should be navigated to MIS homepage

  Scenario: Navigate to Policy > View Policies
    When User clicks on Policy
    And Click on View Policies

  Scenario Outline:Verify Title of Policy Tab
    When User clicks on Policy
    And Click on View Policies
    Then Check the "<title>" of policy tab
    Examples:
      | title         |
      | View Policies |

  Scenario: Verify Data is present in Policies tab
    When User clicks on Policy
    And Click on View Policies
    Then Verify Data is present in Policies tab

  Scenario Outline: Verify Number of Entries displayed
    When User clicks on Policy
    And Click on View Policies
    Then Verify number of records displayed by default
    And Select "<noOfRecords>" as number of entries
    Then Verify number of records displayed changes
    Examples:
      | noOfRecords |
      | 25          |

  Scenario Outline: Enter Policy Name in Search Box
    When User clicks on Policy
    And Click on View Policies
    Then Enter "<policyName>" in Search Box
    Examples:
      | policyName |
      | E-Policy   |

  Scenario Outline: Enter Invalid Policy Name in Search Box
    When User clicks on Policy
    And Click on View Policies
    And Enter "<policyName>" in Search Box
    Then Verify the "<message>" on the dashboard
    Examples:
      | policyName | message                   |
      | ABC Policy | No matching records found |

  Scenario Outline: View Policy
    When User clicks on Policy
    And Click on View Policies
    And Enter "<policyName>" in Search Box
    And Click on view policy
    Then Verify the "<policyName>"
    Examples:
      | policyName |
      | E-Policy   |

  Scenario: Verify Next button is clickable
    When User clicks on Policy
    And Click on View Policies
    Then Click on "Next" Button

  Scenario: Verify Previous button is clickable
    When User clicks on Policy
    And Click on View Policies
    Then Click on "Previous" Button