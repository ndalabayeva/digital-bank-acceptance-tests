package co.wedevx.digitalbank.automation.ui.utils;

//import co.wedevx.digitalbank.automation.ui.models.BankRegistration;

import co.wedevx.digitalbank.automation.ui.models.BankRegistration;
import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;


public class MockData {
    private FakeValuesService fakeValuesService = new FakeValuesService(
    new Locale("en-US"),new RandomService());
//Locale means what language you want to mock in

    public Map<String, String> generateRandomNameAndEmail(){
        String name = fakeValuesService.bothify(new Faker().name().firstName());
        String email = fakeValuesService.bothify(name + "####@gmail.com");
        Map <String, String> data = new HashMap<>();
        data.put("name", name);
        data.put("email", email);

        return data;
    }
//    public String generateRandomEmail(){
//        String email = fakeValuesService.bothify(new Faker().name().firstName()+"####@gmail.com");
//        return email;
//    }

    public String generateRandomSsn(){
        //String.format work the same as System.out.printf
        String ssn = String.format("%09d", new Random().nextInt(1000000000));
        return ssn;
    }

    public static void main(String[] args) {
        MockData mockData = new MockData();
//        System.out.println(mockData.generateRandomEmail());
        Map <String, String> data = mockData.generateRandomNameAndEmail();
        System.out.println(data.get("name"));
        System.out.println(data.get("email"));
        System.out.println(mockData.generateRandomSsn());
    }

    public static BankRegistration generateRandomUser() {
        Faker faker = new Faker(Locale.US);
        MockData mockData = new MockData();

        String title = faker.name().title();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String gender = getRandomGender(faker);
        String formattedDOB = faker.date().birthday(18, 65).toString();
        String ssn = mockData.generateRandomSsn();
        String email = faker.internet().emailAddress();
        String password = faker.internet().password();
        String address = faker.address().streetAddress();
        String locality = faker.address().city();
        String region = faker.address().stateAbbr();
        String postalCode = faker.address().zipCode();
        String country = faker.address().countryCode();
        String homePhone = faker.phoneNumber().cellPhone();
        String mobilePhone = faker.phoneNumber().cellPhone();
        String workPhone = faker.phoneNumber().cellPhone();

        return new BankRegistration(title, firstName, lastName, gender, formattedDOB, ssn, email, password,
                address, locality, region, postalCode, country, homePhone, mobilePhone, workPhone);
    }

    // Method to generate random gender
    private static String getRandomGender(Faker faker) {
        String[] genders = {"M", "F"};
        int index = faker.random().nextInt(genders.length);
        return genders[index];
    }

    public String generateRandomWorkPhone() {
        return fakeValuesService.regexify("[1-9]{3}-[1-9]{2}-[1-9]{4}");
    }

    public String generateRandomAddress() {
        Faker faker = new Faker();
        return faker.address().streetAddress();
    }

}
