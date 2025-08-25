package stepdefinitions; 

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pages.AddToCartPage;
import pages.CheckoutPage;
import pages.CustomerInformationPage;
import pages.LoginPage;
import pages.LogoutPage;
import pages.OverviewPage;
import pages.SelectProductPage;

public class PlaceOrderStepDef {
    LoginPage loginPage;
    WebDriver driver = Hooks.driver;
    ExtentTest extTest = Hooks.extTest;
    
    @Given("user is on the login page")
    public void user_is_on_the_login_page() throws InterruptedException {
        String expResult = "https://www.saucedemo.com/";
        String actResult = driver.getCurrentUrl();
        Assert.assertEquals(actResult, expResult);
        Thread.sleep(2000);
    }

    @When("user enters username as {string} and password as {string} and click login button")
    public void user_enters_username_as_and_password_as_and_click_login_button(String userName, String password) throws InterruptedException {
        loginPage = new LoginPage(driver, extTest);
        loginPage.ValidateLogin(userName, password);
        Thread.sleep(2000);
    }

    @When("the user selects the product")
    public void the_user_selects_the_product() throws InterruptedException {
        SelectProductPage selectProductPage = new SelectProductPage(driver, extTest);
        selectProductPage.selectProduct();
        Thread.sleep(2000);
    }

    @When("the user clicks on Add to Cart button")
    public void the_user_clicks_on_add_to_cart_button() throws InterruptedException {
        AddToCartPage addToCartPage = new AddToCartPage(driver, extTest);
        addToCartPage.addProductToCart();
        Thread.sleep(2000);
    }

    @When("the user clicks on the Cart icon")
    public void the_user_clicks_on_the_cart_icon() throws InterruptedException {
        // Already covered inside AddToCartPage.addProductToCart()
        Thread.sleep(2000);
    }

    @When("the user clicks on the Checkout button")
    public void the_user_clicks_on_the_checkout_button() throws InterruptedException {
        CheckoutPage checkoutPage = new CheckoutPage(driver, extTest);
        checkoutPage.proceedToCheckout();
        Thread.sleep(2000);
    }

    @When("the user enters customer information and click continue button")
    public void the_user_enters_customer_information_and_click_continue_button() throws InterruptedException {
        CustomerInformationPage customerInfoPage = new CustomerInformationPage(driver, extTest);
        customerInfoPage.enterCustomerInfo("John", "Doe", "12345");
        Thread.sleep(2000);
    }

    @When("the user verifies the product and click Finish button")
    public void the_user_verifies_the_product_and_click_finish_button() throws InterruptedException {
        OverviewPage overviewPage = new OverviewPage(driver, extTest);
        overviewPage.finishOrder();
        Thread.sleep(2000);
    }

    @When("the user clicks the logout button")
    public void the_user_clicks_the_logout_button() throws InterruptedException {
        LogoutPage logoutPage = new LogoutPage(driver, extTest);
        logoutPage.logout();
        Thread.sleep(2000);
    }

    @Then("the user validates the login button in the login page")
    public void the_user_validates_the_login_button_in_the_login_page() throws InterruptedException {
        String expResult = "https://www.saucedemo.com/";
        String actResult = driver.getCurrentUrl();
        Assert.assertEquals(actResult, expResult, "User not redirected to login page after logout");
        extTest.pass("Login page validated successfully after logout");
        Thread.sleep(2000);
    }
}
