package pages;

import org.openqa.selenium.By;
import utils.ActionDriver;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;

public class ProductDetailsPage {
    private final By productNameLocator = By.tagName("h1");
    private final By addToCartButtonLocator = By.cssSelector(".add-to-cart-panel button");
    private final By errorTextsLocator = By.cssSelector(".bar-notification.error > p");
    private final By messageBarLocator = By.cssSelector(".bar-notification.error");
    private final By closeButtonLocator = By.cssSelector("[title='Close']");
    private final By sizeDropDownLocator = By.cssSelector("#product_attribute_input_6 > select");
    private final By colorDropDownLocator = By.cssSelector("#product_attribute_input_7 > select");
    private final By printOptionsLocator = By.cssSelector(".attribute-square-container > span");
    private final By successBarLocator = By.cssSelector(".bar-notification.success");
    private final By successMessageLocator = By.cssSelector(".bar-notification.success > p");
    private final By cartCountLocator = By.cssSelector(".ico-cart .cart-qty");
    private final By shoppingCartLocator = By.className("ico-cart");
    private final By amountLocator = By.cssSelector(".add-to-cart-panel #product_enteredQuantity_20");
    private final By productUnitPriceLocator = By.id("price-value-20");

    public String getProductName() {
        return ActionDriver.getText(productNameLocator);
    }

    public void clickAddToCartButton() {
        $(addToCartButtonLocator).click();
    }

    public List<String> getErrorTexts() {
        return ActionDriver.getTextsList(errorTextsLocator);
    }

    public String getErrorBarColor() {
        return ActionDriver.getCssValue(messageBarLocator, "background-color");
    }

    public void clickCloseButton() {
        ActionDriver.click(closeButtonLocator);
    }

    public void waitForMessageBarToDisappear() {
        ActionDriver.waitElementToDisappear(messageBarLocator);
    }

    public void selectSizeDropDownOptionByIndex(int index) {
        ActionDriver.getElement(sizeDropDownLocator).selectOption(index);
    }

    public void selectColorDropDownByIndex(int index) {
        ActionDriver.getElement(colorDropDownLocator).selectOption(index);
    }

    public void clickPrintByIndex(int index) {
        ActionDriver.clickElementByIndex(printOptionsLocator, index);
    }

    public String getAddShoppingCardSuccessMessage() {
        return ActionDriver.getText(successMessageLocator);
    }

    public String getSuccessBarColor() {
        return ActionDriver.getCssValue(successBarLocator, "background-color");
    }

    public int getAddedItemsCountFromCart() {
        return Integer.parseInt(ActionDriver.getText(cartCountLocator).replaceAll("[()]", ""));
    }

    public void clickShoppingCart() {
        ActionDriver.click(shoppingCartLocator);
    }

    public void setAmount(int amount) {
        ActionDriver.getElement(amountLocator).setValue(String.valueOf(amount));
    }

    public double getProductUnitPrice() {
        return Double.parseDouble(ActionDriver.getText(productUnitPriceLocator).replace("$", ""));
    }
}
