import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import steps.SignUpSteps;

@RunWith(SerenityRunner.class)
public class WhenSignUp {
    @Steps
    SignUpSteps steps;

    @Managed
    WebDriver driver;

    @Test
    public void clickLogin() {
        steps.open_signup_page();
        steps.click_signup();
        steps.should_see_error("Please enter email");
        steps.should_not_see_error("Please enter email");
    }

    @Test
    public void typeLogin() {
        steps.open_signup_page();
        steps.type_email("vasya@mail.com");
        steps.click_signup();
        steps.should_see_error("Please enter login");
    }

    @Test
    public void typeInvalidLoginAndPassword() {
        steps.open_signup_page();
        steps.type_email("vasya@mail.com");
        steps.type_password("null");
        steps.click_signup();
        steps.should_see_error("Please enter login and password");
        steps.should_see_errors_count(2);
    }

}