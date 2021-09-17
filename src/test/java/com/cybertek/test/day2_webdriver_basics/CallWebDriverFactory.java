package com.cybertek.test.day2_webdriver_basics;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class CallWebDriverFactory {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");


        driver.get("http://www.google.com");

        String title = driver.getTitle();

        System.out.println("title = " + title);


    }

}
