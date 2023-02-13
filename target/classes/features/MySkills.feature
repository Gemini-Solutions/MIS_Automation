Feature: MySkills_Automation

  Background: User is on  Login Page
    Given User enters Username as "shruti.singh"
    And User enters Password as "Gemini@123"
    When User clicks on sign in

#  Scenario Outline: Verify My Skills are updating with Valid Data
#    Given User scrolls to skills view
#    When Skills are updated with "<mySkills>"
#    Then User clicks on close button
#    Examples:
#    |mySkills|
#    | Accounting       |

##########Failed Scenario as My skills can not be updated with invalid data #############
  Scenario Outline: Verify My Skills are updating with Valid Data
    Given User clicks on userImg button
    And User clicks on skills button
    Given User clicks on technology dropdown
    And User selects the "<technology>"
    When User clicks on professional dropdown
    And User selects the professional level as "<professionalLevel>"
    When User enters the tech experience "17"
    When User enters the total experience "48"
    And User clicks on skill ok button
    Given User scrolls to skills view
    When Skills are updated with "<mySkills>"
    Then User clicks on close button
    Examples:
    Examples:
      | technology | professionalLevel | mySkills |
      | Accounting   | Beginner                | Accounting |