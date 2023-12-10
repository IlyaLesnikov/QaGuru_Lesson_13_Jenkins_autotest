package guru.qa.tests;

import guru.qa.pages.components.CheckResultComponent;
import guru.qa.utils.TestData;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import guru.qa.pages.PracticeFormPage;

import static io.qameta.allure.Allure.step;

public class PracticeFormTest extends BaseTest {
    PracticeFormPage practiceFormPage = new PracticeFormPage();
    CheckResultComponent checkResultComponent = new CheckResultComponent();
    TestData data = new TestData();
    @Test
    @Tag("SMOKE")
    public void allFieldsAreFilledInTest(){
        step("Заполнение веб-формы валидными значениями и отправка её", () -> {
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
        });
        step("Проверка результатов заполнения формы", () -> {
            checkResultComponent.AssertResultComponent(data.label, data.values);
        });
    }
    @Test
    @Tag("WEB")
    public void onlyRequiredFieldsAreFilledInTest(){
        step("Заполнение веб-формы валидными значениями и отправка её", () -> {
            practiceFormPage.openWebForm()
                    .closedBanner()
                    .setValueFirstName(data.firstName)
                    .setValueLastName(data.lastName)
                    .setValueEmail(data.email)
                    .setValueGender(data.gender)
                    .setValueMobile(data.phone)
                    .buttonClick();
        });
        step("Проверка результатов заполнения формы", () -> {
            checkResultComponent.checkResult("Student Name", data.firstName + " " + data.lastName)
                    .checkResult("Student Email", data.email)
                    .checkResult("Gender", data.gender)
                    .checkResult("Mobile", data.phone);
        });
    }
    @Test
    @Tag("WEB")
    public void oneIsNotFilledInNecessarilyTest() {
        step("Заполнение веб-формы валидными значениями и отправка её", () -> {
            practiceFormPage.openWebForm()
                    .closedBanner()
                    .setValueFirstName(data.firstName)
                    .setValueEmail(data.email)
                    .setValueGender(data.gender)
                    .setValueMobile(data.phone)
                    .buttonClick();
        });
        step("Проверка результатов заполнения формы", () -> {
            checkResultComponent.checkResultElement("Practice Form");
        });
    }
}
