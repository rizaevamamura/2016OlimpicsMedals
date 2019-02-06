package com.tests;

import com.sybertek.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class GetSum extends TestBase {
    public void login(){

        driver.get("https://en.wikipedia.org/wiki/2016_Summer_Olympics#Medal_table");
    }
    /*
        Write a method that returns a list of two countries whose sum of bronze medals is 18.
     */
    @Test
    public List<String> getSum(){
        login();

        //take all countries with bronze meadal
        List<WebElement> bronze = driver.findElements(By.xpath("//*[@id=\"mw-content-text\"]/div/table[8]//tbody/tr/td[4]"));

        bronze.remove(bronze.size()-1);
        bronze.remove(bronze.size()-1);

        //get county names
        List<WebElement> countryNames = driver.findElements(By.xpath("//*[@id=\"mw-content-text\"]/div/table[8]//tbody/tr/th"));

        // create String list to hold countries that their bronze medal sum 18
        List<String> list = new ArrayList<>();

        int sum = 0;

        outer:for (int i = 0; i < bronze.size() ; i++) {

            inner:for (int j = 0; j < bronze.size() ; j++) {
                            if( j == i){
                            continue inner;
                            }
                            if(Integer.parseInt(bronze.get(i).getText()) + Integer.parseInt(bronze.get(j).getText()) == 18 ){
                                list.add(countryNames.get(i).getText() +" + " + countryNames.get(j).getText());
                            }

            }
        }
        return list;
    }

    @Test
    public void testGetSum(){
        System.out.println(getSum());
    }
}
