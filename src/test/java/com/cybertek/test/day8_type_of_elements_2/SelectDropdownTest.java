package com.cybertek.test.day8_type_of_elements_2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SelectDropdownTest {

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
        driver.get("http://practice.cybertekschool.com/dropdown");
        WebElement dropdownElement = driver.findElement(By.id("state"));

        Select stateDropdown = new Select(dropdownElement);

        List<WebElement> options = stateDropdown.getOptions();
        System.out.println("option.size() = " + options.size());
        for (WebElement option : options) {
            System.out.println(option.getText());

            String expectedOption = "Select a State";
            String actualOption = stateDropdown.getFirstSelectedOption().getText();
            Assert.assertEquals(actualOption,expectedOption, "verify first selection");

            Thread.sleep(2000);
            stateDropdown.selectByVisibleText("Virginia");

            expectedOption = "Virginia";
            actualOption = stateDropdown.getFirstSelectedOption().getText();
            Assert.assertEquals(actualOption,expectedOption,"verify first selected option");

            Thread.sleep(2000);
            stateDropdown.selectByIndex(51);

            expectedOption = "Wyoming";
            actualOption = stateDropdown.getFirstSelectedOption().getText();
            Assert.assertEquals(actualOption,expectedOption, "verify first selection");

            stateDropdown.selectByValue("TX");
            Thread.sleep(2000);

            expectedOption = "Texas";
            actualOption = stateDropdown.getFirstSelectedOption().getText();
            Assert.assertEquals(actualOption,expectedOption, "verify first selection");





        }
    }



    }
