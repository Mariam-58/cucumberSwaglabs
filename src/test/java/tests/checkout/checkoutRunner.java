package tests.checkout;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/tests/checkout/negativeCheckout.feature",
        glue = {"tests"},
        plugin = {"pretty","html:report/cucumber-reports.html",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}
)

public class checkoutRunner extends AbstractTestNGCucumberTests {
}
