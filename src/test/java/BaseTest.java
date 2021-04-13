import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.RegistrationPage;
import pages.StartPage;
import utils.DriverSet;

public class BaseTest {
    private WebDriver driver;

    @BeforeTest
    private void StartDriver() {
        DriverSet driverSet = new DriverSet();
        driver = driverSet.getDriver();
        driver.get("https://learn.epam.com/start");
        driver.manage().window().maximize();
    }

    @Test
    private void Test() {
        StartPage startPage = new StartPage(driver);
        startPage.exploreCourses().findCourse().chooseCourse().loginToRegister();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUserName().clickContinue().enterUserPassword().rememberMe();

        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.radioInput().registerButton().serverProblem();
    }

    @AfterTest
    private void TearDown() {
        driver.quit();
        driver = null;
    }
}
