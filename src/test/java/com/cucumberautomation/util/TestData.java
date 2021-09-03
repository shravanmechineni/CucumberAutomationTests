package com.cucumberautomation.util;

import org.apache.commons.lang3.RandomStringUtils;

public class TestData {

    public static String website = "http://automationpractice.com/index.php";
    public static String email = "testemail6@test.com";
    public static String password = "Password123";

    public static String generateEmail(int length) {
        String allowedChars = "abcdefghijklmnopqrstuvwxyz" +
                "1234567890";

        String random = RandomStringUtils.random(length, allowedChars);
        return random + "@test.com";
    }

}
