package com.cybertek.reviews.day06;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AdidasTask {
    WebDriver driver;
    WebDriverWait wait;

    int expectedPurchaseAmount;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.demoblaze.com/index.html");

    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }

    @Test
    public void purchaseTest() throws InterruptedException {

        String[][] purchaseInfo = new String[][]{{"Laptops","Sony vaio i5"},{"Laptops","Dell i7 8gb"}};
        for (String[] strings : purchaseInfo){
            productAdder(strings[0],strings[1]);
        }

        String[] unwantedProductsInfo = {"Dell i7 8gb"};
        for (String s : unwantedProductsInfo){
            expectedPurchaseAmount-=productRemover(s);
        }

    }

    private int productAdder(String category, String product){

        //click on any category --> laptops, phones, monitors etc
        driver.findElement(By.linkText(category)).click();

        //click on any product
        driver.findElement(By.linkText(product)).click();

        String priceText = driver.findElement(By.xpath("//h3[@class='price-container']")).getText();
        String[] arrayAmount = priceText.split(" ");
        int listPrice = Integer.parseInt(arrayAmount[0].substring(1));

        driver.findElement(By.linkText("Add to card")).click();

        //sometimes webpage gives no such alert exception so we are waiting dynamically
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();

        driver.findElement(By.partialLinkText("Home")).click();

        return listPrice;
    }

    public int productRemover(String product){
        driver.findElement(By.linkText("Cart")).click();
        String productPath = "//td[.='"+product+"']"; //string concatination to get dynamically locator
        String productPricePath = productPath+"/../td[3]";
        String deletePath = productPath+"/../td[4]/a";

        //get price of deleted product
        String priceText = driver.findElement(By.xpath(productPricePath)).getText();

        //delete product
        driver.findElement(By.xpath(deletePath)).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(productPath)));
        return Integer.parseInt(priceText);

    }



}
