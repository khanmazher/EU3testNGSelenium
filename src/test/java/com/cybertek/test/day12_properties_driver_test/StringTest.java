package com.cybertek.test.day12_properties_driver_test;

import org.testng.annotations.Test;

public class StringTest {

    @Test
    public void test1(){
        String s1 = Singleton.getInstance();
        String s2 = Singleton.getInstance();

        System.out.println("s1 = " + s1);
        System.out.println("s1 = " + s2);

    }
}
