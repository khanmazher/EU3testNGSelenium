package com.cybertek.test.day15_review;

import com.cybertek.pages.ContactInfoPage;
import com.cybertek.pages.ContactsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.test.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class verifyContactInfoTest extends TestBase {

    @Test
    public void contactDetailsTest(){

        extentLogger = report.createTest("Contact Info Verification");

        LoginPage loginPage = new LoginPage();

        String username = ConfigurationReader.get("salesmanager_username");
        String password = ConfigurationReader.get("salesmanager_password");
        extentLogger.info("username: "+username);
        extentLogger.info("password: "+username);
        extentLogger.info("Login as a Sales Manager");

        loginPage.login(username,password);

        extentLogger.info("Navigate to --> Customers --> Contacts");

        new DashboardPage().navigateToModule("Customer", "Contacts");

        ContactsPage contactsPage = new ContactsPage();
        extentLogger.info("Click on mbrackstone9@exaple.com");
        contactsPage.waitUntilLoaderScreenDisappear();
        contactsPage.getContactEmail("mbrackstone9@example.com").click();

        ContactInfoPage contactInfoPage = new ContactInfoPage();

        String expectedFullName = "Mariam Brackstone";
        String actualFullName = contactInfoPage.fullname.getText();

        extentLogger.info("Verify full name is "+ expectedFullName);
        Assert.assertEquals(actualFullName,expectedFullName, "verify fullname");

        extentLogger.info("Verify email is mbrackstone9@example.com");
        Assert.assertEquals(contactInfoPage.email.getText(), "mbrackstone9@example.com",  "Verify email");

        extentLogger.info("Verify phone number is +18982323434");
        Assert.assertEquals(contactInfoPage.phone.getText(),"+18982323434", "Verify phone number");

        extentLogger.info("PASSED");


    }

}
