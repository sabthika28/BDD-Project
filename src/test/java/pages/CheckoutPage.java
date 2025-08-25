package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.aventstack.extentreports.ExtentTest;
import java.time.Duration;
import objectrepository.Locators;

public class CheckoutPage {
    WebDriver driver;
    ExtentTest extTest;

    public CheckoutPage(WebDriver driver, ExtentTest test) {
        this.driver = driver;
        this.extTest = test;
    }

    public void proceedToCheckout() {
        driver.findElement(Locators.cartIcon).click();

 
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(Locators.checkoutButton)).click();

        extTest.pass("Proceeded to checkout successfully");
    }
}