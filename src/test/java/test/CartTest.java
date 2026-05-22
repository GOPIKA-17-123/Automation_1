package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.CartPage;
public class CartTest extends BaseTest {
    @Test(priority = 1)
    public void verifyAddProductToCart(){
        CartPage cp = new CartPage(driver);
        cp.clickProducts();
        cp.addFirstProductToCart();
        cp.openCart();
        String productName = cp.getCartProductName();
        String productPrice = cp.getCartProductPrice();
        Assert.assertFalse(productName.isEmpty());
        Assert.assertFalse(productPrice.isEmpty());
    }
    @Test(priority = 2)
    public void verifyRemoveProductFromCart(){
        CartPage cp = new CartPage(driver);
        cp.clickProducts();
        cp.addFirstProductToCart();
        cp.openCart();
        cp.removeProduct();
        Assert.assertTrue(cp.isCartEmpty());
    }
    @Test(priority = 3)
    public void verifyCartCountUpdate(){
        CartPage cp = new CartPage(driver);
        cp.clickProducts();
        cp.addFirstProductToCart();
        String cartText = cp.getCartCount();
        Assert.assertTrue(cartText.contains("Cart"));
    }
}