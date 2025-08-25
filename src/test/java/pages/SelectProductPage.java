package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import objectrepository.Locators;
import utils.Reporter;

public class SelectProductPage {
    WebDriver driver;
    WebDriverWait wait;
    ExtentTest extTest;

    public SelectProductPage(WebDriver driver, ExtentTest extTest) {
        this.driver = driver;
        this.extTest = extTest;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void selectProduct() {
        driver.findElement(Locators.product).click();

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("back-to-products")));
            Reporter.generateReport(driver, extTest, Status.PASS, "Product selected successfully and Back to Products button visible");
        } catch (TimeoutException te) {
            Reporter.generateReport(driver, extTest, Status.FAIL, "Product selection failure");
        }
    }
}