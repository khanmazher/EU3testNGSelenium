package com.cybertek.test.day12_properties_driver_test;

public class Singleton {

    private Singleton(){

        private static String str;

        public static String getInstance(){
            if(str==null){
                System.out.println("str is null. assign value it");
                str="somevalue";
            }else{
                System.out.println("it has value, just returning it");
            }

            return str;
        }

    }
}
