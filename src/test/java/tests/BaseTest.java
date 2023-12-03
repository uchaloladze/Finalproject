package tests;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import utils.ActionDriver;
import utils.ConfigProperties;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class BaseTest {
    @BeforeMethod
    public void setup() {
        open(ConfigProperties.getProperty("url"));

        // Maximize the browser window
        getWebDriver().manage().window().maximize();
    }

    private final By loaderLocator = By.cssSelector(".ajax-loading-block-window");
    private final By productsLoaderLocator = By.className("ajax-products-busy");

    public void waitLoaderToDisappear() {
        ActionDriver.getElement(loaderLocator).shouldHave(attribute("style", "display: none;"));
    }

    public void waitProductsLoaderToDisappear() {
        ActionDriver.getElement(productsLoaderLocator).shouldHave(attribute("style", "display: block;"));
        ActionDriver.getElement(productsLoaderLocator).shouldHave(attribute("style", "display: none;"));
    }
}
