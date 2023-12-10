package guru.qa.pages.components;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    private final SelenideElement dayOfBirthField = $(".react-datepicker__month");
    private final SelenideElement monthOfBirthField = $(".react-datepicker__month-select");
    private final SelenideElement yearOfBirthField = $(".react-datepicker__year-select");
    public void setDate(String month, String year, String day) {
        monthOfBirthField.selectOption(month);
        yearOfBirthField.selectOption(year);
        dayOfBirthField.$(byText(day)).click();
    }
}