package com.cucumberautomation.pageobjects;

import com.cucumberautomation.util.Baseclass;
import org.openqa.selenium.By;

public class CreateAccountPageObjects extends Baseclass {

    private static final By SIGNIN_LINK = By.partialLinkText("Sign in");
    private static final By EMAIL_CREATE_TXT = By.id("email_create");
    private static final By CREATE_BTN = By.id("SubmitCreate");
    private static final By TITLE_RADIO_BUTTON = By.xpath("//input[@id=\"id_gender1\"][@value=\"1\"]");
    private static final By FIRST_NAME_TXT = By.id("customer_firstname");
    private static final By LAST_NAME_TXT = By.id("customer_lastname");
    private static final By PASSWORD_TXT = By.id("passwd");
    private static final By DATE_DROPDOWN = By.id("days");
    private static final By MONTH_DROPDOWN = By.id("months");
    private static final By YEAR_DROPDOWN = By.id("years");
    private static final By ADDRESS_FIRST_NAME_TXT = By.id("firstname");
    private static final By ADDRESS_LAST_NAME_TXT = By.id("lastname");
    private static final By ADDRESS_COMPANY_TXT = By.id("company");
    private static final By ADDRESS1_TXT = By.id("address1");
    private static final By CITY_TXT = By.id("city");
    private static final By STATE_DROPDOWN = By.id("id_state");
    private static final By POSTCODE_TXT = By.id("postcode");
    private static final By PHONE_MOBILE_TXT = By.id("phone_mobile");
    private static final By SUBMIT_ACCOUNT_BTN = By.id("submitAccount");

    public void createAccount(String email, String firstname, String lastname, String password, String date, String month, String year) {
        click(SIGNIN_LINK);
        sendKeys(EMAIL_CREATE_TXT, email);
        click(CREATE_BTN);
        click(TITLE_RADIO_BUTTON);
        sendKeys(FIRST_NAME_TXT, firstname);
        sendKeys(LAST_NAME_TXT, lastname);
        sendKeys(PASSWORD_TXT, password);
        selectValueFromDropDown(DATE_DROPDOWN, date);
        selectValueFromDropDown(MONTH_DROPDOWN, month);
        selectValueFromDropDown(YEAR_DROPDOWN, year);
        sendKeys(ADDRESS_FIRST_NAME_TXT, firstname);
        sendKeys(ADDRESS_LAST_NAME_TXT, lastname);
        sendKeys(ADDRESS_COMPANY_TXT, "Test company");
        sendKeys(ADDRESS1_TXT, "address 1");
        sendKeys(CITY_TXT, "city");
        selectValueFromDropDown(STATE_DROPDOWN, "10");
        sendKeys(POSTCODE_TXT, "12345");
        sendKeys(PHONE_MOBILE_TXT, "+1232424242522");
        click(SUBMIT_ACCOUNT_BTN);
    }
}
