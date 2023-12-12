package guru.qa.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import guru.qa.pages.components.CheckResultComponent;
import guru.qa.utils.TestData;
import io.qameta.allure.Description;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import guru.qa.pages.PracticeFormPage;

import static io.qameta.allure.Allure.step;
@DisplayName("Модуль 'Форма практики'")
public class PracticeFormTest extends BaseTest {
    PracticeFormPage practiceFormPage = new PracticeFormPage();
    CheckResultComponent checkResultComponent = new CheckResultComponent();
    TestData data = new TestData();
    @BeforeEach
    public void allureSteps() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }
    @AfterEach
    public void addAttachments() {
        helpers.Attach.screenshotAs("Last screenshot");
        helpers.Attach.pageSource();
        helpers.Attach.browserConsoleLogs();
        helpers.Attach.addVideo();
    }
    @Test
    @Tag("SMOKE")
    @DisplayName("Отправка веб-форма со всеми полями заполеннными валидными значениями")
    public void allFieldsAreFilledInTest(){
        step("Заполнение и отправка веб-формы с валидными значениями", () -> {
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
        step("Проверка результатов заполнения веб-формы", () -> {
            checkResultComponent.AssertResultComponent(data.label, data.values);
        });
    }
    @Test
    @Tag("WEB")
    @DisplayName("Отправка веб-форма с заполеннными обязательными полями валидными значениями")
    public void onlyRequiredFieldsAreFilledInTest(){
        step("Заполнение и отправка веб-формы с валидными значениями", () -> {
            practiceFormPage.openWebForm()
                    .closedBanner()
                    .setValueFirstName(data.firstName)
                    .setValueLastName(data.lastName)
                    .setValueEmail(data.email)
                    .setValueGender(data.gender)
                    .setValueMobile(data.phone)
                    .buttonClick();
        });
        step("Проверка результатов заполнения веб-формы", () -> {
            checkResultComponent.checkResult("Student Name", data.firstName + " " + data.lastName)
                    .checkResult("Student Email", data.email)
                    .checkResult("Gender", data.gender)
                    .checkResult("Mobile", data.phone);
        });
    }
    @Test
    @Tag("WEB")
    @DisplayName("Отправка веб-формы с одним не заполненным обязательным полем")
    public void oneIsNotFilledInNecessarilyTest() {
        step("Заполнение и отправка веб-формы с валидными значениями", () -> {
            practiceFormPage.openWebForm()
                    .closedBanner()
                    .setValueFirstName(data.firstName)
                    .setValueEmail(data.email)
                    .setValueGender(data.gender)
                    .setValueMobile(data.phone)
                    .buttonClick();
        });
        step("Проверка результатов заполнения веб-формы", () -> {
            checkResultComponent.checkResultElement("Practice Form");
        });
    }
}
