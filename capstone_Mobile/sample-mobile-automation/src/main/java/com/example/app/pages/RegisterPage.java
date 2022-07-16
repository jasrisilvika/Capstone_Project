package com.example.app.pages;

import com.example.app.Utils.General;
import com.example.app.base.BasePageObject;
import io.appium.java_client.MobileBy;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import java.io.FileWriter;
import java.io.IOException;

public class RegisterPage extends BasePageObject {
    General general = new General();
    String username, email;
    By getStartedButton(){
        return By.xpath("//android.widget.Button[@content-desc=\"Get Started\"]");
    }


    By signUpButton(){
        return By.xpath("//android.widget.Button[@content-desc=\"Sign Up\"]");
    }

    By usernameField(){
        return By.xpath("//android.view.View/android.widget.EditText[1]");
    }

    By emailField(){
        return By.xpath("//android.view.View/android.widget.EditText[2]");
    }

    By phoneNumberField(){
        return By.xpath("//android.view.View/android.widget.EditText[3]");
    }

    By passwordField(){
        return By.xpath("//android.view.View/android.widget.EditText[4]");
    }

    By confirmPasswordField(){
        return By.xpath("//android.view.View/android.widget.EditText[5]");
    }

    By errorMessage(String result){
        return By.xpath("//android.view.View[@content-desc=\"" +
                result +
                "\"]");
    }

    By errorMessagePassword(String result){
        return By.xpath("(//android.view.View[@content-desc=\"Please enter your password\"])[" +
                result +
                "]");
    }

    By popUpMessage(){
        return By.xpath("//android.view.View[@content-desc=\"Whoa! Take it easy You will lost your input data to sign up, still want to exit?\"]");
    }

    By yesOrNo(String yesOrNo){
        return By.xpath("//android.widget.Button[@content-desc=\"" +
                yesOrNo +
                "\"]");
    }

    public void validateOnSplashScreen(){
        Assertions.assertTrue(isDisplayed(getStartedButton()));
    }

    public void clickGetStartedButton(){
        click(getStartedButton());
    }

    public void validateOnSignUpPage(){
        Assertions.assertTrue(isDisplayed(signUpButton()));
    }

    public void inputDataForRegister(String username, String email, String phone_number, String password, String confirm_password) throws InterruptedException{
        click(usernameField());
        if (username.equals("new")){
            this.username = general.randomUsername();
            try (FileWriter file = new FileWriter("src//test//resources//filejson//username.json")) {
                file.write(this.username);
                file.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Thread.sleep(3000);
            sendKeys(usernameField(), this.username);
        } else {
            Thread.sleep(3000);
            sendKeys(usernameField(), username);
        }

        click(emailField());
        if (email.equals("new")){
            this.email = general.randomEmail();
            try (FileWriter file = new FileWriter("src//test//resources//filejson//email.json")) {
                file.write(this.email);
                file.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Thread.sleep(3000);
            sendKeys(emailField(), this.email);
        } else {
            Thread.sleep(3000);
            sendKeys(emailField(), email);
        }

        click(phoneNumberField());
        sendKeys(phoneNumberField(), phone_number);

        click(passwordField());
        sendKeys(passwordField(), password);

        click(confirmPasswordField());
        sendKeys(confirmPasswordField(), confirm_password);
    }

    public void clickSignUpButton(){
        click(signUpButton());
    }

    public void validateErrorMessage(String result){
        Assertions.assertTrue(isDisplayed(errorMessage(result)));
    }

    public void validatePopUpShow(){
        Assertions.assertTrue(isDisplayed(popUpMessage()));
    }

    public void clickYesOrNo(String yesOrNo){
        click(yesOrNo(yesOrNo));
    }


}
