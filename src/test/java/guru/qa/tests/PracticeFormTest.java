package guru.qa.tests;

import guru.qa.pages.components.CheckResultComponent;
import guru.qa.utils.TestData;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import guru.qa.pages.PracticeFormPage;

public class PracticeFormTest extends BaseTest {
    PracticeFormPage practiceFormPage = new PracticeFormPage();
    CheckResultComponent checkResultComponent = new CheckResultComponent();
    TestData data = new TestData();
    @Test
    @Tag("SMOKE")
    public void allFieldsAreFilledInTest(){
        practiceFormPage.openWebForm()
                .closedBanner()
                .setValueFirstName(data.firstName)
                .setValueLastName(data.lastName)
                .setValueEmail(data.email)
                .setValueGender(data.gender)
                .setValueMobile(data.phone)
                .setValueDateOfBirth(data.month, data.year, data.day)
                .setValueSubjects(data.subjects)
                .setValueHobbiesCheckBox(data.hobbies)
                .downloadPicture(data.picture)
                .setValueCurrentAddress(data.currentAddress)
                .setValueSelectStateAndCity(data.state, data.city)
                .buttonClick();
        checkResultComponent.AssertResultComponent(data.label, data.values);
    }
    @Test
    @Tag("WEB")
    public void onlyRequiredFieldsAreFilledInTest(){
        practiceFormPage.openWebForm()
                .closedBanner()
                .setValueFirstName(data.firstName)
                .setValueLastName(data.lastName)
                .setValueEmail(data.email)
                .setValueGender(data.gender)
                .setValueMobile(data.phone)
                .buttonClick();
        checkResultComponent.checkResult("Student Name", data.firstName + " " + data.lastName)
                .checkResult("Student Email", data.email)
                .checkResult("Gender", data.gender)
                .checkResult("Mobile", data.phone);
    }
    @Test
    @Tag("WEB")
    public void oneIsNotFilledInNecessarilyTest() {
        practiceFormPage.openWebForm()
                .closedBanner()
                .setValueFirstName(data.firstName)
                .setValueEmail(data.email)
                .setValueGender(data.gender)
                .setValueMobile(data.phone)
                .buttonClick();
        checkResultComponent.checkResultElement("Practice Form");
    }
}
