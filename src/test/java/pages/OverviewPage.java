package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.aventstack.extentreports.ExtentTest;
import java.time.Duration;
import objectrepository.Locators;

public class OverviewPage {
    WebDriver driver;
    ExtentTest extTest;

    public OverviewPage(WebDriver driver, ExtentTest test) {
        this.driver = driver;
        this.extTest = test;
    }

    public void finishOrder() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(Locators.finishButton)).click();
        extTest.pass("Order finished successfully");
    }
}
