package io.github.pulsaronline.allure;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class lambdaTest {
    @Test
    //TODO: пример ссылки на динамические логи
    public void searchForIssue() {
        step("Открываем главную страницу", () -> open("https://github.com"));
        step("Ищем репозиторий", ()-> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys("pulsaronline/AllureReportTest");
            $(".header-search-input").submit();
        });
        step("Переходим в репозиторий", ()-> $(By.linkText("pulsaronline/AllureReportTest")).click());
        step("Переходим в Issues", ()-> $(withText("Issue")).click());
        step("Проверяем что Issues существует", ()-> {
            $(withText("Issue")).should(Condition.exist);
        });
    }
}
