package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Waiters;

public class LoginPage extends AbstractPage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private static final String ENTER_LOGIN = "//input[@id=\"username\"]";
    private static final String CONTINUE_BUTTON = "//button[@id=\"kc-login-next\"]";
    private static final String ENTER_PASSWORD = "//input[@id=\"password\"]";
    private static final String STAY_SIGNED_IN = "//input[@id=\"rememberMe\"]";
    private static final String SIGN_IN = "//input[@id=\"kc-login\"]";
    private static final String USERNAME = "marlik@inbox.ru";
    private static final String PASSWORD = "testAutomation2021";

    @FindBy(xpath = ENTER_LOGIN)
    private WebElement enterLogin;

    @FindBy(xpath = CONTINUE_BUTTON)
    private WebElement continueButton;

    @FindBy(xpath = ENTER_PASSWORD)
    private WebElement enterPassword;

    @FindBy(xpath = STAY_SIGNED_IN)
    private WebElement staySignedIn;

    @FindBy(xpath = SIGN_IN)
    private WebElement signIn;

    public LoginPage enterUserName() {
        enterLogin.sendKeys(USERNAME);
        return this;
    }

    public LoginPage clickContinue() {
        continueButton.click();
        return this;
    }

    public LoginPage enterUserPassword() {
        Waiters.waitForElementToBeClickable(driver, enterPassword);
        enterPassword.sendKeys(PASSWORD);
        return this;
    }

    public LoginPage rememberMe() {
        staySignedIn.submit();
        return this;
    }

    public LoginPage logIn() {
        signIn.click();
        return this;
    }
}
