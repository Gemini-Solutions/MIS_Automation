Feature: Login

  Scenario:User verifies Login Page Elements Before Login
    Then Verify all the elements present on Login Page

  Scenario: User verifies elements of Login page
    Then Verify all the elements present on Login Page

  Scenario Outline: User Clicks on Sign In without entering Credentials
    Given Enter username "<uname>"
    Given Enter password "<password>"
    Then Click on Sign In Button
    Then Verify error message "<errormessage>"
    Examples:
      | uname | password | errormessage                      |
      |       |          | Enter your username and password. |

  Scenario Outline: User Enters only username and Clicks on Sign In
    Given Enter username "<uname>"
    Given Enter password "<password>"
    Then Click on Sign In Button
    Then Verify error message "<errormessage>"
    Examples:
      | uname      | password | errormessage          |
      | charu.garg |          | Password is required. |


