package tests.login;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import tests.base.BaseTest;
import tests.driver.WebDriverFactory;

import static tests.SwagLabsObjects.products;

public class LoginStepDef extends BaseTest {

    @Given("site is opened")
    public void siteIsOpen(){
        WebDriverFactory.getDriver(configManager.getValue("browser")).get(configManager.getValue("url"));
    }

    @When("enter {string} and {string}")
    public void enterUserNameAndEnterPassword(String user, String pass){
        loginPage.enterUserName(configManager.getValue(user));
        loginPage.enterPassword(configManager.getValue(pass));
    }

    @When("click on login button")
    public void clickOnLoginButton(){
        products = loginPage.clickOnLoginButton();
    }

    @Then("home title is appeared")
    public void verifyTheLoginSuccessfully(){
        Assert.assertTrue(products.getTitle().isDisplayed());
    }

    @Then("error message is appeared")
    public void verifyTheLoginUnSuccessfully() {
        Assert.assertTrue(loginPage.getErrorMessage().isDisplayed());
    }
}