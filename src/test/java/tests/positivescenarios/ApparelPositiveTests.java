package tests.positivescenarios;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ItemsPage;
import pages.MainPage;
import pages.ProductDetailsPage;
import pages.ShoppingCartPage;
import tests.BaseTest;

import java.util.Collections;
import java.util.List;

public class ApparelPositiveTests extends BaseTest {
    @Test(priority = 1, testName = "კალათიდან დამატებული პროდუქტის წაშლა")
    public void removeItemFromCart() {
        MainPage mainPage = new MainPage();
        Assert.assertEquals(mainPage.getMainPageWelcomeText(), "Welcome to our store");
        mainPage.selectItemByValue("Apparel", "Shoes");

        ItemsPage itemsPage = new ItemsPage();
        //verify opened page using passed item name
        Assert.assertEquals(itemsPage.getHeader(), "Shoes");
        itemsPage.clickItemByValue("Nike Floral Roshe Customized Running Shoes");

        ProductDetailsPage productDetailsPage = new ProductDetailsPage();
        //verify selected product name page
        Assert.assertEquals(productDetailsPage.getProductName(), "Nike Floral Roshe Customized Running Shoes");

        waitLoaderToDisappear();

        //select size
        productDetailsPage.selectSizeDropDownOptionByIndex(2);
        //select color
        productDetailsPage.selectColorDropDownByIndex(2);
        //select print
        productDetailsPage.clickPrintByIndex(1);

        productDetailsPage.clickAddToCartButton();

        //verifying success message
        Assert.assertEquals(productDetailsPage.getAddShoppingCardSuccessMessage(), "The product has been added to your shopping cart");

        //verify opened success bar background color
        Assert.assertEquals(productDetailsPage.getSuccessBarColor(), "rgba(75, 176, 122, 1)");

        //click close error button
        productDetailsPage.clickCloseButton();

        //after clicking close button verify there is no message bar
        productDetailsPage.waitForMessageBarToDisappear();

        //after clicking add to cart button verify items count in cart
        Assert.assertEquals(productDetailsPage.getAddedItemsCountFromCart(), 1);

        //click shopping cart container
        productDetailsPage.clickShoppingCart();

        ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
        Assert.assertEquals(shoppingCartPage.getShoppingCartPageTitle(), "Shopping cart");
        shoppingCartPage.clickRemoveButton();

        //verify after clicking remove button item table will disappear
        shoppingCartPage.waitForItemTableToDisappear();
    }

    @Test(priority = 2, testName = "პროდუქტების ფასის ზრდადობით გაფილტვრა")
    public void filterPriceLowToHigh() {
        MainPage mainPage = new MainPage();
        Assert.assertEquals(mainPage.getMainPageWelcomeText(), "Welcome to our store");
        mainPage.selectItemByValue("Apparel", "Shoes");

        ItemsPage itemsPage = new ItemsPage();
        //verify opened page using passed item name
        Assert.assertEquals(itemsPage.getHeader(), "Shoes");

        List<Double> prices = itemsPage.getProductPrices();
        //sort prices by ascending order
        Collections.sort(prices);

        itemsPage.setFilterByValue("Price: Low to High");

        waitProductsLoaderToDisappear();

        List<Double> pricesAfterFilteringFromLowToHigh = itemsPage.getProductPrices();

        //verify products order after filtering by prices low to high
        Assert.assertEquals(prices, pricesAfterFilteringFromLowToHigh);
    }
}

