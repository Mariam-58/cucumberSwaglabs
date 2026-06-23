package tests.base;

import example.loginPage.LoginPage;
import example.productPage.ProductsPage;
import org.testng.asserts.SoftAssert;
import tests.utilties.CSVFileManager;
import tests.utilties.ExcelFileManager;
import tests.utilties.ConfigManager;


public class BaseTest {
    public static ProductsPage productsPage;
    protected static ConfigManager configManager;
    protected static ExcelFileManager excelFileManager;
    protected static CSVFileManager csvFileManager;
    protected static SoftAssert softAssert;
    protected static LoginPage loginPage;
}
