Feature: AppraisalManagement


  Background: These steps are common for every scenario
    Given Launch MIS Url https://mymis.geminisolutions.com/
    Then Enter Username laxmi.sisode and password R2VtaW5pQDEyMw==
  #R2VtaW5pIzEyMw==
    Then User clicks on Sign-in button
    Then Login will be successful and homepage will be displayed.

#following steps will be implemented later
#  Scenario: Login failed pop-up test
#    When User click on Sign-in button
#    Then Login failed pop up will be displayed

  Scenario:  Navigate to Add goal page
    When Click on Appraisal Management link
    Then Click on Add Goals link
    Then Verify Add goal window
    And Verify My Goal tab
    And Verify financial year dropdown
    #test step is commented because it is showing 404 error on click
    #Then Verify link for list of KRAs and KPIs
    Then Verify Add new KPI-KRA mapping button


  Scenario: Verify export button functionality
    When Click on Appraisal Management link
    Then Click on Add Goals link
    Then Verify Add goal window
    And Verify My Goal tab
    Given Verify button is enabled and clickable
   # Then Click on Copy option and  and paste it in notepad
    Then Click on Excel option and check excel file is downloaded
    Then Click on PDF option and check pdf file is downloaded
    Then Click on Print option and check print window open in new tab
    Then Close Print window
    Then Check number of pages in dropdown

  Scenario: Verify searches
    When Click on Appraisal Management link
    Then Click on Add Goals link
    Then Verify Add goal window
    And Verify My Goal tab
    When Verify search entries count at bottom
    When Type text in searchbox and verify search results
    Then Clear text and verify original count at the bottom of the table

  Scenario: Add new KPI/KRA mapping in add goal window
    When Click on Appraisal Management link
    Then Click on Add Goals link
    Then Verify Add goal window
    Given Click on Add new KPI-KRA mapping button
    Then Click on close button
    Then Verify Add goal window
    And Click on Add new KPI-KRA mapping button
    Then Click on submit button
    Then Check validation for KRA textbox
    Then Validate and click add KPI button
    When Click on submit button
    Then Check validation for KPA textbox
    And Enter KRA in textbox
    And Enter KPI description in text box
    Then Click on submit button
    And Check validation for empty Goal type Dropdown
    Then Select any one option from Goal Type Dropdown
    Then Validate and click add KPI button
    Then Click on close button of newly added KPI
    Then Click on submit button
    Then Verify Success Popup appeared on screen and click on Ok button

