package stepDefinitions;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.LoginDashboard;
import utils.ConfigManager;
import utils.DriverManager;
import pageObjects.LandingPage;
import pageObjects.LoginPage;

public class LoginSteps {

    // web driver and page objects
    private final WebDriver driver;
    private final LandingPage landingPage;
    private final LoginPage loginPage;
    private final LoginDashboard loginDashboard;

    //config keys
    private static final String APP_URL = "app.url";
    private static final String USERNAME = "validUserName";
    private static final String PASSWORD = "validPassword";
    private static final String ACCOUNT_PAGE_URL= "accountPageURL";
    private static final String ACCOUNT_PAGE_TITLE = "accountPageTitle";

    public LoginSteps(){
        this.driver = DriverManager.getDriver();
        this.landingPage = new LandingPage(driver);
        this.loginPage = new LoginPage(driver);
        this.loginDashboard = new LoginDashboard(driver);
    }

    @Before
    public void setup(){
        driver.get(ConfigManager.getProperty(APP_URL));
    }

    @After
    public void tearDown(){
        DriverManager.quitDriver();
    }

    @Given("I navigate to the login page")
    public void navigateToLoginPage(){
        landingPage.clickMyAccount();
        landingPage.clickLoginButtonInNavigationBar();
    }

    @When("I enter a valid username and valid password")
    public void enterCredentialsAndClickLogin(){
        loginPage.enterUserName(ConfigManager.getProperty(USERNAME));
        loginPage.enterPassword(ConfigManager.getProperty(PASSWORD));
        loginPage.clickLoginButton();
    }

    @Then("I should see the homepage")
    public void verifyLoginSuccessful(){
        String expectedAccountPageURL = ConfigManager.getProperty(ACCOUNT_PAGE_URL);
        String expectedAccountPageTitle = ConfigManager.getProperty(ACCOUNT_PAGE_TITLE);
        Assert.assertEquals(loginDashboard.getPageURL(), expectedAccountPageURL);
        Assert.assertEquals(loginDashboard.getPageTitle(), expectedAccountPageTitle);
    }
}
