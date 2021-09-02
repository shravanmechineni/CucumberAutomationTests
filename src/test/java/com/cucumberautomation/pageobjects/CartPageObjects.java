package com.cucumberautomation.pageobjects;

import com.cucumberautomation.util.Baseclass;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CartPageObjects extends Baseclass {

    private static final By DRESSES_MENU_LINK = By.xpath("//div[@id=\"block_top_menu\"]/ul/li[2]/a");
    private static final By DRESSES_SUB_MENU = By.xpath("//div[@id=\"block_top_menu\"]/ul/li[2]/ul/li");
    private static final By PRODUCTS = By.xpath("//div[@id=\"center_column\"]/ul/li");
    private static final By CART = By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a");
    private static final By CART_TOTAL = By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a/span[4]");
    private String subMenuDressLinks = "//div[@id=\"block_top_menu\"]/ul/li[2]/ul/li[%s]/a";
    private String productsList = "//div[@id=\"center_column\"]/ul/li[%s]";
    private String productsPrice = "//div[@id=\"center_column\"]/ul/li[%s]/div/div[1]/div/div[2]/span[1]";
    private String addToCart = "//*[@id=\"center_column\"]/ul/li[%s]/div/div[2]/div[2]/a[1]/span";
    private String productName = "//*[@id=\"center_column\"]/ul/li[%s]/div/div[2]/h5/a";
    private String dressName;
    private String highestPrice;

    public void addExpensiveDressToTheCart() {
        List<Double> productPrices = new ArrayList<>();

        WebElement dressesMenu = driver.findElement(DRESSES_MENU_LINK);
        new Actions(driver).moveToElement(dressesMenu).perform();
        List<WebElement> links = driver.findElements(DRESSES_SUB_MENU);

        for (int i = 1; i <= links.size(); i++) {
            String subMenu = driver.findElement(By.xpath(String.format(subMenuDressLinks, i))).getText();

            click(By.xpath(String.format(subMenuDressLinks, i)));

            List<WebElement> products = driver.findElements(PRODUCTS);
            System.out.println(String.format("No. of products in %s are %s", subMenu, products.size()));

            for (int j = 1; j <= products.size(); j++) {
                new Actions(driver).moveToElement(driver.findElement(By.xpath(String.format(productsList, j)))).perform();
                String price = driver.findElement(By.xpath(String.format(productsPrice, j))).getText();
                String priceValue = price.substring(1);
                productPrices.add(Double.valueOf(priceValue));
            }

            WebElement dressesMainMenu = driver.findElement(DRESSES_MENU_LINK);
            new Actions(driver).moveToElement(dressesMainMenu).perform();
        }
        highestPrice = Collections.max(productPrices).toString();


        WebElement dressesMenu2 = driver.findElement(DRESSES_MENU_LINK);
        new Actions(driver).moveToElement(dressesMenu2).perform();
        List<WebElement> links2 = driver.findElements(DRESSES_SUB_MENU);

        for (int i = 1; i <= links2.size(); i++) {
            click(By.xpath(String.format(subMenuDressLinks, i)));
            List<WebElement> products = driver.findElements(PRODUCTS);

            for (int j = 1; j <= products.size(); j++) {
                new Actions(driver).moveToElement(driver.findElement(By.xpath(String.format(productsList, j)))).perform();
                String price = driver.findElement(By.xpath(String.format(productsPrice, j))).getText();
                String priceValue = price.substring(1);

                if (priceValue.equals(highestPrice)) {
                    dressName = driver.findElement(By.xpath(String.format(productName, j))).getText();
                    driver.findElement(By.xpath(String.format(addToCart, j))).click();
                    break;
                }
            }
            if (dressName != null) {
                break;
            }
            WebElement dressesMainMenu = driver.findElement(DRESSES_MENU_LINK);
            new Actions(driver).moveToElement(dressesMainMenu).perform();
        }
    }

    public void verifyCart() {
        WebElement cart = driver.findElement(CART);
        new Actions(driver).moveToElement(cart).perform();
        String cartTotal = getText(CART_TOTAL);
        Assert.assertEquals(highestPrice, cartTotal);
    }

}
