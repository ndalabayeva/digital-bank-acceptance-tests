package co.wedevx.digitalbank.automation.ui.utils;
//Create a class to hold the static email variable:
//was created for Ex 19.1.1 Deposit - positive case for Checking
public class TestData {
    private static String email;

    public static void setEmail(String email) {
        TestData.email = email;
    }

    public static String getEmail() {
        return email;
    }
}
