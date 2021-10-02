package com.cybertek.reviews.day06;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Scrolling_Test {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/");

    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }

    @Test
    public void TestWithActioinClass() throws InterruptedException {
        Actions actions = new Actions(driver);

        //Locate the element you want to scroll to
        WebElement cybertekSchoolElement = driver.findElement(By.linkText("Cybertek School"));

        //scroll using action object using moveToElements method
        actions.moveToElement(cybertekSchoolElement).perform();
        Thread.sleep(4000);

        actions.sendKeys(Keys.PAGE_UP, Keys.PAGE_UP).perform();
        Thread.sleep(2000);

        actions.sendKeys(Keys.PAGE_DOWN, Keys.PAGE_DOWN).perform();

    }
}
