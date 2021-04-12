package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BlazeDemoFlightsPage;
import pages.BlazeDemoHomepage;
import utilities.Configuration;
import utilities.TestBase;

import java.util.List;

public class BlazeDemoPriceTest extends TestBase {

    BlazeDemoHomepage blazeDemoHomepage = new BlazeDemoHomepage();
    BlazeDemoFlightsPage blazeDemoFlightsPage = new BlazeDemoFlightsPage();

    // This test will verify that all flight prices are below $1000
    @Test
    public void priceTest(){
        driver.get(Configuration.getProperty("BlazeDemoURL"));
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        List<WebElement> prices = driver.findElements(By.xpath("//table[@class='table']//td[6]"));

        for(WebElement price: prices){
            String strPrice = price.getText().substring(1); // $472,56 -> 472.56
            // String 472.56 -> Double
            double doublePrice = Double.parseDouble(strPrice);
            //Double 472.56
            Assert.assertTrue(doublePrice<1000); // 472.56<1000 -> true
            System.out.println(doublePrice);
        }



    }



}
