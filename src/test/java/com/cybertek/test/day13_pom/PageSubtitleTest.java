package com.cybertek.test.day13_pom;

import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.test.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PageSubtitleTest extends TestBase {

    @Test
    public void test1(){
        LoginPage loginPage = new LoginPage();

        loginPage.loginAsDriver();

        String expectedSubtitle = "Quick Launchpad";

        DashboardPage dashboardPage = new DashboardPage();

        String actualSubtitle = dashboardPage.getPageSubTitle();

        Assert.assertEquals(actualSubtitle,expectedSubtitle, "Verify Subtitle");

        dashboardPage.navigateToModule("Avtivities", "Calendar Events");





    }


}
