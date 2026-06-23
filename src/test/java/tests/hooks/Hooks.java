package tests.hooks;

import org.openqa.selenium.WebDriver;
import tests.utilties.ConfigManager;
import tests.utilties.Screenshots;
import tests.driver.WebDriverFactory;
import tests.base.BaseTest;
import example.loginPage.LoginPage;
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



public class Hooks extends BaseTest{
    private static WebDriver driver;

    private Logger log = LogManager.getLogger(Hooks.class);

    @Before
    public void setUp() {
//        excelFileManager = new ExcelFileManager("C:\\Users\\L125-PC0\\Downloads\\Sawagl_labs\\Sawagl_labs\\Sawagl_labs\\src\\main\\resources\\newData.xlsx","Sheet1");
//        log.debug("Excel File Manager Initialized");

        configManager = new ConfigManager("src/main/resources/Config.properties");
        log.debug("Configuration file manager initialization");

//
//        csvFileManager = new CSVFileManager("src/main/resources/CSVData.csv");
//        log.debug("CSV file manager initialization");

        driver = WebDriverFactory.getDriver(configManager.getValue("browser"));
        loginPage = new LoginPage(driver);
        softAssert = new SoftAssert();
    }

    @AfterStep
    public void checkFail(Scenario scenario) throws IOException {
        if(scenario.isFailed())
        {
            File scrShot = Screenshots.takesshots(driver, "Screenshots/" + scenario.getName() + ".png");
            Allure.addAttachment("Screenshots",new FileInputStream(scrShot));
        }
    }
}