Feature: NavBar

  Background: Login
    Given User should be on MIS login page and enter smita.mishra and Admin@123
    When User clicked on submit button
    And User should be navigated to MIS homepage

  Scenario: Verify toggle button on Dashboard Page
    Then User verify a toggle button is present on Dashboard and clickable

  Scenario Outline: Verify Update profile Section
    Then User click on Profile menu
    And User Verify all the <Fields> and <Buttons> are present

    Examples:
      | Fields                                                                                                                                                  | Buttons      |
      | Update Profile:Mobile number,Extn. number;Update Address:Country,State,City,Pin code,Address;Change Password:Old Password,New Password,Confirm Password | Update,Close |

 Scenario Outline: Verify user redirect to landing page when clicking on Gemini logo
    Then User click on Gemini logo and Verify should be on HomePage by url <URL>
Examples: |URL|
   |https://mymis.geminisolutions.com/Dashboard/Index|

   Scenario Outline: Verify Add skill close button after entering all values
     Then User click on Skills menu
     And User Enter all the details "<Technology>","<Proficiency Level>","<Skill Type>","                   <Tech Experience>","<Total Work Exp>"
     And User click on close button
     Examples:
     |Technology|Proficiency Level|Skill Type|Tech Experience|Total Work Exp|
     |Accounting|Beginner         |Secondary |24             |2             |

     Scenario Outline: Verify Success Message box when adding new skills
       Then User click on Skills menu
       And User Enter all the details "<Technology>","<Proficiency Level>","<Skill Type>","<Tech Experience>","<Total Work Exp>"
       And User click on Save button
       And User verify popup with message "<AlertType>" and "<Message>"
      Examples:
        |Technology|Proficiency Level|Skill Type|Tech Experience|Total Work Exp|AlertType|Message|
        |Administration|Beginner         |Secondary |24             |2             |Success   | Skills has been saved successfully. |

  Scenario Outline: Verify Warning Message box when adding duplicate skills
    Then User click on Skills menu
    And User Enter all the details "<Technology>","<Proficiency Level>","<Skill Type>","<Tech Experience>","<Total Work Exp>"
    And User click on Save button
    And User verify popup with message "<AlertType>" and "<Message>"
    Examples:
      |Technology|Proficiency Level|Skill Type|Tech Experience|Total Work Exp|AlertType|Message|
      |.NET|Beginner         |Secondary |24             |2             |Warning   | Duplicate Skills not Allowed. |

    Scenario: Verify New Tab should be open on Change AD Password button
      Then User click on Change AD Password and Verify new tab should be open

      Scenario: Logout to MIS portal






