package guru.qa.utils;

import com.github.javafaker.Faker;
import guru.qa.pages.PracticeFormPage;

import java.util.List;


public class TestData {
    static PracticeFormPage pKF = new PracticeFormPage();
    Faker faker = new Faker();
    public List<String> label = List.of("Student Name", "Student Email", "Gender", "Mobile", "Date of Birth",
            "Subjects", "Hobbies", "Picture", "Address", "State and City");
    public String firstName = faker.name().firstName();
    public String lastName = faker.name().lastName();
    public String email = faker.internet().emailAddress();
    public String gender = faker.options().option("Male", "Female", "Other");
    public String month = faker.options().option("January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December");
    public String year = String.valueOf(faker.number().numberBetween(1900, 2100));
    public String subjects = faker.options().option("English", "Chemistry", "Computer Science",
            "Commerce", "Economics", "Social Studies", "Arts", "History", "Maths", "Accounting", "Physics",
            "Biology", "Hindi", "Civics");
    public String hobbies = faker.options().option("Sports", "Reading", "Other");
    public String picture = faker.options().option("Photo.jpg", "Photo2.jpg", "Photo3.jpg");
    public String currentAddress = faker.address().fullAddress();
    public String state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    public String phone = String.valueOf(faker.number().numberBetween(1111111111, 999999999));
    public String day = getRandomDay();
    public String city = getRandomCity();
    public List<String> values = List.of(firstName + " " + lastName, email, gender, phone, day + " " + month + "," + year,
            subjects, hobbies, picture, currentAddress, state + " " + city);
    public String getRandomDay() {
        String day = null;
        int yearInt = Integer.parseInt(year);
        if (month.equals("February") && yearInt % 4 != 0) {
            day = String.valueOf(faker.number().numberBetween(1, 28));
        } else if (month.equals("February")) {
            day = String.valueOf(faker.number().numberBetween(1, 29));
        } else if (month.equals("April") || month.equals("June") || month.equals("September") || month.equals("November")) {
            day = String.valueOf(faker.number().numberBetween(1, 30));
        } else if (month.equals("January") || month.equals("March") || month.equals("May") || month.equals("Jule") ||
                month.equals("August") || month.equals("October") || month.equals("December")) {
            day = String.valueOf(faker.number().numberBetween(1, 31));
        }
        return day;
    }
    public String getRandomCity() {
        String stateOne = null;
        switch(state) {
            case "NCR":
                stateOne = faker.options().option("Delphi", "Gurgaon", "Noida");
                break;
            case "Uttar Pradesh":
                stateOne = faker.options().option("Agra", "Lucknow", "Merrut");
                break;
            case "Haryana":
                stateOne = faker.options().option("Karnal", "Panipat");
                break;
            case "Rajasthan":
                stateOne = faker.options().option("Jaipur", "Jaiselmer");
                break;
        }
        return stateOne;
    }
}