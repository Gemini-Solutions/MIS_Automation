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

  Scenario Outline: User Enter only password and Clicks on Sign In
    Given Enter username "<uname>"
    Given Enter password "<password>"
    Then Click on Sign In Button
    Then Verify error message "<errormessage>"
    Examples:
      | uname | password   | errormessage          |
      |       | Gemini@123 | Username is required. |

  Scenario Outline: User Enters Invalid Credentials
    Given Enter username "<uname>"
    Given Enter password "<password>"
    Then Click on Sign In Button
    Then Verify error message "<errormessage>"
    Examples:
      | uname | password | errormessage                                                         |
      | abc   | Gemini   | The username or password you entered is not valid. Please try again. |

  Scenario: User Login to the Application via SSO
    Then Click on Login with SSO button
    Then Verify User is on "MIS Home" Page

  Scenario Outline: User Login to the Application
    Given Enter username "<uname>"
    Given Enter password "<password>"
    Then Click on Sign In Button
    Then Verify User is on "MIS Home" Page
    Examples:
      | uname      | password   |
      | charu.garg | Gemini@123 |
