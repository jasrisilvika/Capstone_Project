package com.example.app.pages;

import com.example.app.base.BasePageObject;
import io.appium.java_client.MobileBy;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

public class LoginPage extends BasePageObject {
    String password;
    By loginButtonRegister() {
        return By.xpath("//android.widget.Button[@content-desc=\"Log in\"]");
    }

    By loginButtonLogin() {
        return By.xpath("//android.widget.Button[@content-desc=\"Login\"]");
    }

    By emailField() {
        return By.xpath("//android.view.View/android.widget.EditText[1]");
    }

    By passwordField() {
        return By.xpath("//android.view.View/android.widget.EditText[2]");
    }

    By errorMessage(String result) {
        return By.xpath("//android.view.View[@content-desc=\"" +
                result +
                "\"]");
    }

    By rememberMeButton(){
        return By.xpath("//android.view.View[@content-desc=\"Remember Me\"]");
    }

    public void clickLoginButtonOnRegister(){

        getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//        swipeVertical();
        swipeScreen(Direction.UP);
        click(loginButtonRegister());

    }

    public void clickLoginButtonLogin(){
        click(loginButtonLogin());
    }

    public void inputDataLogin(String email, String password) throws InterruptedException, IOException {

        Thread.sleep(2000);
        click(emailField());
        Thread.sleep(2000);
        sendKeys(emailField(), email);


        click(passwordField());
        Thread.sleep(2000);
        if (password.equals("new")) {
            this.password = FileUtils.readFileToString(new File(System.getProperty("user.dir") + "//src//test//resources//filejson//newPassword.json"), StandardCharsets.UTF_8) ;
            sendKeys(passwordField(), this.password);
        } else {
            sendKeys(passwordField(), password);
        }


//        Assertions.assertTrue(isDisplayed(emailField()));
//        Assertions.assertTrue(isDisplayed(passwordField()));
    }

    public void validateOnLoginPage(){
        Assertions.assertTrue(isDisplayed(loginButtonLogin()));
    }

    public void validateDataAfterLogin(String result){
        if (result.equals("failed")){
            Assertions.assertTrue(isDisplayed(loginButtonLogin()));
        } else if(result.equals("two")){
            Assertions.assertTrue(isDisplayed(errorMessage("Please enter your email address")));
            Assertions.assertTrue(isDisplayed(errorMessage("Please enter your password")));
        } else {
            Assertions.assertTrue(isDisplayed(errorMessage(result)));
        }
    }

    public void clickRememberMe(){
        click(rememberMeButton());
    }


}
