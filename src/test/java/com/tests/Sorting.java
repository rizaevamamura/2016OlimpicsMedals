package com.tests;

import com.sybertek.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Sorting extends TestBase {

    public void login(){
        driver.get("https://en.wikipedia.org/wiki/2016_Summer_Olympics#Medal_table");
    }

    /*
        1.Go to website https://en.wikipedia.org/wiki/2016_Summer_Olympics#Medal_table.
        2.Verify that by default the Medal table is sorted by rank.
          To do that you need to capture all the cells in the Rank column and check if
          they are  in ascending order(highlighted in the picture).
        3.Click link NOC.
        4.Now verify that the table is now sorted by the country names. To do that you
          need to capture all the names in the NOC column and check if they are in
          ascending/alphabetical order (highlighted in the picture).
        5.Verify that Rank column is not in ascending order anymore.
    */

    @Test
    public void sortTest(){
        login();

        List<WebElement> rank = driver.findElements(By.xpath("//*[@id=\"mw-content-text\"]/div/table[8]//tbody/tr/td[1]"));

        //remove last indexes that we don't need
        rank.remove(rank.size()-1);
        rank.remove(rank.size()-1);

        for (WebElement e:rank) {
            System.out.println(e.getText());
        }

        //check numbers by ascending order or not
        for (int i = 0; i < rank.size()-1 ; i++) {
            int first = Integer.parseInt(rank.get(i).getText());
            int second = Integer.parseInt(rank.get(i+1).getText());

            if(second - first == 1){
                Assert.assertTrue(true);
            }
            else{
                Assert.assertTrue(false);
            }
        }

        //click on NOC
        driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table[8]//thead/tr/th[2]")).click();

        List<WebElement> countries = driver.findElements(By.xpath("//*[@id=\"mw-content-text\"]/div/table[8]//tbody/tr/th"));

        for (WebElement e:countries) {
            System.out.println(e.getText());
        }

        System.out.println("******************************");

        //copy the values to string list to check
        List<String> copyOfCountries = new ArrayList<>();
        for (WebElement e:countries) {
            copyOfCountries.add(e.getText());
        }

        //sort the string list
        Collections.sort(copyOfCountries);
        for (String str:copyOfCountries) {
            System.out.println(str);
        }

        //compare with countries given in the table
        for (int i = 0; i < countries.size() ; i++) {
            if(countries.get(i).getText().equals(copyOfCountries.get(i)))
                Assert.assertTrue(true);
            else
                Assert.assertTrue(false);
        }

        //check rank column is not sorted
        List<WebElement> rankAfter = driver.findElements(By.xpath("//*[@id=\"mw-content-text\"]/div/table[8]//tbody/tr/td[1]"));

        rankAfter.remove(7);

        System.out.println("*****After Sorted alfabetically");

        for (WebElement e:rankAfter) {
            System.out.println(e.getText());
        }

        //check numbers by ascending order or not
        for (int i = 0; i < rankAfter.size()-1 ; i++) {
            int first = Integer.parseInt(rankAfter.get(i).getText());
            int second = Integer.parseInt(rankAfter.get(i+1).getText());

            if(second - first != 1){
                Assert.assertTrue(true);
            }
        }
    }
}
