package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Waiters;

public class StartPage extends AbstractPage {

    private static final String EXPLORE_BUTTON = "//input[@class=\"uui-input\"]";
    private static final String SEARCH_COURSE = "//input[@class=\"uui-input\"]";
    private static final String COURSE_CONTAINER = "//a[@class=\"_3dAIk uui-anchor uui-enabled -clickable\"]";
    private static final String LOGIN_TO_START = "(//div[@class=\"uui-caption _1djZg _28khP _371ux\"])[3]";
    private static final String COURSE_NAME = "Test Automation";

    @FindBy(xpath = EXPLORE_BUTTON)
    private WebElement exploreButton;

    @FindBy(xpath = SEARCH_COURSE)
    private WebElement searchCourse;

    @FindBy(xpath = COURSE_CONTAINER)
    private WebElement courseContainer;

    @FindBy(xpath = LOGIN_TO_START)
    private WebElement loginToStart;

    public StartPage(WebDriver driver) {
        super(driver);
    }

    public StartPage exploreCourses() {
        exploreButton.click();
        return this;
    }

    public StartPage findCourse() {
        Waiters.waitForPresenceOfElement(SEARCH_COURSE, driver);
        searchCourse.sendKeys(COURSE_NAME);
        return this;
    }

    public StartPage chooseCourse() {
        Waiters.waitForPresenceOfElement(COURSE_CONTAINER, driver);
        courseContainer.click();
        return this;
    }

    public StartPage loginToRegister() {
        Waiters.waitForPresenceOfElement(LOGIN_TO_START, driver);
        loginToStart.click();
        return this;
    }
}
