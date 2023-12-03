package pages;

import org.openqa.selenium.By;
import utils.ActionDriver;

import java.util.List;
import java.util.stream.Collectors;

public class ItemsPage {
    private final By headerLocator = By.tagName("h1");
    private final By itemsLocator = By.cssSelector(".product-title a");
    private final By productsSelectLocator = By.id("products-orderby");
    private final By pricesLocator = By.cssSelector(".price.actual-price");

    public String getHeader() {
        return ActionDriver.getText(headerLocator);
    }

    public void clickItemByValue(String value) {
        ActionDriver.clickElementByValue(itemsLocator, value);
    }

    public void setFilterByValue(String value) {
        ActionDriver.getElement(productsSelectLocator).selectOption(value);
    }

    public List<Double> getProductPrices() {
        return ActionDriver.getTextsList(pricesLocator)
                .stream()
                .map(s -> Double.parseDouble(s.trim().replaceAll("\\$", "")))
                .collect(Collectors.toList());
    }
}
