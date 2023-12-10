package guru.qa.pages;

import com.codeborne.selenide.SelenideElement;
import guru.qa.pages.components.CalendarComponent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormPage {
    private final SelenideElement firstNameField = $("#firstName");
    private final SelenideElement lastNameField = $("#lastName");
    private final SelenideElement emailField = $("#userEmail");
    private final SelenideElement genderRadioButton = $("#genterWrapper");
    private final SelenideElement  mobileField = $("#userNumber");
    private final SelenideElement dateOfBirthField = $("#dateOfBirthInput");
    private final SelenideElement subjectsField = $("#subjectsInput");
    private final SelenideElement hobbiesCheckbox = $("#hobbiesWrapper");
    private final SelenideElement pictureField = $("#uploadPicture");
    private final SelenideElement currentAddressField = $("#currentAddress");
    private final SelenideElement selectStateList = $("#stateCity-wrapper").$(byText("Select State")).parent();
    private final SelenideElement stateListValue = $(".css-11unzgr");
    private final SelenideElement selectCityList = $("#stateCity-wrapper").$(byText("Select City")).parent();
    private final SelenideElement cityListValue = $(".css-11unzgr");
    private final SelenideElement submitButton = $("#submit");
    CalendarComponent calendarComponent = new CalendarComponent();
    public PracticeFormPage openWebForm() {
        open("/automation-practice-form");

        return this;
    }
    public PracticeFormPage closedBanner() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }
    public PracticeFormPage setValueFirstName(String firstName) {
        firstNameField.setValue(firstName);

        return this;
    }
    public PracticeFormPage setValueLastName(String lastName) {
        lastNameField.setValue(lastName);

        return this;
    }

    public PracticeFormPage setValueEmail(String email) {
        emailField.setValue(email);

        return this;
    }
    public PracticeFormPage setValueGender(String gender) {
        genderRadioButton.$(byText(gender)).click();

        return this;
    }
    public PracticeFormPage setValueMobile(String mobile) {
        mobileField.setValue(mobile);

        return this;
    }
    public PracticeFormPage setValueDateOfBirth(String month, String year, String day) {
        dateOfBirthField.click();
        calendarComponent.setDate(month, year, day);

        return this;
    }
    public PracticeFormPage setValueSubjects(String subjects) {
        subjectsField.setValue(subjects).pressEnter();

        return this;
    }
    public PracticeFormPage setValueHobbiesCheckBox(String hobbies) {
        hobbiesCheckbox.$(byText(hobbies)).click();

        return this;
    }
    public PracticeFormPage downloadPicture(String photo){
        pictureField.uploadFromClasspath(photo);

        return this;
    }
    public PracticeFormPage setValueCurrentAddress(String address) {
        currentAddressField.setValue(address);

        return this;
    }

    public PracticeFormPage setValueSelectStateAndCity(String state, String city){
        selectStateList.click();
        stateListValue.$(byText(state)).click();
        selectCityList.click();
        cityListValue.$(byText(city)).click();

        return  this;
    }
    public void buttonClick(){
        submitButton.click();
    }
}