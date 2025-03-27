package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class LoginSteps {
    private static WebDriver driver;

    @Given("I navigate to the login page")
    public void navigate_to_login_page(){
        System.setProperty("webdriver.chrome.driver",
                System.getProperty("user.dir") + "/src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://localhost:5192/");
    }

    @When("I enter a valid username and valid password")
    public void enter_valid_username_and_password(){
        driver.findElement(By.xpath("//input[@name=\"username\"]"))
                .sendKeys("Raman");
        driver.findElement(By.xpath("//input[@name=\"password\"]"))
                .sendKeys("raman");
        driver.findElement(By.cssSelector("button.btn.btn-primary.w-100")).click();
    }

    @Then("I should see the homepage")
    public void verify_home_page(){
        String actualWelcomeText = driver.findElement(By.xpath(
                "//p[text()=\"Welcome to ERP System\"]")).getText();
        String expectedText = "Welcome to ERP System";
        Assert.assertEquals(actualWelcomeText, expectedText);
        driver.close();
        driver.quit();
    }
}
