package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

abstract public class BaseTest {
    @BeforeAll
    public static void setUp() {
        Configuration.browserSize = "1600х900";
        Configuration.baseUrl = "https://www.kinopoisk.ru/";
        Configuration.pageLoadStrategy = "eager";
    }
}
