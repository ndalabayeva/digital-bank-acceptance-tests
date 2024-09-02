Feature: Create a new checking account

  Scenario: Create a new checking account
    Given the user is logged in as "elonmusk@gmail.com" "ElonMusk123$$"
    When the user creates a new checking account with the following data
      | checkingAccountType | accountOwnership | accountName               | initialDepositAmount |
      | Interest Checking   | Individual       | Elon Musk Second Checking | 100000.0             |
    Then the user should see the green "Successfully created new Interest Checking account named Elon Musk Second Checking" message
    And the user should see newly added account card
      | accountName               | accountType       | ownership  | accountNumber | interestRate | balance   |
      | Elon Musk Second Checking | Interest Checking | Individual | 486131037     | 0.5%         | 100000.00 |
    And the user should see the following transaction
      | date             | category | description               | amount   | balance  |
      | 2024-01-30 05:30 | Income   | 845325809 (DPT) - Deposit | 100000.0 | 100000.0 |
