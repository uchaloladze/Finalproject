package tests.negativescenarios;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ItemsPage;
import pages.MainPage;
import pages.ProductDetailsPage;
import tests.BaseTest;

import java.util.List;

public class ApparelNegativeTests extends BaseTest {
    @Test(priority = 1, testName = "ვაჭერთ კალათაში დამატებას ზომის, ფერის და პრინტის არჩევის გარეშე")
    public void clickAddToCartButtonWithoutSelectingDropDowns() {
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
        productDetailsPage.clickAddToCartButton();

        waitLoaderToDisappear();

        List<String> errorTexts = productDetailsPage.getErrorTexts();
        //verifying error texts
        Assert.assertEquals(errorTexts.get(0), "Please select Size");
        Assert.assertEquals(errorTexts.get(1), "Please select Color");
        Assert.assertEquals(errorTexts.get(2), "Please select Print");

        //verify opened error bar background color
        Assert.assertEquals(productDetailsPage.getErrorBarColor(), "rgba(228, 68, 76, 1)");

        //click close error button
        productDetailsPage.clickCloseButton();

        //after clicking close button verify there is no message bar
        productDetailsPage.waitForMessageBarToDisappear();
    }

    @Test(priority = 2, testName = "ვაჭერთ კალათაში დამატებას ფერის და პრინტის არჩევის გარეშე")
    public void clickAddToCartButtonWithoutSelectingColorAndPrint() {
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

        //select size
        productDetailsPage.selectSizeDropDownOptionByIndex(2);

        productDetailsPage.clickAddToCartButton();

        waitLoaderToDisappear();

        List<String> errorTexts = productDetailsPage.getErrorTexts();
        //verifying error texts
        Assert.assertEquals(errorTexts.get(0), "Please select Color");
        Assert.assertEquals(errorTexts.get(1), "Please select Print");

        //verify opened error bar background color
        Assert.assertEquals(productDetailsPage.getErrorBarColor(), "rgba(228, 68, 76, 1)");

        //click close error button
        productDetailsPage.clickCloseButton();

        //after clicking close button verify there is no message bar
        productDetailsPage.waitForMessageBarToDisappear();
    }

    @Test(priority = 3, testName = "ვაჭერთ კალათაში დამატებას პრინტის არჩევის გარეშე")
    public void clickAddToCartButtonWithoutSelectingPrint() {
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

        //select size
        productDetailsPage.selectSizeDropDownOptionByIndex(2);
        //select color
        productDetailsPage.selectColorDropDownByIndex(2);

        productDetailsPage.clickAddToCartButton();

        waitLoaderToDisappear();

        List<String> errorTexts = productDetailsPage.getErrorTexts();
        //verifying error texts
        Assert.assertEquals(errorTexts.get(0), "Please select Print");

        //verify opened error bar background color
        Assert.assertEquals(productDetailsPage.getErrorBarColor(), "rgba(228, 68, 76, 1)");

        //click close error button
        productDetailsPage.clickCloseButton();

        //after clicking close button verify there is no message bar
        productDetailsPage.waitForMessageBarToDisappear();
    }
}
