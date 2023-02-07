Feature: AppraisalManagement



  Background: These steps are common for every scenario
    Given Launch MIS Url https://mymis.geminisolutions.com/
    Then Enter Username laxmi.sisode and password Gemini#123
    Then User clicks on Sign-in button
    Then Login will be successful and homepage will be displayed.

#following steps will be implemented later
#  Scenario: Login failed pop-up test
#    When User click on Sign-in button
#    Then Login failed pop up will be displayed

  Scenario: Navigate to add goal page and verify Add goal window
    When Click on Appraisal Management link
    Then Click on Add Goals link
    Then Verify Add goal window
    And Verify financial year dropdown
    #test step is coomented because it is showing 404 error on click
    #Then Verify link for list of KRAs and KPIs
    Then Add new KPI-KRA mapping in add goal window
    And validate add KPI button
   # And Verify warning popup appears when KPI-KRA fields are left empty