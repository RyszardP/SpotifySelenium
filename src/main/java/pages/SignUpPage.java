package pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import java.util.List;

import static java.lang.String.format;
import static org.openqa.selenium.By.xpath;

@DefaultUrl("https://accounts.spotify.com/ru/login")
public class SignUpPage extends PageObject {

    private By emailField = By.xpath("//*[@id='login-username']");
    private By registerButton = By.xpath("//*[@id='login-button']");
    private By passwordField = By.xpath("//*[@id='login-password']");
    private String errorMessage = "//span[@class='ng-binding ng-scope' and string-length(text())>0]";
    private String emptyLoginError = "/html/body/div[1]/div[2]/div/form/div[1]/div/div/label";
    private String emptyPasswordError = "/html/body/div[1]/div[2]/div/form/div[2]/div/div/label";
    private By errorLabel = By.xpath("//label[@class='control-label-validation ng-binding ng-scope']");

    @Override
    public String toString() {
        return "pages.SignUpAge{" +
                "errorMessage='" + errorMessage + '\'' +
                ", emptyLoginError='" + emptyLoginError + '\'' +
                ", emptyPasswordError='" + emptyPasswordError + '\'' +
                '}';
    }

    public SignUpPage typeEmail(String email) {
        find(emailField).sendKeys(email);
        return this;
    }

    public SignUpPage typePassword(String password) {
        find(passwordField).sendKeys(password);
        return this;
    }


    public void clickLoginButton() {
        find(registerButton).click();
    }

    public boolean isErrorVisible(String message) {
        return findAll(xpath(format(errorMessage, message))).size() > 0 &&
                findAll(xpath(format(errorMessage, message))).get(0).isDisplayed();
    }

    public boolean isEmptyLoginErrorVisible(String message) {
        return findAll(xpath(format(emptyLoginError, message))).size() > 0 &&
                findAll(xpath(format(emptyLoginError, message))).get(0).isDisplayed();
    }

    public boolean isEmptyPasswordErrorVisible(String message) {
        return findAll(xpath(format(emptyPasswordError, message))).size() > 0 &&
                findAll(xpath(format(emptyPasswordError, message))).get(0).isDisplayed();
    }

    public List<WebElementFacade> getErrors() {
        return findAll(errorLabel);
    }

}
