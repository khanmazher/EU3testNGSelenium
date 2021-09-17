package com.cybertek.test.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyConfirmationMessage {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("https://practice.cybertekschool.com/forgot_password");
        WebElement emailInputBox = driver.findElement(By.name("email"));

        String expectedEmail = "mike@smith.com";
        emailInputBox.sendKeys(expectedEmail);

        String actualEmail = emailInputBox.getAttribute("value");
        System.out.println("actualEmail = " + actualEmail);
        if(expectedEmail.equals(actualEmail)){
            System.out.println("Pass");
        }else{
            System.out.println("Fail");
        }

    }



}
