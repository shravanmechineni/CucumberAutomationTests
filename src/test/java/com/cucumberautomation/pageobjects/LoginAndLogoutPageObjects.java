package com.cucumberautomation.pageobjects;

import com.cucumberautomation.util.Baseclass;
import org.junit.Assert;
import org.openqa.selenium.By;

public class LoginAndLogoutPageObjects extends Baseclass {


    private static final By SIGNIN_LINK = By.partialLinkText("Sign in");
    private static final By EMAIL_TXT = By.id("email");
    private static final By PASSWORD_TXT = By.id("passwd");
    private static final By SIGNIN_BTN = By.id("SubmitLogin");
    private static final By SIGNOUT_LINK = By.partialLinkText("Sign out");

    public void login(String email, String password) {
        click(SIGNIN_LINK);
        sendKeys(EMAIL_TXT, email);
        sendKeys(PASSWORD_TXT, password);
        click(SIGNIN_BTN);
        Assert.assertTrue(isElementPresent(SIGNOUT_LINK));
    }

    public void logout() {
        click(SIGNOUT_LINK);
        Assert.assertTrue(isElementPresent(SIGNIN_LINK));
    }

}
