package tests.product;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import tests.base.BaseTest;

import static tests.SwagLabsObjects.productDetails;
import static tests.SwagLabsObjects.products;

public class ProductStepDef extends BaseTest {
    private boolean productSelectionFailed = false;
    @When("select {string}")
        public void selectProduct(String prdName){
         productDetails=products.clickOnProductName(configManager.getValue(prdName));
    }

    @When("click on add to cart button")
    public void pressOnAddToCartButton(){
        productDetails.clickOnAddToCartButton();
    }
    @When("try to select {string}")
    public void trySelectProduct(String prdName) {
        try {
            products.clickOnProductName(configManager.getValue(prdName));
            productSelectionFailed= false;
        } catch (TimeoutException e) {
            productSelectionFailed = true;
        }
    }
    @Then("user should remain on products page")
    public void userShouldRemainOnProductsPage() {
        Assert.assertTrue(productSelectionFailed,
                "Expected product not to be found, but selection succeeded unexpectedly");
        Assert.assertTrue(products.getTitle().isDisplayed(),
                "User is not on the products page anymore");
    }

    @Then("add to cart button changes to remove")
    public void changeButton(){
        Assert.assertTrue(!productDetails.getCartButton().isSelected());
    }


}
