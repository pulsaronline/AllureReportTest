package io.github.pulsaronline.allure;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.open;

public class TestBase {
    @BeforeAll
    static public void setup() {
        Configuration.browserSize = "1024x768";
        open("https://demoqa.com/automation-practice-form");
    }
}
