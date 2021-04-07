package io.github.pulsaronline.allure;

import com.codeborne.selenide.Condition;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@DisplayName("Набор тестов с аннотациями")
public class SelenideTest {
    private final String BASE_URL = "https://github.com";
    private final String REPOSITORY = "pulsaronline/AllureReportTest";

    @Test
    @Owner("pulsaronline")
    @Feature("Работа с разметкой")
    @Story("Разметка аннотаций")
    @Severity(SeverityLevel.BLOCKER)
    @Link(name = "Base_URL", url = BASE_URL)
    @DisplayName("Пример теста с аннотациями")

    public void selenideIssueTest(){
        //"Открываем главную страницу"
        open(BASE_URL);
        //"Ищем репозиторий"
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(REPOSITORY);
        $(".header-search-input").submit();
        //"Переходим в репозиторий"
        $(By.linkText(REPOSITORY)).click();
        //"Переходим в Issues"
        $(withText("Issue")).click();
        //"Проверяем что About существует"
        $(withText("About")).should(Condition.exist);
        }
}
