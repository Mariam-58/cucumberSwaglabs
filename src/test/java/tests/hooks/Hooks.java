package tests.hooks;

import org.openqa.selenium.WebDriver;
import tests.utilties.ConfigManager;
import tests.utilties.Screenshots;
import tests.driver.WebDriverFactory;
import tests.base.BaseTest;
import example.loginPage.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.asserts.SoftAssert;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Hooks extends BaseTest {
    private static WebDriver driver;
    private Logger log = LogManager.getLogger(Hooks.class);

    @Before
    public void setUp() {
        configManager = new ConfigManager("src/main/resources/Config.properties");
        log.debug("Configuration file manager initialization");
        driver = WebDriverFactory.getDriver(configManager.getValue("browser"));
        loginPage = new LoginPage(driver);
        softAssert = new SoftAssert();
    }

    @AfterStep
    public void checkFail(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
            File scrShot = Screenshots.takesshots(driver, "Screenshots/" + scenario.getName() + ".png");
            Allure.addAttachment("Screenshots", new FileInputStream(scrShot));
        }
    }

    @After
    public void tearDown() {
    tests.driver.ChromeDriverClass.quitDriver();
    }
}