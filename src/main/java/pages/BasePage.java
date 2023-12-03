package pages;

import org.openqa.selenium.By;
import utils.ActionDriver;

public class BasePage {
    private final By loaderLocator = By.cssSelector(".ajax-loading-block-window");

    public void waitLoaderToDisappear() {
        ActionDriver.waitElementToDisappear(loaderLocator);
    }
}
