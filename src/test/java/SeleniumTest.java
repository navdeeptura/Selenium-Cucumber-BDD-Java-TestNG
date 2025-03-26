import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.StreamTokenizer;
import java.time.Duration;

public class SeleniumTest {

    public static ChromeOptions options = new ChromeOptions();
    public static WebDriver driver = new ChromeDriver();
    public static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public WebElement waitAndGet(By locator){
       return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(locator));
    }


    @BeforeTest
    public static void Setup(){

        options.addArguments("--remote-allow-origins=*");

        System.setProperty("webdriver.chrome.driver",
                System.getProperty("user.dir") + "/src/test/resources/chromedriver.exe");

        driver.get("https://formy-project.herokuapp.com/");
    }

    @Test
    void browseWebsitePages() throws InterruptedException {
        driver.findElement(By.xpath("//a[@class='nav-link']")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("navbarDropdownMenuLink")));
        driver.findElement(By.id("navbarDropdownMenuLink")).click();

        // test
        By dropdownInDropdownLocation = By.xpath(
                "//a[@href=\"/dropdown\" and @class=\"dropdown-item\"]");
        wait.until(ExpectedConditions.presenceOfElementLocated(dropdownInDropdownLocation));
        driver.findElement(dropdownInDropdownLocation).click();

        waitAndGet(By.cssSelector("button.btn.btn-primary.dropdown-toggle")).click();

        Thread.sleep(10000);
        driver.quit();
    }
}
