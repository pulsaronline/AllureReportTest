package io.github.pulsaronline.allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
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
    @Feature("Используем библиотеку Allure для логов")
    @Story("Также пользуемся разметкой аннотаций")
    @Severity(SeverityLevel.CRITICAL)
    @Link(name = "Base_URL", url = BASE_URL)
    @DisplayName("Селенидовский логгер")

    public void selenideIssueTest(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        //"Открываем главную страницу"
        open(BASE_URL);
        //"Ищем репозиторий"
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(REPOSITORY);
        $(".header-search-input").submit();
        //"Переходим в репозиторий"
        $(By.linkText(REPOSITORY)).click();
        //"Переходим в Issues"
        $(withText("Issue12")).click();
        //"Проверяем что About существует"
        $(withText("About")).should(Condition.exist);
        }
}
