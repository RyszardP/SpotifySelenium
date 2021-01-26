import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static java.lang.String.format;
import static org.openqa.selenium.By.xpath;

public class SignUpAge {
    WebDriver driver;

    public SignUpAge(WebDriver driver) {
        this.driver = driver;
    }

    By emailField = By.xpath("//*[@id='login-username']");
    By registerButton = By.xpath("//*[@id='login-button']");
    By passwordField = By.xpath("//*[@id='login-password']");
    String errorMessage = "//span[@class='ng-binding ng-scope' and string-length(text())>0]";
    String emptyLoginError = "/html/body/div[1]/div[2]/div/form/div[1]/div/div/label";
    String emptyPasswordError = "/html/body/div[1]/div[2]/div/form/div[2]/div/div/label";

    @Override
    public String toString() {
        return "SignUpAge{" +
                "errorMessage='" + errorMessage + '\'' +
                ", emptyLoginError='" + emptyLoginError + '\'' +
                ", emptyPasswordError='" + emptyPasswordError + '\'' +
                '}';
    }

    public SignUpAge typeEmail(String email){
        driver.findElement(emailField).sendKeys(email);
        return this;
    }

    public SignUpAge typePassword(String password){
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }


    public void clickLoginButton(){
        driver.findElement(registerButton).click();
    }

    public boolean isErrorVisible(String message){
       return driver.findElements(xpath(format(errorMessage, message))).size() > 0 && driver.findElements(xpath(format(errorMessage, message))).get(0).isDisplayed();
    }

    public boolean isEmptyLoginErrorVisible(String message){
        return driver.findElements(xpath(format(emptyLoginError, message))).size() > 0 && driver.findElements(xpath(format(emptyLoginError, message))).get(0).isDisplayed();
    }

    public boolean isEmptyPasswordErrorVisible(String message){
        return driver.findElements(xpath(format(emptyPasswordError, message))).size() > 0 && driver.findElements(xpath(format(emptyPasswordError, message))).get(0).isDisplayed();
    }
}
