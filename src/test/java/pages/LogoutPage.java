package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.aventstack.extentreports.ExtentTest;
import java.time.Duration;
import objectrepository.Locators;

public class LogoutPage {
    WebDriver driver;
    ExtentTest extTest;

    public LogoutPage(WebDriver driver, ExtentTest test) {
        this.driver = driver;
        this.extTest = test;
    }

    public void logout() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(Locators.menuButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(Locators.logoutLink)).click();
        extTest.pass("User logged out successfully");
    }
}
