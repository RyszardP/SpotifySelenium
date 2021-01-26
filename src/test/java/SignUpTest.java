import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class SignUpTest {
    WebDriver driver;
    SignUpAge page;

    @Before
    public void setUp(){
        System.setProperty("webdriver.gecko.driver", "D:\\IT\\geckodriver\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://accounts.spotify.com/ru/login");
    }


    @Test
    public void clickLogin(){
        page = new SignUpAge(driver);
        page.clickLoginButton();
        Assert.assertTrue(page.isEmptyLoginErrorVisible("Введите имя пользователя или адрес электронной почты из аккаунта Spotify."));
    }

    @Test
    public void typeLogin(){
        page = new SignUpAge(driver);
        page.typeEmail("vasya")
                .clickLoginButton();
        Assert.assertTrue(page.isEmptyPasswordErrorVisible("Введите пароль."));
    }

    @Test
    public void typeInvalidLoginAndPassword(){
        page = new SignUpAge(driver);
        page.typeEmail("vasia@mail.com")
                .typePassword("null")
                .clickLoginButton();
        Assert.assertTrue(page.isErrorVisible("Неправильное имя пользователя или пароль."));
    }


    @After
    public void tearDown(){
        driver.quit();
    }
}
