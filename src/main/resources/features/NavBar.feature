Feature: NavBar

  Background: Login
    Given User should be on MIS login page and enter smita.mishra@geminisolutions.com and Admin@123
    When User clicked on submit button
    And User should be able to navigated to the mis homepage

  Scenario: Verify toggle button on Dashboard Page
    Then User verify a toggle button is present on Dashboard and clickable

  Scenario Outline: Verify Update profile Section
    Then User click on Profile menu
    And User Verify all the <Fields> and <Buttons> are present

    Examples:
      | Fields                                                                                                                                                  | Buttons      |
      | Update Profile:Mobile number,Extn. number;Update Address:Country,State,City,Pin code,Address;Change Password:Old Password,New Password,Confirm Password | Update,Close |

 Scenario: Verify user redirect to landing page when clicking on Gemini logo
    Then User click on Gemini logo

   Scenario Outline: Verify Add skill close button after entering all values
     Then User click on Skills menu
    # And User Enter all the details <Technology>,<Proficiency Level>,<Skill Type>,<Tech Experience>,<Total Work Exp> and click on close button
     Examples:
     |Details|
     |Dropdown:Accounting,Dropdown:Beginner,Dropdown:Primary,Text:24,Text:2|



