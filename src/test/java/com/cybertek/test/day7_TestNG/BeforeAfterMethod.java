package com.cybertek.test.day7_TestNG;

import org.testng.annotations.*;

public class BeforeAfterMethod {

    @BeforeClass
    public void setUpClass(){
        System.out.println("----BEFORE CLASS----");
        System.out.println("Executed one time before the class");
    }

    @Test
    public void test1(){
        System.out.println("First Test Case");
    }



    @Test
    public void test2(){
        System.out.println("WebDriver, Opening Browser");
        System.out.println("Second Test Case");
        System.out.println("Closing Browser, Quit");
    }

    @BeforeMethod
    public void setUp(){
        System.out.println("WebDriver, Opening Browser");
    }

    @AfterMethod
    public void tearDown(){
        System.out.println("Closing Browser, Quit");
    }

    @AfterClass
    public void tearDownClass(){
        System.out.println("----AFTER CLASS----");
        System.out.println("Some Reporting Code Here");
    }

}
