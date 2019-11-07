package webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class MyStoreLogIn {
    WebDriver driver;

    // This is a constructor, as every page need a base driver to find web elements
    public MyStoreLogIn(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Locators
    @FindBy(how = How.CSS, using = "a[class=login]")
    public WebElement signIn;

    @FindBy(how = How.XPATH, using = "//input[@id='email']")
    public WebElement userEmail;

    @FindBy(how = How.XPATH, using = "//input[@id='passwd']")
    public WebElement userPassword;

    @FindBy(how = How.XPATH, using = "//button[@id='SubmitLogin']")
    public WebElement logIn;

    public void clickSignIn() {
        this.signIn.click();
    }

    public void setUserEmail(String userEmail) {
        this.userEmail.sendKeys(userEmail);
    }

    public void setUserPassword(String userPassword) {
        this.userPassword.sendKeys(userPassword);
    }

    public void clickLogin() {
        this.logIn.click();
    }

}
