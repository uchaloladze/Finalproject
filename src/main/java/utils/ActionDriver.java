package utils;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.List;
import java.util.Objects;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ActionDriver {
    public static void hoverOverElementByValue(By optionsLocator, String value) {
        ElementsCollection options = getElements(optionsLocator);
        boolean found = false;

        for (SelenideElement selenideElement : options) {
            if (getText(selenideElement).equals(value)) {
                found = true;
                hoverOverElement(selenideElement);
                break;
            }
        }

        if (!found) {
            throw new RuntimeException("There is no option with value: " + value);
        }
    }

    public static void clickElementByValue(By optionsLocator, String value) {
        ElementsCollection options = getElements(optionsLocator);
        boolean found = false;

        for (SelenideElement selenideElement : options) {
            if (getText(selenideElement).equals(value)) {
                found = true;
                click(selenideElement);
                break;
            }
        }

        if (!found) {
            throw new RuntimeException("There is no option with value: " + value);
        }
    }

    public static SelenideElement getElement(By locator) {
        return $(locator);
    }

    public static ElementsCollection getElements(By locator) {
        return $$(locator);
    }

    public static String getText(By locator) {
        return getElement(locator).getText().trim();
    }

    public static String getText(SelenideElement element) {
        return element.getText().trim();
    }

    public static List<String> getTextsList(By locator) {
        return getElements(locator).texts();
    }

    public static String getCssValue(By locator, String propertyName) {
        return getElement(locator).getCssValue(propertyName);
    }

    public static void click(By locator) {
        getElement(locator).click();
    }

    public static void click(SelenideElement element) {
        element.click();
    }

    public static void hoverOverElement(SelenideElement element) {
        element.hover();
    }

    public static void waitElementToDisappear(By locator) {
        getElement(locator).should(Condition.disappear);
    }

    public static void clickElementByIndex(By optionsLocator, int index) {
        click(getElements(optionsLocator).get(index - 1));
    }

    public static boolean isElementNotPresent(By locator) {
        return $(locator).should(exist).exists();
    }

    public static boolean compareDoubleLists(List<Double> list1, List<Double> list2) {
        // Check if both lists are null or have different sizes
        if (list1 == null || list2 == null || list1.size() != list2.size()) {
            return false;
        }

        // Iterate through the elements and compare
        for (int i = 0; i < list1.size(); i++) {
            if (!list1.get(i).equals(list2.get(i))) {
                return false;
            }
        }

        return true;
    }

    public static <T> boolean compareLists(List<T> list1, List<T> list2) {
        // Check if both lists are null or have different sizes
        if (!Objects.equals(list1, list2) || (list1 != null && list1.size() != list2.size())) {
            return false;
        }

        // Iterate through the elements and compare
        for (int i = 0; i < list1.size(); i++) {
            if (!Objects.equals(list1.get(i), list2.get(i))) {
                return false;
            }
        }

        return true;
    }

    public static void setValue(By locator, String value) {
        getElement(locator).setValue(value);
    }
}
