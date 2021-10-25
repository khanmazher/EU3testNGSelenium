package com.cybertek.test.day14_extent_reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.cybertek.pages.LoginPage;
import com.cybertek.test.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTestWithReport extends TestBase {


    private ExtentTest extentLogger;
    private ExtentReports report;

    @Test
    public void wrongPasswordTest(){

        //name of the test

        extentLogger = report.createTest("Wrong Password Test");

        LoginPage loginPage = new LoginPage();

        loginPage.usernameInput.sendKeys("user1");
        extentLogger.info("Enter username: user1");

        loginPage.passwordInput.sendKeys("somepassword");
        extentLogger.info("Enter password: somepassword");


        loginPage.loginBtn.click();
        extentLogger.info("Verify page URL");

        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/user/login");

    }

    @Test
    public void wrongUsernameTest(){
        LoginPage loginPage = new LoginPage();

        extentLogger = report.createTest("Wrong Password Test");

        loginPage.usernameInput.sendKeys("someusername");
        extentLogger.info("Enter username: user1");

        loginPage.passwordInput.sendKeys("UserUser123");
        extentLogger.info("Enter password: somepassword");

        loginPage.loginBtn.click();
        extentLogger.info("Verify page URL");


        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/user/login");
        extentLogger.info("Verify page URL");


    }

}
