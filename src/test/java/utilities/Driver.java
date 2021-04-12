package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.rmi.Remote;
import java.util.concurrent.TimeUnit;

public class Driver {

    private static WebDriver driver;

    /*
    Write a method which will set up the driver.
    the name of method will be.getDriver();
     */
    public static WebDriver getDriver(){
        String browser = "chrome";
        if(driver==null ||((RemoteWebDriver)driver).getSessionId()==null){ // driver==null
            if(browser.equals("chrome")){
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }else if(browser.equals("edge")){
                WebDriverManager.edgedriver().setup();
                driver= new EdgeDriver();
            }else if(browser.equals("ie")){
                WebDriverManager.edgedriver().setup();
                driver=new InternetExplorerDriver();
            }

        }else{
            return driver;
        }
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;

    }
}
