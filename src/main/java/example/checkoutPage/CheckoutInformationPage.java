package example.checkoutPage;

import example.basePage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutInformationPage extends BasePage {

    private By pageTitle = By.xpath("//span[@class='title']");
    private By fristname = By.id("first-name");
    private By lastname = By.id("last-name");
    private By postalcode = By.id("postal-code");
    private By continueButton = By.id("continue");
    private By cancelButton = By.id("cancel");
    private By cartButton = By.xpath("//*[@id='shopping_cart_container']/a");

    public CheckoutInformationPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getPageTitle() {
        return findElement(pageTitle);
    }
    public WebElement getFirstName() {
        return findElement(fristname);
    }
    public WebElement getLastName() {
        return findElement(lastname);
    }
    public WebElement getPostalCode() {
        return findElement(postalcode);
    }
    public WebElement getContinueButton() {
        return findElement(continueButton);
    }
    public WebElement getCancelButton() {
        return findElement(cancelButton);
    }
    public WebElement getCartButton() {
        return findElement(cartButton);
    }

    public void enterFirstName(String firstName) {
        findElement(fristname).clear();
        findElement(fristname).sendKeys(firstName);
    }
    public void enterLastName(String lastName) {
        findElement(lastname).clear();
        findElement(lastname).sendKeys(lastName);
    }
    public void enterPostalCode(String zipCode) {
        findElement(postalcode).clear();
        findElement(postalcode).sendKeys(zipCode);
    }

    public CheckoutOverviewPage ClickOnContinueButton() {
        findElement(continueButton).click();
        return new CheckoutOverviewPage(driver);
    }
    public WebElement getErrorCheckoutMessage() {
        return findElement(By.xpath("//*[@id=\"checkout_info_container\"]/div/form/div[1]/div[4]"));
    }
}
