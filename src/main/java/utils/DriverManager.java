package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.ObjectUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DriverManager {
    private static WebDriver driver;

    public static WebDriver getDriver(){
        if (driver == null){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(
                    Duration.ofSeconds(ConfigManager.getIntProperty("implicit.wait")));
        }
        return driver;
    }

    public static void quitDriver(){
        if (driver != null){
            driver.quit();
            driver = null;
        }
    }
}
