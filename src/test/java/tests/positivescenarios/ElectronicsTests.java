package tests.positivescenarios;

import com.codeborne.selenide.SelenideElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import tests.BaseTest;

public class ElectronicsTests extends BaseTest {
    @Test(priority = 1, testName = "პროდუქტის ყიდვა")
    public void buyProduct() {
        MainPage mainPage = new MainPage();
        Assert.assertEquals(mainPage.getMainPageWelcomeText(), "Welcome to our store");
        mainPage.selectItemByValue("Electronics", "Cell phones");

        ItemsPage itemsPage = new ItemsPage();
        //verify opened page using passed item name
        Assert.assertEquals(itemsPage.getHeader(), "Cell phones");
        itemsPage.clickItemByValue("Nokia Lumia 1020");

        ProductDetailsPage productDetailsPage = new ProductDetailsPage();
        //verify selected product name page
        Assert.assertEquals(productDetailsPage.getProductName(), "Nokia Lumia 1020");
        double unitPrice = productDetailsPage.getProductUnitPrice();

        int productsCount = 2;
        productDetailsPage.setAmount(productsCount);

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
        Assert.assertEquals(productDetailsPage.getAddedItemsCountFromCart(), productsCount);

        //click shopping cart container
        productDetailsPage.clickShoppingCart();

        ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
        Assert.assertEquals(shoppingCartPage.getShoppingCartPageTitle(), "Shopping cart");

        double expectedTotalAmount = unitPrice * productsCount;

        //verify total amount in shopping cart dynamic table and in checkout form
        Assert.assertEquals(expectedTotalAmount, shoppingCartPage.getDynamicTableTotalAmount());
        Assert.assertEquals(expectedTotalAmount, shoppingCartPage.getCheckoutFormTotalAmount());

        //set Gift Wrapping
        waitLoaderToDisappear();
        SelenideElement selectedElement = shoppingCartPage.setGiftWrappingByIndex(1);

        double giftWrappingPrice = shoppingCartPage.getGiftWrappingPrice(selectedElement);

        //verify new checkout total amount after selecting gift wrapper
        shoppingCartPage.waitCheckoutFormToUpdate();
        Assert.assertEquals(shoppingCartPage.getCheckoutFormTotalAmount(), expectedTotalAmount + giftWrappingPrice);

        shoppingCartPage.clickCheckoutButton();

        //verify terms of service popup
        Assert.assertEquals(shoppingCartPage.getTermsOfServicePopupText(), "Please accept the terms of service before the next step.");
        shoppingCartPage.closeTermsPopup();
        shoppingCartPage.enableTermsCheckbox();
        shoppingCartPage.clickCheckoutButton();

        SignInPage signInPage = new SignInPage();
        Assert.assertEquals(signInPage.getCheckoutPageTitle(), "Welcome, Please Sign In!");
        signInPage.clickCheckoutAsGuestButton();

        CheckoutPage checkoutPage = new CheckoutPage();
        Assert.assertEquals(checkoutPage.getCheckoutPageTitle(), "Checkout");

        checkoutPage.setFirstName("John");
        checkoutPage.setLastName("Doe");
        checkoutPage.setEmail("johndoe@gmail.com");
        checkoutPage.setCompany("IBM");
        checkoutPage.setCountry("United States");
        checkoutPage.setStateProvince("Alabama");
        checkoutPage.setCity("Huntsville");
        checkoutPage.setAddress1("Alabama Huntsville 1");
        checkoutPage.setAddress2("Alabama Huntsville 2");
        checkoutPage.setPostalCode("0100");
        checkoutPage.setPhoneNumber("+993245345");
        checkoutPage.setFaxNumber("+12131-40-042424");
        checkoutPage.clickBillingAddressContinueButton();
        checkoutPage.selectShippingMethodByValue("Next Day Air");
        checkoutPage.clickShippingContinueButton();
        checkoutPage.selectPaymentMethodByValue("Money Order");
        checkoutPage.clickPaymentContinueButton();
        checkoutPage.clickPaymentInfoContinueButton();
        checkoutPage.clickConfirmButton();

        //verify success messages
        Assert.assertEquals(mainPage.getMainPagePrimaryTitle(), "Thank you");
        Assert.assertEquals(mainPage.getOrderCompletedMessage(), "Your order has been successfully processed!");
    }
}
