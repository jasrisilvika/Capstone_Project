package starter.pages;

import io.cucumber.java.en.Given;
import net.serenitybdd.screenplay.actions.OpenUrl;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class LoginPage extends PageObject {
    private By usernameField(){
        return By.id("fld-input-username-login");
    }

    private By passwordField(){
        return By.id("fld-input-password-login");
    }

    private By loginButton(){
        return By.xpath("//button[text()='Login']");
    }

    @Step
    public static OpenUrl url(String targeturl){
        return new OpenUrl(targeturl);
    }

    @Step
    public void maximiseScreen() {
        getDriver().manage().window().maximize();
    }

    @Step
    public void validateOnLoginPage(){
        $(loginButton()).isDisplayed();
    }

    @Step
    public void inputUsername(String username){
        $(usernameField()).type(username);
    }

    @Step
    public void inputPassword(String password){
        $(passwordField()).type(password);
    }

    @Step
    public void clickLoginButton(){
        $(loginButton()).click();
    }

//    @Step
//    public void validateResult(String result){
//        if (result.equals("success")){
//            // validate on dashboard amdin
//        }
//    }

}
