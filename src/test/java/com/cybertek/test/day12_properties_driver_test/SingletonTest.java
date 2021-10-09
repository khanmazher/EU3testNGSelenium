package com.cybertek.test.day12_properties_driver_test;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class SingletonTest {

    @Test
    public void test1(){
        String s1 = Singleton.get.Instance();
        String s2 = Singleton.get.Instance();

        System.out.println("s1 = " + s1);
        System.out.println("s1 = " + s2);

    }

    @Test
    public void test2(){

        WebDriver driver = Driver.get();

    }
}
