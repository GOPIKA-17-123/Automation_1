package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.ProductPage;
public class ProductTest extends BaseTest {
    @Test(priority = 1)
    public void verifyProductSearch(){
        ProductPage pp = new ProductPage(driver);
        pp.clickProducts();
        pp.searchProduct("Blue Top");
        Assert.assertTrue(pp.isSearchResultDisplayed());
    }
    @Test(priority = 2)
    public void verifyCategoryBrowse(){
        ProductPage pp = new ProductPage(driver);
        pp.clickProducts();
        pp.openWomenDressCategory();
        Assert.assertTrue(pp.isCategoryDisplayed());
    }
    @Test(priority = 3)
    public void verifyProductDetails(){
        ProductPage pp = new ProductPage(driver);
        pp.clickProducts();
        pp.openFirstProduct();
        String name = pp.getProductName();
        String price = pp.getProductPrice();
        Assert.assertFalse(name.isEmpty());
        Assert.assertFalse(price.isEmpty());
    }
}