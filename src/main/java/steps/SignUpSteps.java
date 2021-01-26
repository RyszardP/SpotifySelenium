package steps;

import net.thucydides.core.annotations.Step;
import org.assertj.core.api.Assertions;
import pages.SignUpPage;

public class SignUpSteps {
    SignUpPage page;

    @Step
    public void open_signup_page(){
        page.open();
    }

    @Step("User types email (0)")
    public void type_email(String email) {
        page.typeEmail(email);
    }

    @Step
    public void type_password(String password) {
        page.typePassword(password);
    }

    @Step
    public void click_signup() {
        page.clickLoginButton();
    }

    @Step
    public void should_see_error(String message){
        Assertions.assertThat(page.isEmptyLoginErrorVisible(message))
                .as("User should see message, but he doesn`t")
                .isTrue();
    }

    @Step
    public void should_not_see_error(String message){
        Assertions.assertThat(page.isEmptyLoginErrorVisible(message))
                .as("User should not see message, but he does")
                .isFalse();
    }

    @Step
    public void should_see_errors_count(int count){
        Assertions.assertThat(page.getErrors()).hasSize(count);
    }



}
