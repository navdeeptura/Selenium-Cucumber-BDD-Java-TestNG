package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    WebDriver driver;
    private final By usernameLocator = By.cssSelector("input.form-control[name=\"email\"]");
    private final By passwordLocator = By.cssSelector("input.form-control[name=\"password\"]");
    private final By loginButtonLocator = By.cssSelector("input.btn.btn-primary[value=\"Login\"]");


    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void enterUserName(String email){
        WebElement userName = this.driver.findElement(usernameLocator);
        userName.click();
        userName.sendKeys(email);
    }

    public void enterPassword(String password){
        WebElement passwordTextBox = this.driver.findElement(passwordLocator);
        passwordTextBox.click();
        passwordTextBox.sendKeys(password);
    }

    public void clickLoginButton(){
        this.driver.findElement(loginButtonLocator).click();
    }


}
