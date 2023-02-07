Feature: MIS Automation

  Scenario: Add new document tags icon present and functional in view documents in knowledge base
    Given logged in successfully
    When navigating to view documents page
    Then add new document tags icon is present and functional

  Scenario: Add empty  document tags icon present and functional in view documents in knowledge base
    Given logged in successfully
    When navigating to view documents page adding empty document tag
    Then throws warning message

  Scenario Outline: Verifying monthly attendance
    Given logged in successfully
    When navigating to my attendance
    Then selecting "<month>" and verifying the attendance
    Examples:
      | month |
      |January 2023|

  Scenario: Checking right click functionality for folder
    Given logged in successfully
    When navigating to view documents page
    Then right click functionality is working

  Scenario: Adding an invalid document
    Given logged in successfully
    When navigating to view documents page and adding an invalid document type
    Then invalid document type warning should be displayed

  Scenario: Refresh button
    Given logged in successfully
    When navigating to view documents page and page is refreshed
    Then page is refreshed

  Scenario: Search functionality
    Given logged in successfully
    When navigating to view documents page and searched
    Then search is functional

  Scenario: Search functionality with absent document
    Given logged in successfully
    When navigating to view documents page and searched document not present
    Then search is functional and nothing is shown

  Scenario Outline: Renaming the folder
    Given logged in successfully
    When navigating to view documents page and renaming the "<folder>"
    Then the folder name should be renamed
    Examples:
      | folder |
      |New Folder|












