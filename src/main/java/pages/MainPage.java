package pages;

import org.openqa.selenium.By;
import utils.ActionDriver;

public class MainPage {
    private final By welcomeTextLocator = By.cssSelector(".topic-block-title h2");
    private final By navigationBarOptionsLocator = By.cssSelector(".header-menu ul.top-menu.notmobile > li > a");
    private final By navigationBarSubOptionsLocator = By.cssSelector("ul.top-menu.notmobile .sublist.first-level a");
    private final By mainPageTitleLocator = By.tagName("h1");
    private final By orderCompletedElementLocator = By.cssSelector(".order-completed .title strong");

    public String getMainPageWelcomeText() {
        return ActionDriver.getText(welcomeTextLocator);
    }

    public String getMainPagePrimaryTitle() {
        return ActionDriver.getText(mainPageTitleLocator);
    }

    public void hoverOverNavigationBarOptionByValue(String value) {
        ActionDriver.hoverOverElementByValue(navigationBarOptionsLocator, value);
    }

    public void clickNavigationBarSubOptionByValue(String value) {
        ActionDriver.clickElementByValue(navigationBarSubOptionsLocator, value);
    }

    public void selectItemByValue(String navigationBarOptionValue, String navigationBarSubOptionValue) {
        hoverOverNavigationBarOptionByValue(navigationBarOptionValue);
        clickNavigationBarSubOptionByValue(navigationBarSubOptionValue);
    }

    public String getOrderCompletedMessage() {
        return ActionDriver.getText(orderCompletedElementLocator);
    }
}
