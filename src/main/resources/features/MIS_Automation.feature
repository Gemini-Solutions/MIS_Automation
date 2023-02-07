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
          When click on change password
          And enter old password
          Then verify the the password is incorrect

      Scenario: user enters Different Password in Confirm Password
        When enter new password and confirm password
        Then verify password not match

       Scenario:user applies for lunch
         When user click on apply lunch
         And user click on from date and click on select from date
         And user click on till date and select till date
         And click on location container
         And select the location from the list
         Then click on add lunch button

         Scenario: user applies for lunch for already applied date
         When user click on apply lunch
         And user click on from date and click on select from date
         And user click on till date and select till date
         And click on location container
         And select the location from the list
         And click on add lunch button
           Then verify the warning message



