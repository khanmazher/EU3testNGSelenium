package com.cybertek.test.day16_ddf;

import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.test.TestBase;
import com.cybertek.utilities.ExcelUtil;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDFLoginTest extends TestBase {

    @DataProvider
    public Object[][] userData(){
        ExcelUtil qa3short = new ExcelUtil("scr/test/resources/Vytracktestdata.xlsx", "QA3-short");

        String [][] dataArray = qa3short.getDataArrayWithoutFirstRow();

        return dataArray;
    }

    @Test(dataProvider = "userData")
    public void test1(String username, String password, String firstName, String lastName){
        extentLogger=report.createTest("Test "+firstName+ " "+lastName);
        LoginPage loginPage = new LoginPage();

        loginPage.login(username, password);

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.waitUntilLoaderScreenDisappear();

        String actualFullName = dashboardPage.getUserName();
        String expectedFullName = firstName+" "+lastName;

        Assert.assertEquals(actualFullName,expectedFullName, "verify fullname");
        extentLogger.pass("PASSED");
    }


}
