package objectrepository;

import org.openqa.selenium.By;

public class Locators {

    // Login Page
    public static By userName = By.id("user-name");
    public static By password = By.id("password");
    public static By loginButton = By.id("login-button");

    // Product Page
    public static By product = By.xpath("//div[@class='inventory_item_name ']"); 
    public static By backToProducts = By.id("back-to-products");

    //  Add To Cart Page
    public static By addToCartButton = By.id("add-to-cart");
    public static By cartIcon = By.className("shopping_cart_link");

    //  Checkout Page
    public static By checkoutButton = By.id("checkout");

    // Customer Information Page
    public static By firstName = By.id("first-name");
    public static By lastName = By.id("last-name");
    public static By postalCode = By.id("postal-code");
    public static By continueButton = By.id("continue");

    // Overview Page
    public static By finishButton = By.id("finish");
    public static By orderSuccessMsg = By.xpath("//h2[text()='Thank you for your order!']");

    //  Logout Page
    public static By menuButton = By.id("react-burger-menu-btn");
    public static By logoutLink = By.id("logout_sidebar_link");
}