package com.cybertek.test.day10_actions_js;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionsTest {

    WebDriver driver;
    private WebElement img1;

    @BeforeMethod
    public void setup(){
        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException{
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void hoverTest() throws InterruptedException {
        driver.get("http://pratice.cybertekschool.com/hovers");

        WebElement img = driver.findElement(By.tagName("img"));

        //Actions class contains all the interaction
        Actions actions = new Actions(driver);
        Thread.sleep(2000);
        //perform performs the action and completes the action
        actions.moveToElement(img1).perform();

        WebElement viewLink = driver.findElement(By.linkText("View profile"));

        Assert.assertTrue(viewLink.isDisplayed(), "verify view link is displayed");


    }
}
