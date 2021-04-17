package utilities;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
   protected WebDriver driver;

    @BeforeMethod(groups = {"regression","smoke"})
    public void setUp() {
        driver = Driver.getDriver();
    }

    @AfterMethod(groups = {"regression","smoke"})
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();

    }
}