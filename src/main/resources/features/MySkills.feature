Feature: MySkills Automation

  Background: User is on  Login Page
    When User enters username as "shruti.singh"
    And User enters password as "Gemini@123"
    And User clicks on sign in
    And User verifies landing page
#    Then User clicks on closeButton

   Scenario Outline: Verify my skills are updating with Valid Data
    When User clicks on user image button
    And User clicks on skills button
    And User clicks on technology dropdown
    And User selects the "<technology>"
    And User clicks on professional dropdown
    And User selects the professional level as "<professionalLevel>"
    And User enters the tech experience "17"
    And User enters the total experience "48"
    And User clicks on skill ok button
    And User scrolls to skills view
    And Skills are updated with "<mySkills>"
    Then User clicks on close button

    Examples:
      | technology | professionalLevel | mySkills |
      |  .Net Frameworks  | Beginner                | Accounting |

    ###########Failed Scenario as skills will not be updated with invalid data ###############
  Scenario Outline: Verify my skills are updating with in valid data
    When User clicks on user image button
    And User clicks on skills button
    And User clicks on technology dropdown
    And User selects the professional level as "<professionalLevel>"
    And User enters the tech experience "17"
    And User enters the total experience "48"
    And User clicks on skill ok button
    And User scrolls to skills view
    And Skills are updated with "<mySkills>"
    Then User clicks on close button

    Examples:
     | professionalLevel | mySkills |
      | Beginner                | Accounting |