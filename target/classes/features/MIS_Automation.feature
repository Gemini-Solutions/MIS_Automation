Feature: MIS Forms- View Forms scenarios

  Background: User is on  Login Page
    Given User enters Username as "shruti.singh"
    And User enters Password as "Gemini@123"
    When User clicks on sign in
    And User Verifies Landing Page
    Then User clicks on closeBtn


  Scenario Outline: Open View Forms Page

    Given User clicks on tab "<parent Tab>" and "<child Tab>"
    Then User verifies element "<FirstElement>"
    And User verifies element "<secondElement>"
    Examples:
      | parent Tab | child Tab | FirstElement | secondElement |
      | Forms      | View Form | View Forms   | Form Name     |

  Scenario Outline: User checks the  presence of Previous and Next Btn
    Given User clicks on tab "<parent Tab>" and "<child Tab>"
    Then User verifies the presence of "<buttonOne>" Btn
    And User verifies the presence of "<buttonTwo>" Btn
    Examples:
      | parent Tab | child Tab | buttonOne | buttonTwo |
      | Forms      | View Form | Previous  | Next      |

  Scenario Outline: User selects a department
    Given User clicks on tab "<parent Tab>" and "<child Tab>"
    When User clicks on department
    Then User Clicks on "<desiredDepartment>"
    Examples:
      | parent Tab | child Tab | desiredDepartment |
      | Forms      | View Form | Accounts          |

  Scenario Outline: User selects the entries
    Given User clicks on tab "<parent Tab>" and "<child Tab>"
    Then User selects the entries as "<element>"
    Examples:
      | parent Tab | child Tab | element |
      | Forms      | View Form | 25      |

  Scenario Outline:  User enters valid value in search field
    Given User clicks on tab "<parent Tab>" and "<child Tab>"
    When User search field and enters value "<value>"
    Then User verifies the value "<element>"
    Examples:
      | parent Tab | child Tab | value    | element            |
      | Forms      | View Form | Accounts | Reimbursement Form |

  Scenario Outline: User enters Invalid value in search field
    Given User clicks on tab "<parent Tab>" and "<child Tab>"
    When User search field and enters invalid value "<value>"
    Then User verifies the invalid value "<element>"
    Examples:
      | parent Tab | child Tab | value | element                   |
      | Forms      | View Form | QA    | No matching records found |

  Scenario Outline:User clicks on eye button to view policy
    Given  User clicks on tab "<parent Tab>" and "<child Tab>"
    When  User clicks on eye button
    Then User views policy
    Examples:
      | parent Tab | child Tab |
      | Forms      | View Form |

  Scenario Outline: User downloads document
    Given  User clicks on tab "<parent Tab>" and "<child Tab>"
    Then User click on download image
    Examples:
      | parent Tab | child Tab |
      | Forms      | View Form |

#####################################myForms############################################

  Scenario Outline: User opens My Forms page
    Given  User clicks on the "<parent Tab>" and "<child Tab>"
    Then Verify the heading on the landing page
    Examples:
      | parent Tab | child Tab |
      | Forms      | My Form   |

  Scenario Outline:User Uploads correct File
    Given  User clicks on the "<parent Tab>" and "<child Tab>"
    When User clicks on upload btn
    When User Upload the desired document "<formType>"
    Then User clicks on save btn
    Examples:
      | parent Tab | child Tab | formType                |
      | Forms      | My Form   | Loyalty Redemption Form |

  Scenario Outline: User uploads incorrect File
    Given  User clicks on the "<parent Tab>" and "<child Tab>"
    When User clicks on upload btn
    And User Upload the undesired document "<formType>"
    When  Verify the "<warningMsg>"
    Then User clicks on okbtn
    Examples:
     | parent Tab | child Tab  | formType | warningMsg |
      | Forms      | My Form    | Loyalty Redemption Form |  Invalid file selected. Supported extensions are .xlsx,.xls,.pdf |

    Scenario Outline:User uploads file and selects number of entries
      Given  User clicks on the "<parent Tab>" and "<child Tab>"
      When User clicks on upload btn
      When User Upload the desired document "<formType>"
      And User clicks on save btn
      Then User selects the entries as "<element>"

      Examples:
        | parent Tab | child Tab | formType                | element |
        | Forms      | My Form   | Loyalty Redemption Form | 25 |

      Scenario Outline: User enters valid value in My forms search field
        Given  User clicks on the "<parent Tab>" and "<child Tab>"
        Then User enters valid value in My forms search field as "<element>"

        Examples:
          | parent Tab | child Tab | element |
          | Forms      | My Form   | Loyal Loyalty Redemption Form|

      Scenario Outline: User enters invalid value in My forms search field
        Given  User clicks on the "<parent Tab>" and "<child Tab>"
        Then User enters invalid value in My forms search field as "<value>"
        Then User verifies the invalid value "<element>"

        Examples:
          | parent Tab | child Tab | value  | element |
          | Forms      | My Form   |  QA | No matching records found |