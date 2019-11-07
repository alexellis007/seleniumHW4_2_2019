package webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

public class MyStoreSelectProduct {
    WebDriverWait wait;
    WebDriver driver;

    // This is a constructor, as every page need a base driver to find web elements
    public MyStoreSelectProduct(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    //Locators
    @FindBy(how = How.CSS, using = "a[title='Women']")
    public WebElement customerGroup;

    @FindBy(how = How.XPATH, using = "//a[@class='product_img_link']")
    public List<WebElement> products;

    @FindBy(how = How.XPATH, using = "div/div/div/a/img[@class='replace-2x img-responsive']")
    public WebElement selectedProduct;

    @FindBy(how = How.CSS, using = "button[class='exclusive'][name='Submit']")
    public WebElement addToCart;

    @FindBy(how = How.XPATH, using = "//div[@class='button-container']/a/span/i")
    public WebElement checkOut1;

    public void selectCustomerGroup() {
        customerGroup.click();
    }

    public void selectProduct() {
        System.out.println((int)products.size());
        Random randomProduct = new Random();
        int randElement = randomProduct.nextInt(products.size());
        System.out.println(randElement);

        selectedProduct = products.get(randElement);
        wait.until(ExpectedConditions.visibilityOf(selectedProduct));
        selectedProduct.click();
    }

    public void setAddToCart() {
        wait.until(ExpectedConditions.visibilityOf(addToCart));
        addToCart.click();
    }

    public void clickToCheckOut1() {
        wait.until(ExpectedConditions.visibilityOf(checkOut1));
        checkOut1.click();
    }
}
