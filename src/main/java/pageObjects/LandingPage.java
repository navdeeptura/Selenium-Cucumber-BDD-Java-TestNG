package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {
    WebDriver driver;

    //Locators
    private final By myAccount = By.cssSelector("a[class=\"dropdown-toggle\"] span.caret");
    private final By loginButtonInNavigationBar = By.cssSelector("ul.dropdown-menu.dropdown-menu-right " +
            "a[href='https://tutorialsninja.com/demo/index.php?route=account/login']");

    public LandingPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickMyAccount(){
        this.driver.findElement(myAccount).click();
    }

    public void clickLoginButtonInNavigationBar(){
        this.driver.findElement(loginButtonInNavigationBar).click();
    }
}
