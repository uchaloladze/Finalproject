package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import utils.ActionDriver;

import static com.codeborne.selenide.Condition.enabled;

public class ShoppingCartPage {
    private final By shoppingCartPageTitleLocator = By.tagName("h1");
    private final By removeButtonLocator = By.name("updatecart");
    private final By shoppingCartTableLocator = By.className("table-wrapper");
    private final By dynamicTableTotalAmountLocator = By.className("product-subtotal");
    private final By checkoutFormTotalAmountLocator = By.cssSelector("tr.order-subtotal span");
    private final By giftWrappingSelectLocator = By.cssSelector(".checkout-attributes select");
    private final By checkoutUpdateElementLocator = By.cssSelector(".cart-options .selected-checkout-attributes");
    private final By checkoutButtonLocator = By.id("checkout");
    private final By termsOfServiceLocator = By.cssSelector(".ui-corner-all #terms-of-service-warning-box");
    private final By termsPopupCloseButtonLocator = By.cssSelector(".ui-button.ui-corner-all");
    private final By termsCheckboxLocator = By.cssSelector(".terms-of-service input");

    public String getShoppingCartPageTitle() {
        return ActionDriver.getText(shoppingCartPageTitleLocator);
    }

    public void clickRemoveButton() {
        ActionDriver.click(removeButtonLocator);
    }

    public void waitForItemTableToDisappear() {
        ActionDriver.waitElementToDisappear(shoppingCartTableLocator);
    }

    public double getDynamicTableTotalAmount() {
        return Double.parseDouble(ActionDriver.getText(dynamicTableTotalAmountLocator).replace("$", ""));
    }

    public double getCheckoutFormTotalAmount() {
        return Double.parseDouble(ActionDriver.getText(checkoutFormTotalAmountLocator).replace("$", ""));
    }

    public SelenideElement setGiftWrappingByIndex(int index) {
        SelenideElement selenideElement = ActionDriver.getElement(giftWrappingSelectLocator);
        selenideElement.selectOption(index);
        return selenideElement;
    }

    public double getGiftWrappingPrice(SelenideElement element) {
        return Double.parseDouble(ActionDriver.getText(element).replaceAll("[^0-9.]+", ""));
    }

    public void waitCheckoutFormToUpdate() {
        ActionDriver.getElement(checkoutUpdateElementLocator).shouldNot(Condition.text(" Gift wrapping: No "));
    }

    public void clickCheckoutButton() {
        ActionDriver.click(checkoutButtonLocator);
    }

    public String getTermsOfServicePopupText() {
        return ActionDriver.getText(termsOfServiceLocator);
    }

    public void closeTermsPopup() {
        ActionDriver.click(termsPopupCloseButtonLocator);
    }

    public void enableTermsCheckbox() {
        ActionDriver.getElement(termsCheckboxLocator).shouldBe(enabled).click();
    }
}
