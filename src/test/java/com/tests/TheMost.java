package com.tests;

import com.sybertek.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


public class TheMost extends TestBase {
    /*
    setup method
     */
    public void login(){

        driver.get("https://en.wikipedia.org/wiki/2016_Summer_Olympics#Medal_table");
    }

    /*
        Write a method that returns the name of the country with the greatest
        number of gold medals.
     */

    public  String mostGold(){
        login();

        List<WebElement> numOfGolds = driver.findElements(By.xpath("//*[@id=\"mw-content-text\"]/div/table[8]//tbody/tr/td[2]"));

        numOfGolds.remove(numOfGolds.size()-1);
        numOfGolds.remove(numOfGolds.size()-1);


        int biggest = 0;
        int index = -1;

        for (int i = 0; i < numOfGolds.size(); i++) {
            //System.out.println(we.getText());
            if(Integer.parseInt(numOfGolds.get(i).getText()) > biggest){
                biggest = Integer.parseInt(numOfGolds.get(i).getText());
                index = i;
            }
        }

        List<WebElement> countryNames = driver.findElements(By.xpath("//*[@id=\"mw-content-text\"]/div/table[8]//tbody/tr/th"));

        return countryNames.get(index).getText();
    }

    /*
        Write a method that returns the name of the country with the greatest
        number of silver medals.
     */
    public  String mostSilver(){
        login();

        List<WebElement> numOfSilver = driver.findElements(By.xpath("//*[@id=\"mw-content-text\"]/div/table[8]//tbody/tr/td[3]"));

        numOfSilver.remove(numOfSilver.size()-1);
        numOfSilver.remove(numOfSilver.size()-1);

        int biggest = 0;
        int index = -1;

        for (int i = 0; i < numOfSilver.size(); i++) {
            //System.out.println(we.getText());
            if(Integer.parseInt(numOfSilver.get(i).getText()) > biggest){
                biggest = Integer.parseInt(numOfSilver.get(i).getText());
                index = i;
            }
        }
        System.out.println("biggest " + biggest);

        List<WebElement> countryNames = driver.findElements(By.xpath("//*[@id=\"mw-content-text\"]/div/table[8]//tbody/tr/th"));

        return countryNames.get(index).getText();
    }



    /*
        Write a method that returns the name of the country with the greatest
        number of bronze medals
    */
    public String mostNumberOfMedals(){
        login();

        List<WebElement> numOfMedals = driver.findElements(By.xpath("//*[@id=\"mw-content-text\"]/div/table[8]//tbody/tr/td[5]"));

        numOfMedals.remove(numOfMedals.size()-1);
       // numOfMedals.remove(numOfMedals.size()-1);

        int biggest = 0;
        int index = -1;

        for (int i = 0; i < numOfMedals.size(); i++) {
            //System.out.println(we.getText());
            if(Integer.parseInt(numOfMedals.get(i).getText()) > biggest){
                biggest = Integer.parseInt(numOfMedals.get(i).getText());
                index = i;
            }
        }
        System.out.println("biggest " + biggest);

        List<WebElement> countryNames = driver.findElements(By.xpath("//*[@id=\"mw-content-text\"]/div/table[8]//tbody/tr/th"));

        return countryNames.get(index).getText();

    }
    public  String mostBronze(){
        login();
        List<WebElement> bronze = driver.findElements(By.xpath("//*[@id=\"mw-content-text\"]/div/table[8]//tbody/tr/td[4]"));
        bronze.remove(bronze.size()-1);
        bronze.remove(bronze.size()-1);

        int biggest = 0;
        int index = -1;

        for (int i = 0; i < bronze.size(); i++) {
            //System.out.println(we.getText());
            if(Integer.parseInt(bronze.get(i).getText()) > biggest){
                biggest = Integer.parseInt(bronze.get(i).getText());
                index = i;
            }
        }

        List<WebElement> countryNames = driver.findElements(By.xpath("//*[@id=\"mw-content-text\"]/div/table[8]//tbody/tr/th"));

        return countryNames.get(index).getText();
    }

    /*
        Write a method that returns the name of the country with the greatest number of medals.
     */

    @Test
    public void testMostGold(){
        String name = mostGold().trim();
        Assert.assertTrue(name.equals("United States (USA)"));
    }

    @Test
    public void testMostSilver(){
        String name = mostSilver().trim();
        Assert.assertTrue(name.equals("United States (USA)"));
    }

    @Test
    public void testMostBronze(){
        String name = mostBronze().trim();
        Assert.assertTrue(name.equals("United States (USA)"));
    }

    @Test
    public void testMostNumberOfMedals(){
        String name = mostNumberOfMedals().trim();
        Assert.assertTrue(name.equals("United States (USA)"));
    }
}
