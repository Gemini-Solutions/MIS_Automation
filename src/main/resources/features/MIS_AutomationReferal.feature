Feature: MIS_AutomationReferal

  Background: Launch MIS url
    When user click on url
    And Enter username
    And Enter Password
    Then click on SignIn button
    Then click on close button

    Scenario: Verify if dashboard page is loaded properly and JD window is visible
      When verify dashboard page is loaded properly
      And click on JD window

