package com.cybertek.test.day16_ddf;

import com.cybertek.utilities.ExcelUtil;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ExcelUtilsDemo {

    @Test
    public void readExcelFile(){

        // Create an object from ExcelUtil
        //it accepts two arguments
        //Argument 1: Location of the file(path)
        //Argument 2: Sheet that we want to open (Sheet name)
        ExcelUtil qa3short = new ExcelUtil("src/test/resources/Vytracktestdata.xlsx","QA3-short");

        //how many rows in the sheet
        System.out.println("qa3short.rowCount() = " + qa3short.rowCount());

        //how many columns in the sheet
        System.out.println("qa3short.columnCount() = " + qa3short.columnCount());

        //get all column names
        System.out.println("qa3short.getColumnsNames() = " + qa3short.getColumnsNames());

        //get all data in list of maps
        List<Map<String, String>> dataList = qa3short.getDataList();
        for (Map<String, String> onerow : dataList){
           // System.out.println(onerow);
        }

        //get Nona as a value
        System.out.println("dataList.get(2) = " + dataList.get(2).get("firstname"));

        //get Harber
        System.out.println("dataList.get(8) = " + dataList.get(8).get("lastname"));

        //get all data in 2D array
        String [][] dataArray = qa3short.getDataArray();
        System.out.println(Arrays.deepToString(dataArray));



    }
}
