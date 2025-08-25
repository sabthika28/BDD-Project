package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.aventstack.extentreports.ExtentTest;
import java.time.Duration;
import objectrepository.Locators;

public class CustomerInformationPage {
    WebDriver driver;
    ExtentTest extTest;

    public CustomerInformationPage(WebDriver driver, ExtentTest test) {
        this.driver = driver;
        this.extTest = test;
    }

    public void enterCustomerInfo(String fName, String lName, String zip) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.firstName)).sendKeys(fName);
        driver.findElement(Locators.lastName).sendKeys(lName);
        driver.findElement(Locators.postalCode).sendKeys(zip);
        driver.findElement(Locators.continueButton).click();
        extTest.pass("Customer information entered successfully");
    }
}
