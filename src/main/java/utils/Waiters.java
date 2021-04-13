package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waiters {
    public static void waitForPresenceOfElement(String xpath, WebDriver driver) {
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
    }

    public static void waitForElementToBeClickable(WebDriver driver, WebElement webElement) {
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.elementToBeClickable(webElement));
    }
}
