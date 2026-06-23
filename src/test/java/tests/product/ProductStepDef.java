package tests.product;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import tests.base.BaseTest;

import static tests.SwagLabsObjects.productDetails;
import static tests.SwagLabsObjects.products;

public class ProductStepDef extends BaseTest {
    @When("select {string}")
        public void selectProduct(String prdName){
         productDetails=products.clickOnProductName(configManager.getValue(prdName));
    }

    @When("click on add to cart button")
    public void pressOnAddToCartButton(){
        productDetails.clickOnAddToCartButton();
    }

    @Then("add to cart button changes to remove")
    public void changeButton(){
        Assert.assertTrue(!productDetails.getCartButton().isSelected());
    }


}
