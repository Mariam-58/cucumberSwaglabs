package tests.checkout;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tests.base.BaseTest;

import static tests.SwagLabsObjects.*;

public class CheckoutStepDef extends BaseTest {



    @When("click on cart button")
    public void pressOnCart() {
        cartPage = productDetails.clickOnCartButton();

    }
    @When("click on checkout button")
    public void pressOnCheckoutButton() {
        checkoutInformationPage = cartPage.clickOnCheckoutButton();
    }
    @When("enter {string} and {string} and {string}")
    public void enterFirstNameAndLastNameAndZipCode(String firstName, String lastName, String zipCode) {
        checkoutInformationPage.enterFirstName(configManager.getValue(firstName));
        checkoutInformationPage.enterLastName(configManager.getValue(lastName));
        checkoutInformationPage.enterPostalCode(configManager.getValue(zipCode));
    }
    @When("click on continue button")
    public void ClickOnFinishButton() {
        checkoutOverviewPage = checkoutInformationPage.ClickOnContinueButton();
    }
    @When("click on Finish button")
    public void clickOnFinishButton() {
        checkoutCompletePage = checkoutOverviewPage.clickOnFinishButton();
    }
    @Then("checkout complete")
    public void verifyThatTheUserIsOnCheckoutCompletePage() {
        checkoutCompletePage.getPageTitle().isDisplayed();  }


    @When("click on checkout button without data")
    public void pressOnCheckoutButtonWithoutData() {
        checkoutInformationPage = cartPage.clickOnCheckoutButton();
    }
    @When("click on continue button without data")
    public void clickOnContinueButtonWithoutData() {
        checkoutOverviewPage = checkoutInformationPage.ClickOnContinueButton();
    }
    @Then("error checkout message is appeared")
    public void verifyThatErrorMessageIsDisplayedOnCheckoutInformationPage() {
        checkoutInformationPage.getErrorCheckoutMessage().isDisplayed();
    }
}

