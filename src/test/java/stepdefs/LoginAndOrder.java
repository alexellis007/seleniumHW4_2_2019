package stepdefs;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import webpages.MyStoreCheckingOrder;
import webpages.MyStoreLogIn;
import webpages.MyStoreSelectProduct;

public class LoginAndOrder {

    MyStoreLogIn logInToPage;
    MyStoreSelectProduct selectProduct;
    MyStoreCheckingOrder checkOrder;
    WebDriver driver;
    String expectedText = "Your order on My Store is complete.";
    String actualText;
    String amount;
    String expectedTitle = "My Store";
    WebDriverWait wait;

    @Before
    public void launchBrowserDriver() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 5);
        logInToPage = new MyStoreLogIn(driver);
        selectProduct = new MyStoreSelectProduct(driver, wait);
        checkOrder = new MyStoreCheckingOrder(driver, wait);
    }

    @After
    public void stopBrowserDriver() {
        driver.quit();
    }


    @Given("^user navigate to the app url$")
    public void userNavigateToTheAppUrl() {
        driver.get("http://automationpractice.com");
        Assert.assertEquals(driver.getTitle(), expectedTitle, "Incorrect web site has been opened: ");
    }

    @When("^user signs in with values \"([^\"]*)\" and \"([^\"]*)\"$")
    public void userSignsInWithValuesAnd(String email, String password) {
        logInToPage.clickSignIn();
        logInToPage.setUserEmail(email);
        logInToPage.setUserPassword(password);
        logInToPage.clickLogin();
    }

    @And("^user selects 'Women' menu$")
    public void userSelectsWomenMenu() {
        selectProduct.selectCustomerGroup();
    }

    @And("^user selects product$")
    public void userSelectsProduct() {
        selectProduct.selectProduct();
    }

    @And("^user adds product to you cart$")
    public void userAddsProductToYouCart() {
        selectProduct.setAddToCart();
    }

    @And("^user clicks on 'Proceed to checkout'$")
    public void userClicksOnProceedToCheckout() {
        selectProduct.clickToCheckOut1();
    }

    @And("^user verifies cart, clicks on 'Proceed to checkout'$")
    public void userVerifiesCartClicksOnProceedToCheckout() {
        checkOrder.clickToCheckOut2();
    }

    @And("^user verifies delivery/billing address, clicks on 'Proceed to checkout'$")
    public void userVerifiesDeliveryBillingAddressClicksOnProceedToCheckout() {
        checkOrder.clickToCheckAddress();
    }

    @And("^user agrees on terms and clicks on 'Proceed to checkout'$")
    public void userAgreesOnTermsAndClicksOnProceedToCheckout() {
        checkOrder.clickToAgreeOnTerms();
        checkOrder.clickToCheckOut3();
    }

    @And("^user gets the order amount and selects 'Pay by Check'$")
    public void userGetsTheOrderAmountAndSelectsPayByCheck() {
        amount = checkOrder.getOrderAmount();
        System.out.println(amount);
        checkOrder.selectToPayByCheck();
    }

    @And("^user clicks to confirm order$")
    public void userClicksToConfirmOrder() {
        checkOrder.confirmOrder();
    }

    @And("^user checks on order completion$")
    public void userChecksOnOrderCompletion() {
        Assert.assertEquals(checkOrder.completeOrderMsg(), expectedText, "Order was not completed correctly: ");
    }

    @And("^user returns to the order$")
    public void userReturnsToTheOrder() {
        checkOrder.backToOrder();
    }

    @And("^user verifies order and total price$")
    public void userVerifiesOrderAndTotalPrice() {
        System.out.println(checkOrder.getTotalPrice());
        Assert.assertEquals(checkOrder.getTotalPrice(), amount, "Order amount and total price are not matching: ");
    }

    @And("^user logout from account$")
    public void userLogoutFromAccount() {
    }
}
