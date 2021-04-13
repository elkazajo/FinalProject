package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Waiters;

import java.util.logging.*;

public class RegistrationPage extends AbstractPage {
    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    private static final Logger logger = Logger.getAnonymousLogger();

    private static final String RADIO_INPUT_XPATH = "(//div[text()=\"Junior Test Automation Engineer in Java\"])[3]";
    private static final String REGISTER_BUTTON_XPATH = "//div[@class=\"uui-caption _1djZg _28khP _371ux\"]";
    private static final String SERVER_PROBLEM_XPATH = "//div[@class=\"_3NZNi _3FxCw\"]";

    @FindBy(xpath = RADIO_INPUT_XPATH)
    private WebElement radioInput;

    @FindBy(xpath = REGISTER_BUTTON_XPATH)
    private WebElement registerButton;

    @FindBy(xpath = SERVER_PROBLEM_XPATH)
    private WebElement serverProblem;

    public RegistrationPage radioInput() {
        Waiters.waitForElementToBeClickable(driver, radioInput);
        radioInput.click();
        return this;
    }

    public RegistrationPage registerButton() {
        registerButton.click();
        return this;
    }

    public RegistrationPage serverProblem() {
        Waiters.waitForPresenceOfElement(SERVER_PROBLEM_XPATH, driver);
        if (serverProblem.isDisplayed()) {
            logger.info("Oops! Looks like the webpage is having server issues again!" +
                    "\n Try running your tests later!");
        } else {
            logger.info("Registration Successful!");
        }
        return this;
    }
}
