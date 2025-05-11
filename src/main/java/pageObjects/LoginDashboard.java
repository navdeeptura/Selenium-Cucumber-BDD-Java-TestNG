package pageObjects;

import org.openqa.selenium.WebDriver;

public class LoginDashboard {
    WebDriver driver;

    //Variables
    final String loginURL = "https://tutorialsninja.com/demo/index.php?route=account/account";
    final String pageTitle = "My Account";



    public LoginDashboard(WebDriver driver){
        this.driver = driver;
    }

    public String getPageURL(){
        return this.driver.getCurrentUrl();
    }

    public String getPageTitle(){
        return this.driver.getTitle();
    }


}
