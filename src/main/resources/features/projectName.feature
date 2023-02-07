Feature: MIS_Automation

  #Background: These steps are common for every scenario
    #When User click on mislink
   # And User enter Username
   # And User enter password
    #Then User click on Sign In button


  Background: Launch MIS url
   When user click on url
    And Enter username
    And Enter Password
    Then click on SignIn button

    Scenario: click on mobile details
      When user update mobile and extension number
      And Enter mobile number and ext number
     # Then click on update


      Scenario:user enter invalid pincode
        When click on update address
        And enter pinCode
        Then verify invalid pincode

        Scenario: user enters Incorrect Password
          #When click on change password
          And enter old password
          Then verify the the password is incorrect

      Scenario: user enters Different Password in Confirm Password
      #  When click on close button
        And enter new password and confirm password
        #And click on update password
        Then verify password not match

       Scenario:user applies for lunch
         When user click on apply lunch



