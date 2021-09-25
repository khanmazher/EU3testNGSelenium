package com.cybertek.test.day7_TestNG;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGAssertionsDemo {

    @BeforeMethod
    public void setUp(){
        System.out.println("Open Browser");
    }
    @Test
    public void test1(){
        System.out.println("First Assertion");
        Assert.assertEquals("title", "title");

        System.out.println("Second Assertion");
        Assert.assertEquals("url", "url");
    }

    @Test
    public void test2(){
        Assert.assertEquals("test2", "test2");

    }

    @Test
    public void test3(){
        String expectedtitle = "Cyb";
        String actualTitle = "Cybertek";
        Assert.assertTrue(actualTitle.startsWith(expectedtitle));
    }



    @AfterMethod
    public void tearDown(){
        System.out.println("Close browser");

    }
}
