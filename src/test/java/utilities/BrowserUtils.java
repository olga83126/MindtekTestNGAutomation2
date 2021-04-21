package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.Set;

public class BrowserUtils {
    /**
     * This method will accept webelement of dropdown
     * and String value of dropdown. And then will select
     * provided value in dropdown.
     * Ex:
     *   .selectDropdownByValue(element,"1");
     */
    public static void selectDropdownByValue(WebElement element,String value){
        Select select = new Select(element);
        select.selectByValue(value);

    }

    /**
     * This method will wait for element to be clickable.
     * EX:
     *   .waitElementToBeClickable(element, 10); -> returns element;
     */
    public static WebElement waitElementToBeClickable(WebElement element, int seconds){
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(),seconds);
        WebElement element1=wait.until(ExpectedConditions.elementToBeClickable(element));
        return element1;
    }

    /**
     * This method will wait for element to be visible.
     *  EX:
     *      *   .waitElementToBevisible(element, 10); -> returns element;
     */
    public static WebElement waitElementToBevisible(WebElement element, int seconds){
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(),seconds);
        WebElement element1=wait.until(ExpectedConditions.visibilityOf(element));
        return element1;
    }
    /**
     * This method will help to switch to another window.
     */
    public static void switchWindow(){
        WebDriver driver = Driver.getDriver();
        String currentWindowID = driver.getWindowHandle();
        Set<String> windows = driver.getWindowHandles();
        for(String window : windows){
            if(!currentWindowID.equals(window)){
                driver.switchTo().window(window);

            }
        }

    }
    /**
     * This method will scroll down and up.
     * EX:
     *    .scroll(250); it up    scroll(-250); down
     */

    public static void scroll(int pixels){
        WebDriver driver = Driver.getDriver();
        JavascriptExecutor js = ((JavascriptExecutor)driver);
        js.executeScript("window.scrollBy(0,"+pixels+")");

    }

    /**
     * This method will take screenshot.
     * Ex.
     *        .takeScreenshot("SauceDemo app test");
     *
     */

    public static void takeScreenshot(String testName) throws IOException {
        WebDriver driver = Driver.getDriver();
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String path ="src/test/resources/screenshots/"+testName+".png";
        File file = new File(path);
        FileUtils.copyFile(screenshot,file);
    }
}


