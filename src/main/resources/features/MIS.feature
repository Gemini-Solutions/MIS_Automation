
Feature: LNSA Feature - MIS Automation GemJar

  Background: : : The user is on MIS Homepage and logs in
    Given User is on the MIS Login Page
    When User enters their login details and logs in
    Then User clicks on LNSA from left menu panel

    Scenario:
      And User selects Apply LNSA from menu panel
      Then User tries to move to the previous date