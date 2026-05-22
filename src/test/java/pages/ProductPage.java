package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import base.BasePage;
public class ProductPage extends BasePage {
    WebDriver driver;
    By productsBtn = By.xpath("//a[contains(text(),'Products')]");
    By searchBox = By.id("search_product");
    By searchBtn = By.id("submit_search");
    By searchedProductsTitle = By.xpath("//h2[contains(text(),'Searched Products')]");
    By womenCategory = By.xpath("//a[@href='#Women']");
    By dressCategory = By.xpath("//div[@id='Women']//a[contains(text(),'Dress')]");
    By categoryTitle = By.xpath("//h2[@class='title text-center']");
    By viewProductBtn = By.xpath("(//a[contains(text(),'View Product')])[1]");
    By productName = By.xpath("//div[@class='product-information']/h2");
    By productPrice = By.xpath("//div[@class='product-information']/span/span");
    public ProductPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }
    public void clickProducts(){
        waitForElement(productsBtn);
        scrollToElement(productsBtn);
        clickUsingJS(productsBtn);
    }
    public void searchProduct(String product){
        waitForElement(searchBox);
        driver.findElement(searchBox).sendKeys(product);
        scrollToElement(searchBtn);
        clickUsingJS(searchBtn);
    }
    public boolean isSearchResultDisplayed(){
        waitForElement(searchedProductsTitle);
        return driver.findElement(searchedProductsTitle)
                .isDisplayed();
    }
    public void openWomenDressCategory(){
        waitForElement(womenCategory);
        scrollToElement(womenCategory);
        clickUsingJS(womenCategory);
        waitForElement(dressCategory);
        clickUsingJS(dressCategory);
    }
    public boolean isCategoryDisplayed(){
        waitForElement(categoryTitle);
        return driver.findElement(categoryTitle).isDisplayed();
    }
    public void openFirstProduct(){
        waitForElement(viewProductBtn);
        scrollToElement(viewProductBtn);
        clickUsingJS(viewProductBtn);
    }
    public String getProductName(){
        waitForElement(productName);
        return driver.findElement(productName).getText();
    }
    public String getProductPrice(){
        waitForElement(productPrice);
        return driver.findElement(productPrice).getText();
    }
}