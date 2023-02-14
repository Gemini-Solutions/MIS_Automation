Feature: MIS

  Background: Launch MIS url
    When user click on url
    And Enter username referal
    And Enter Password referal
    And click on SignIn button referal
    Then click on close button referal

    Scenario: Verify if dashboard page is loaded properly and JD window is visible
      When verify dashboard page is loaded properly
      Then verify JD window is visible

      Scenario: Validation of referral creation
        When user click on referral action



