package com.cybertek.test.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class iframeTest {
    WebDriver driver;

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
    public void test1() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/iframe");

        driver.switchTo().frame("mce_0_ifr");

        //To clear the contents of the box before we type
        driver.findElement(By.cssSelector("#tinymce")).clear();

        //to type MikeSmith in the box
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#tinymce")).sendKeys("MikeSmith");

        //to move back to the default box with original content when opened
        driver.switchTo().defaultContent();

        //to Swithch between index
        driver.switchTo().frame(0);
        Thread.sleep(2000);

        //to type second set of text after the first MikeSmith above
        driver.findElement(By.cssSelector("tinymce")).clear();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#tinymce")).sendKeys("MikeSmith WITH Index");

        //second way to swith to original frame / parent frame
        driver.switchTo().parentFrame();

        //third way of swithching back by using WebElement (by locating iframe)
        WebElement iframeElement = driver.findElement(By.tagName("iframe"));

        driver.switchTo().frame(iframeElement);
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#tinymce")).sendKeys("MikeSmith WITH WEBELEMENT");
    }

    @Test
    public void test2(){

        driver.get("http://practice.cybertekschool.com/nested_frames");
        //switch to top frame
        driver.switchTo().frame("frame-top");
        //top has 3 frames - left, middle and right
        //swith to middle frame
        driver.switchTo().frame("frame-middle");

        System.out.println(driver.findElement(By.id("content")).getText());

        //to switch back to top frame
        driver.switchTo().parentFrame();
        //to switch to right frame with index
        driver.switchTo().frame(2);

        System.out.println(driver.findElement(By.tagName("body")).getText());

        //to swtich to bottom - go to main html
        driver.switchTo().frame(1);
        System.out.println(driver.findElement(By.tagName("body")).getText());



    }

}
