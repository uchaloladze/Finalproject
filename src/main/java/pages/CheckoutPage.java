package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import utils.ActionDriver;

public class CheckoutPage {
    private final By checkoutPageTitleLocator = By.tagName("h1");
    private final By firstNameInputLocator = By.id("BillingNewAddress_FirstName");
    private final By lastNameInputLocator = By.id("BillingNewAddress_LastName");
    private final By emailLocator = By.id("BillingNewAddress_Email");
    private final By companyLocator = By.id("BillingNewAddress_Company");
    private final By countrySelectLocator = By.id("BillingNewAddress_CountryId");
    private final By stateProvinceSelectLocator = By.cssSelector(".inputs #BillingNewAddress_StateProvinceId");
    private final By cityLocator = By.id("BillingNewAddress_City");
    private final By address1Locator = By.id("BillingNewAddress_Address1");
    private final By address2Locator = By.id("BillingNewAddress_Address2");
    private final By postalCodeLocator = By.id("BillingNewAddress_ZipPostalCode");
    private final By phoneNumberLocator = By.id("BillingNewAddress_PhoneNumber");
    private final By faxNumberLocator = By.id("BillingNewAddress_FaxNumber");
    private final By billingAddressContinueButtonLocator = By.cssSelector("#billing-buttons-container .new-address-next-step-button");
    private final By shippingContinueButtonLocator = By.cssSelector(".buttons .shipping-method-next-step-button");
    private final By paymentContinueButtonLocator = By.cssSelector(".buttons .payment-method-next-step-button");
    private final By paymentInfoContinueButtonLocator = By.cssSelector(".buttons .payment-info-next-step-button");
    private final By confirmButtonLocator = By.cssSelector("div[id='confirm-order-buttons-container'] button");

    public String getCheckoutPageTitle() {
        return ActionDriver.getText(checkoutPageTitleLocator);
    }

    public void setFirstName(String firstName) {
        ActionDriver.getElement(firstNameInputLocator).shouldBe(Condition.editable);
        ActionDriver.setValue(firstNameInputLocator, firstName);
    }

    public void setLastName(String lastName) {
        ActionDriver.setValue(lastNameInputLocator, lastName);
    }

    public void setEmail(String email) {
        ActionDriver.setValue(emailLocator, email);
    }

    public void setCompany(String company) {
        ActionDriver.setValue(companyLocator, company);
    }

    public void setCountry(String country) {
        ActionDriver.getElement(countrySelectLocator).selectOption(country);
    }

    public void setStateProvince(String stateProvince) {
        ActionDriver.getElement(stateProvinceSelectLocator).selectOption(stateProvince);
    }

    public void setCity(String city) {
        ActionDriver.setValue(cityLocator, city);
    }

    public void setAddress1(String address1) {
        ActionDriver.setValue(address1Locator, address1);
    }

    public void setAddress2(String address2) {
        ActionDriver.setValue(address2Locator, address2);
    }

    public void setPostalCode(String postalCode) {
        ActionDriver.setValue(postalCodeLocator, postalCode);
    }

    public void setPhoneNumber(String phoneNumber) {
        ActionDriver.setValue(phoneNumberLocator, phoneNumber);
    }

    public void setFaxNumber(String faxNumber) {
        ActionDriver.setValue(faxNumberLocator, faxNumber);
    }

    public void clickBillingAddressContinueButton() {
        ActionDriver.click(billingAddressContinueButtonLocator);
    }

    public void clickShippingContinueButton() {
        ActionDriver.getElement(shippingContinueButtonLocator).shouldBe(Condition.interactable);
        ActionDriver.click(shippingContinueButtonLocator);
    }

    public void selectShippingMethodByValue(String value) {
        ActionDriver.click(By.xpath("//label[contains(text(), '" + value + "')]/preceding-sibling::input"));
    }

    public void clickPaymentContinueButton() {
        ActionDriver.getElement(paymentContinueButtonLocator).shouldBe(Condition.interactable);
        ActionDriver.click(paymentContinueButtonLocator);
    }

    public void selectPaymentMethodByValue(String value) {
        ActionDriver.click(By.xpath("//label[contains(text(), '" + value + "')]/preceding-sibling::input"));
    }

    public void clickPaymentInfoContinueButton() {
        ActionDriver.click(paymentInfoContinueButtonLocator);
    }

    public void clickConfirmButton() {
        ActionDriver.click(confirmButtonLocator);
        ActionDriver.waitElementToDisappear(confirmButtonLocator);
    }
}
