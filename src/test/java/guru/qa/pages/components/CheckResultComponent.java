package guru.qa.pages.components;

import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CheckResultComponent {
    private final SelenideElement tableElement = $("table");
    private final SelenideElement practiceFormElement = $(".playgound-header");
    public void AssertResultComponent(List<String> label, List<String> values) {
        for (int i = 0; i < values.size(); i++)
            tableElement.$(byText(label.get(i))).sibling(0).shouldHave(text(values.get(i)));
    }
    public CheckResultComponent checkResult(String key, String value){
        tableElement.$(byText(key))
                .parent()
                .shouldHave(text(value));

        return this;
    }
    public void checkResultElement(String value) {
        practiceFormElement.shouldHave(text(value));
    }
}