Feature: MIS_Automation

  Background: User is on  Login Page
    Given User enters Username as "shruti.singh"
    And User enters Password as "Gemini@123"
    When User clicks on sign in
    And User Verifies Landing Page
    Then User clicks on closeButton


  Scenario Outline: Open View Forms Page

    Given User clicks on tab "<parentTab>" and "<childTab>"
    Then User verifies element "<firstElement>"
    And User verifies element "<secondElement>"
    Examples:
      | parentTab | childTab  | firstElement | secondElement |
      | Forms     | View Form | View Forms   | Form Name     |

  Scenario Outline: User checks the  presence of Previous and Next Button
    Given User clicks on tab "<parent Tab>" and "<child Tab>"
    Then User verifies the presence of "<buttonOne>" Button
    And User verifies the presence of "<buttonTwo>" Button
    Examples:
      | parent Tab | child Tab | buttonOne | buttonTwo |
      | Forms      | View Form | Previous  | Next      |

  Scenario Outline: User selects a department
    Given User clicks on tab "<parentTab>" and "<childTab>"
    When User clicks on department
    Then User Clicks on "<desiredDepartment>"
    Examples:
      | parentTab | childTab  | desiredDepartment |
      | Forms     | View Form | Accounts          |

  Scenario Outline: User selects the entries
    Given User clicks on tab "<parentTab>" and "<childTab>"
    Then User selects the entries as "<element>"
    Examples:
      | parentTab | childTab  | element |
      | Forms     | View Form | 25      |

  Scenario Outline:  User enters valid value in search field
    Given User clicks on tab "<parentTab>" and "<childTab>"
    When User search field and enters value "<value>"
    Then User verifies the value "<element>"
    Examples:
      | parentTab | childTab  | value    | element            |
      | Forms     | View Form | Accounts | Reimbursement Form |

  Scenario Outline: User enters Invalid value in search field
    Given User clicks on tab "<parentTab>" and "<childTab>"
    When User search field and enters invalid value "<value>"
    Then User verifies the invalid value "<element>"
    Examples:
      | parentTab | childTab  | value | element                   |
      | Forms     | View Form | QA    | No matching records found |

  Scenario Outline:User clicks on eye button to view policy
    Given  User clicks on tab "<parentTab>" and "<childTab>"
    When  User clicks on eye button
    Then User views policy
    Examples:
      | parentTab | childTab  |
      | Forms     | View Form |

  Scenario Outline: User downloads document
    Given  User clicks on tab "<parentTab>" and "<childTab>"
    Then User click on download image
    Examples:
      | parentTab | childTab  |
      | Forms     | View Form |

#####################################myForms############################################

  Scenario Outline: User opens My Forms page
    Given  User clicks on the "<parentTab>" and "<childTab>"
    Then Verify the heading on the landing page
    Examples:
      | parentTab | childTab |
      | Forms     | My Form  |

  Scenario Outline:User Uploads correct File
    Given  User clicks on the "<parentTab>" and "<childTab>"
    When User clicks on upload button
    When User Uploads the desired document "<formType>" from "<path>"
    Then User clicks on save button
    Examples:
      | parentTab | childTab | formType                | path |
      | Forms     | My Form  | Loyalty Redemption Form | C:\Users\sh.singh9\Desktop\MIS_Automation\MIS_Automation\src\main\resources\Loyalty Redemption Form.pdf     |

  Scenario Outline: User uploads incorrect File
    Given  User clicks on the "<parentTab>" and "<childTab>"
    When User clicks on upload button
    And User Uploads the undesired document "<formType>" from "<path>"
    When  Verify the "<warningMsg>"
    Then User clicks on ok button
    Examples:
      | parentTab | childTab | formType                | warningMsg                                                      | path |
      | Forms     | My Form  | Loyalty Redemption Form | Invalid file selected. Supported extensions are .xlsx,.xls,.pdf |  C:\Users\sh.singh9\Desktop\MIS GemJar\MIS_Automation_GemJar - Final\src\main\resources\17 may.docx    |

  Scenario Outline:User uploads file and selects number of entries
    Given  User clicks on the "<parentTab>" and "<childTab>"
    When User clicks on upload button
    When User Uploads the desired document "<formType>" from "<path>"
    And User clicks on save button
    Then User selects the entries as "<element>"

    Examples:
      | parentTab | childTab | formType                | element | path |
      | Forms     | My Form  | Loyalty Redemption Form | 25      |  C:\Users\sh.singh9\Desktop\MIS_Automation\MIS_Automation\src\main\resources\Loyalty Redemption Form.pdf    |

  Scenario Outline: User enters valid value in My forms search field
    Given  User clicks on the "<parentTab>" and "<childTab>"
    Then User enters valid value in My forms search field as "<element>"

    Examples:
      | parentTab | childTab | element                       |
      | Forms     | My Form  | Loyal Loyalty Redemption Form |

  Scenario Outline: User enters invalid value in My forms search field
    Given  User clicks on the "<parentTab>" and "<childTab>"
    Then User enters invalid value in My forms search field as "<value>"
    Then User verifies the invalid value "<element>"

    Examples:
      | parentTab | childTab | value | element                   |
      | Forms     | My Form  | QA    | No matching records found |

  Scenario Outline: User hover over and clicks on deactivate Button
    Given  User clicks on the "<parentTab>" and "<childTab>"
    When User clicks on active form
    And User hovers and clicks on deactivate button
    Then User clicks on yes button

    Examples:
      | parentTab | childTab |
      | Forms     | My Form  |

  Scenario Outline: User downloads from My Forms page
    Given  User clicks on the "<parentTab>" and "<childTab>"
    When User clicks on active form
    Then User hovers and clicks on download button

    Examples:
      | parentTab | childTab |
      | Forms     | My Form  |

  Scenario Outline: User uploads the File with same name
    Given  User clicks on the "<parentTab>" and "<childTab>"
    When User clicks on upload button
    When User Uploads the desired document "<formType>" from "<path>"
    And  User clicks on save button
    When User validates the error message as "<element>"
    Then User clicks on ok button

    Examples:
      | parentTab | childTab | formType                | element | path |
      | Forms     | My Form  | Loyalty Redemption Form |  File with same name already exists       | C:\Users\sh.singh9\Desktop\MIS_Automation\MIS_Automation\src\main\resources\Loyalty Redemption Form.pdf|
