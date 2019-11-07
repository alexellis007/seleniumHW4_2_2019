package webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyStoreCheckingOrder {
    WebDriverWait wait;
    WebDriver driver;

    // This is a constructor, as every page need a base driver to find web elements
    public MyStoreCheckingOrder(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    //Locators
    @FindBy(how = How.CSS, using = "a[title='Proceed to checkout'][style='']")
    public WebElement checkOut2;

    @FindBy(how = How.CSS, using = "button[name='processAddress']")
    public WebElement checkAddress;

    @FindBy(how = How.XPATH, using = "//input[@id='cgv'][@type='checkbox'][@value='1']")
    public WebElement agreeOnTerms;

    @FindBy(how = How.CSS, using = "button[type='submit'][name='processCarrier']")
    public WebElement checkOut3;

    @FindBy(how = How.XPATH, using = "//a[@class='cheque']")
    public WebElement payCheck;

    @FindBy(how = How.XPATH, using = "//*[@id='total_price']")
    public WebElement orderAmount;

    @FindBy(how = How.XPATH, using = "//button[@class='button btn btn-default button-medium']" +
            "/span[text()='I confirm my order']")
    public WebElement confirmOrder;

    @FindBy(how = How.XPATH, using = "//p[@class='alert alert-success']")
    public WebElement orderComplete;

    @FindBy(how = How.XPATH, using = "//a[@title='Back to orders']")
    public WebElement backToOrder;

    @FindBy(how = How.XPATH, using = "//table[@id='order-list']//td[@class='history_price']/span")
    public WebElement orderPrice;

    @FindBy(how = How.XPATH, using = "//a[@href='http://automationpractice.com/index.php?controller=my-account']")
    public WebElement backToAccount;

    @FindBy(how = How.XPATH, using = "//*[@id='header']/div[2]/div/div/nav/div[2]/a")
    private WebElement logOff;


    public void clickToCheckOut2() {
        wait.until(ExpectedConditions.visibilityOf(checkOut2));
        checkOut2.click();
    }

    public void clickToCheckAddress() {
        wait.until(ExpectedConditions.visibilityOf(checkAddress));
        checkAddress.click();
    }

    public void clickToAgreeOnTerms() {
//        wait.until(ExpectedConditions.visibilityOf(agreeOnTerms));
        agreeOnTerms.click();
    }

    public void clickToCheckOut3() {
        wait.until(ExpectedConditions.visibilityOf(checkOut3));
        checkOut3.click();
    }

    public void selectToPayByCheck() {
        wait.until(ExpectedConditions.visibilityOf(payCheck));
        payCheck.click();
    }

    public String getOrderAmount() {
        wait.until(ExpectedConditions.visibilityOf(payCheck));
        return orderAmount.getText();
    }

    public void confirmOrder() {
        wait.until(ExpectedConditions.visibilityOf(confirmOrder));
        confirmOrder.click();
    }

    public String completeOrderMsg() {
        return (orderComplete.getText());
    }

    public void backToOrder() {
        this.backToOrder.click();
    }

    public String getTotalPrice() {
        return (orderPrice.getText());
    }

    public void logOff() {
        this.logOff.click();
    }

}
