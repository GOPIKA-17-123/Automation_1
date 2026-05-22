package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import base.BasePage;
public class CartPage extends BasePage {
    WebDriver driver;
    By productsBtn = By.xpath("//a[contains(text(),'Products')]");
    By firstAddToCartBtn = By.xpath("(//a[contains(text(),'Add to cart')])[1]");
    By continueShoppingBtn = By.xpath("//button[contains(text(),'Continue Shopping')]");
    By cartBtn = By.xpath("//a[contains(text(),'Cart')]");
    By cartProductName = By.xpath("//td[@class='cart_description']//a");
    By cartProductPrice = By.xpath("//td[@class='cart_price']//p");
    By deleteBtn = By.xpath("//a[@class='cart_quantity_delete']");
    By emptyCartText = By.xpath("//b[contains(text(),'Cart is empty')]");
    By cartCount = By.xpath("//a[contains(text(),'Cart')]");
    public CartPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }
    public void clickProducts(){
        waitForElement(productsBtn);
        scrollToElement(productsBtn);
        clickUsingJS(productsBtn);
    }
    public void addFirstProductToCart() {
        waitForElement(firstAddToCartBtn);
        scrollToElement(firstAddToCartBtn);
        clickUsingJS(firstAddToCartBtn);
        waitForElement(continueShoppingBtn);
        clickUsingJS(continueShoppingBtn);
    }
    public void openCart(){
        waitForElement(cartBtn);
        clickUsingJS(cartBtn);
    }
    public String getCartProductName(){
        waitForElement(cartProductName);
        return driver.findElement(cartProductName).getText();
    }
    public String getCartProductPrice(){
        waitForElement(cartProductPrice);
        return driver.findElement(cartProductPrice).getText();
    }
    public void removeProduct(){
        waitForElement(deleteBtn);
        clickUsingJS(deleteBtn);
    }
    public boolean isCartEmpty(){
        waitForElement(emptyCartText);
        return driver.findElement(emptyCartText).isDisplayed();
    }
    public String getCartCount(){
        waitForElement(cartCount);
        return driver.findElement(cartCount).getText();
    }
}