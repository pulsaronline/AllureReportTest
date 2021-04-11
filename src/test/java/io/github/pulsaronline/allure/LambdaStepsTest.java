package io.github.pulsaronline.allure;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class LambdaStepsTest {
    private final String BASE_URL = "https://github.com";
    private final String REPOSITORY = "pulsaronline/AllureReportTest";

    @Test
    //TODO: пример ссылки на динамические логи
    public void lambdaSearchForIssue() {
        Allure.parameter("Repository", REPOSITORY);
        step("Открываем главную страницу", (step) -> {
        step.parameter("url", BASE_URL);
        open(BASE_URL);
        });
        step("Ищем репозиторий", (step)-> {
            step.parameter("Repository", REPOSITORY);
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
        });
        step("Переходим в репозиторий", ()-> $(By.linkText(REPOSITORY)).click());
        step("Переходим в Issues", ()-> $(withText("Issue")).click());
        step("Проверяем что About существует", ()-> {
            $(withText("About")).should(Condition.exist);
        });
    }
}
