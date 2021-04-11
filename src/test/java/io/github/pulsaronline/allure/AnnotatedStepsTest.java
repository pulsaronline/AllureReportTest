package io.github.pulsaronline.allure;

import org.junit.jupiter.api.Test;

public class AnnotatedStepsTest {
    private final static String repository = "pulsaronline/AllureReportTest";
    private final WebSteps steps = new WebSteps();

    @Test
    public void annotatedSearchForIssue() {
        steps.openMainPage();
        steps.searchForRepository(repository);
        steps.goToRepository(repository);
        steps.clickOnIssueTab();
        steps.shouldSeeIssue();
    }
}
