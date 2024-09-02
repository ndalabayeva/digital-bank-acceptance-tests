@Registration
Feature: Digital Bank registration Page

  Background:
    Given the user with "aduncan@gmail.com" is not in DB
    And User navigates to Digital Bank signup page

  Scenario: Positive Case. As a user, I want to successfully create Digital Bank account

    When User creates account with following fields
#    When User creates account with following fields with mocked email and ssn
    #we do not mock email and ssn since class 21.10 Automate Registration Steps by Deleting Previously Created User
      | title | firstName | lastName | gender | dob        | ssn         | email             | password      | confirmPassword | address                                   | locality    | region | postalCode | country | homePhone      | mobilePhone    | workPhone      | termsCheckMark |
      | Ms.   | Adina     | Duncan   | F      | 17/08/1997 | 123-44-2235 | aduncan@gmail.com | Avrora100000$ | Avrora100000$   | 416 West 8th Street, Downtown Los Angeles | Los Angeles | CA     | 85494      | US      | (535) 361-5087 | (137) 592-0415 | (646) 295-1308 |                |
        #ssn and email address wil be random
    Then User should be displayed with the message "Success Registration Successful. Please Login."
    Then the following user info should be saved in the db
      | title | firstName | lastName | gender | dob        | ssn         | email             | password      | confirmPassword | address                                   | locality    | region | postalCode | country | homePhone      | mobilePhone    | workPhone      | accountNonExpired | accountNonLocked | credentialsNonExpired | enabled |
      | Ms.   | Adina     | Duncan   | F      | 17/08/1997 | 123-44-2235 | aduncan@gmail.com | Avrora100000$ | Avrora100000$   | 416 West 8th Street, Downtown Los Angeles | Los Angeles | CA     | 85494      | US      | (535) 361-5087 | (137) 592-0415 | (646) 295-1308 | true              | true             | true                  | true    |

#  @Deposit
#  Scenario: Ex 19.2.1 Deposit - positive case for Savings.
#    Given User signs in with new credentials "zdoich@gmail.com" "Nazerke21!"
#    When User creates new checking account with data
#      | checkingAccountType | accountOwnership | accountName | initialDepositAmount |
#      | Standard Checking   | Individual       | Test10      | 100000.0             |
#    Then User navigates to Deposit page and makes new deposit for "Test9" account and inputs 100000.0
#    And User Validates the new amount on the View checking page and deposit equals 100000.0


  @NegativeRegistrationCases
  Scenario Outline: Negative Case. As a Digital Bank Admin, I want to make sure users can not register without providing all valid data

    When User creates account with following fields
#    When User creates account with following fields with mocked email and ssn
    #we do not mock email and ssn since class 21.10 Automate Registration Steps by Deleting Previously Created User
      | title   | firstName   | lastName   | gender   | dob   | ssn   | email   | password   | confirmPassword   | address   | locality   | region   | postalCode   | country   | homePhone   | mobilePhone   | workPhone   | termsCheckMark   |
      | <title> | <firstName> | <lastName> | <gender> | <dob> | <ssn> | <email> | <password> | <confirmPassword> | <address> | <locality> | <region> | <postalCode> | <country> | <homePhone> | <mobilePhone> | <workPhone> | <termsCheckMark> |
        #ssn and email address wil be random
    Then User should see "<fieldWithError>" the required field error message "<errorMessage>"

    Examples:
      | title | firstName | lastName | gender | dob | ssn | email | password | confirmPassword | address | locality | region | postalCode | country | homePhone | mobilePhone | workPhone | termsCheckMark | fieldWithError | errorMessage                        |
      |       |           |          |        |     |     |       |          |                 |         |          |        |            |         |           |             |           |                | title          | Please select an item in the list.  |
      | Mr.   |           |          |        |     |     |       |          |                 |         |          |        |            |         |           |             |           |                | firstname      | Please fill in this field.          |
      | Mr.   | Jack      |          |        |     |     |       |          |                 |         |          |        |            |         |           |             |           |                | lastname       | Please fill in this field.          |
      | Mr.   | Jack      | Test     |        |     |     |       |          |                 |         |          |        |            |         |           |             |           |                | gender         | Please select one of these options. |






#Feature: Ex 19.1.2 Deposit - negative case for Checking 1
#
#  Scenario: Ex 19.1.2 Deposit - negative case for Checking 1
#
#    Given User navigates to Digital Bank signup page
#    When User creates account with following fields with mocked email and ssn
#      | title | firstName | lastName | gender | dateOfBirth | password      | confirmPassword | address                                   | locality    | region | postalCode | country | homePhone      | mobilePhone    | workPhone      |
#      | Ms.   | Avrora    | Duncan   | F      | 17/08/1997  | Avrora100000$ | Avrora100000$   | 416 West 8th Street, Downtown Los Angeles | Los Angeles | CA     | 85494      | US      | (535) 361-5087 | (137) 592-0415 | (646) 295-1308 |
#        #ssn and email address wil be random
#    Then User should be displayed with the message "Success Registration Successful. Please Login."
#    And User signs in with new emailAddress and password "Avrora100000$"
##    When User signs in with new credentials "zdoich@gmail.com" "Nazerke21!"
#    And User creates new checking account with data
#      | checkingAccountType | accountOwnership | accountName | initialDepositAmount |
#      | Standard Checking   | Individual       | Test9       | 100000.0             |
#    And the user should see the green "Successfully created new Standard Checking account named Test9" message
#    And User navigates to Deposit page and makes deposit for "Test9" leaving amount empty
#    And User Validates the error is displayed and deposit was not made


