package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.aventstack.extentreports.ExtentTest;
import java.time.Duration;
import objectrepository.Locators;

public class AddToCartPage {
    WebDriver driver;
    ExtentTest extTest;

    public AddToCartPage(WebDriver driver, ExtentTest test) {
        this.driver = driver;
        this.extTest = test;
    }

    public void addProductToCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(Locators.addToCartButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(Locators.cartIcon)).click();
        extTest.pass("Product added to cart and navigated to cart page");
    }
}