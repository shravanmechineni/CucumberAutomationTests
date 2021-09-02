package com.cucumberautomation.util;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class Baseclass {
    protected static WebDriver driver;

    private static final int DEFAULT_TIMEOUT = 10;

    public void openBrowser(String browserType) {
        switch (browserType) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
                driver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver");
                driver = new FirefoxDriver();
                break;
            default:
                throw new IllegalArgumentException("Unknown Browser Driver " + browserType);
        }
        driver.manage().timeouts().implicitlyWait(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
    }

    public void navigate(String url) {
        driver.navigate().to(url);
    }

    protected void sendKeys(By Element, String value) {
        try {
            driver.findElement(Element).clear();
            driver.findElement(Element).sendKeys(value);
        } catch (NoSuchElementException err) {
            err.printStackTrace();
        }
    }

    protected void click(By element) {
        try {
            driver.findElement(element).click();
        } catch (NoSuchElementException err) {
            err.printStackTrace();
        }
    }

    protected String getText(By element) {
        String text = null;
        try {
            text = driver.findElement(element).getText();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return text;
    }

    protected boolean isElementPresent(By element) {
        int count = driver.findElements(element).size();
        return count != 0;
    }

    public void closeBrowser() {
        driver.quit();
    }

    protected void selectValueFromDropDown(By element, String value) {
        Select select = new Select(driver.findElement(element));
        select.selectByValue(value);
    }

    protected void selectTextFromDropDown(By element, String text) {
        Select select = new Select(driver.findElement(element));
        select.selectByVisibleText(text);
    }

    protected void selectIndexFromDropDown(By element, int index) {
        Select select = new Select(driver.findElement(element));
        select.selectByIndex(index);
    }

    public void menuHover(By mainMenuElement, By subMenuElement) {
        WebElement mainMenu = driver.findElement(mainMenuElement);
        Actions actions = new Actions(driver);
        WebElement subMenu = driver.findElement(subMenuElement);
        actions.moveToElement(subMenu);
        actions.click().build().perform();
    }

    public static String generateEmail(int length) {
        String allowedChars = "abcdefghijklmnopqrstuvwxyz" +
                "1234567890";

        String random = RandomStringUtils.random(length, allowedChars);
        return random + "@test.com";
    }


}
