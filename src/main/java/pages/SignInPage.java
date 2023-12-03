package pages;

import org.openqa.selenium.By;
import utils.ActionDriver;

public class SignInPage {
    private final By checkoutPageTitleLocator = By.tagName("h1");
    private final By checkoutAsGuestButtonLocator = By.cssSelector(".button-1.checkout-as-guest-button");

    public String getCheckoutPageTitle() {
        return ActionDriver.getText(checkoutPageTitleLocator);
    }

    public void clickCheckoutAsGuestButton() {
        ActionDriver.click(checkoutAsGuestButtonLocator);
    }
}
