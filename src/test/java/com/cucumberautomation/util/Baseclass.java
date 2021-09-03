package com.cucumberautomation.util;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Baseclass {
    protected static WebDriver driver;

    private static final int DEFAULT_TIMEOUT = 20;

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
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(DEFAULT_TIMEOUT));
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

}
