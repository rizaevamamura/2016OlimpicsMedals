/*
I am adding this comments to parctise git fetch and merge
*/
package com.tests;

import com.sybertek.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class CountryByMedal extends TestBase {
    public void login(){

        driver.get("https://en.wikipedia.org/wiki/2016_Summer_Olympics#Medal_table");
    }

    /*
        Write a method that returns a list of countries by their silver medal count. You decide the data type of the return.
     */

    public List<String> getCountryByMedal(){
        List<String> list = new ArrayList<>();
        login();

        //locate silver heading
        driver.findElement(By.xpath("//th[.=\"Silver\"]")).click();

        //get county names
        List<WebElement> countryNames = driver.findElements(By.xpath("//*[@id=\"mw-content-text\"]/div/table[8]//tbody/tr/th"));

        int count = 0;
        for(WebElement e: countryNames){
            count++;
            list.add(count +". " + e.getText());
        }
        return list;
    }

    //this is the test the method
    @Test
    public void test(){
        for(String s:getCountryByMedal()){
            System.out.println(s);
        }
    }
}
