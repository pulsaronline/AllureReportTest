package io.github.pulsaronline.allure;

import io.qameta.allure.Allure;
import org.junit.jupiter.api.Test;
import java.util.UUID;
import static com.codeborne.selenide.Selenide.open;

public class DynamicTest {
private final String uuid = UUID.randomUUID().toString();

    @Test
    void testDynamic() {
        open("https://github.com?session=" + uuid);
        Allure.getLifecycle().updateTestCase(tc -> tc.setName("Динамический тест"));
        Allure.label("owner", "pulsaronline");
        Allure.feature("Работа с разметкой");
        Allure.story("Динамическая разметка аннотаций");
        Allure.link("BaseUrl", "https://logdatabase.com?session=" + uuid);
    }
}
