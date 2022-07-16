package com.example.app.pages;

import com.example.app.Utils.General;
import com.example.app.base.BasePageObject;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import java.io.FileWriter;
import java.io.IOException;

public class UpdatePasswordPage extends BasePageObject {
    String currentPass, newPassword;
    General general = new General();
    By updatePasswordText(){
        return By.xpath("//android.view.View[@content-desc=\"Update Password\"]");
    }

    By currentPasswordField(){
        return By.xpath("//android.view.View/android.view.View[1]/android.view.View[2]/android.widget.EditText[1]");
    }

    By newPasswordField(){
        return By.xpath("//android.view.View/android.view.View[1]/android.view.View[2]/android.widget.EditText[2]");
    }

    By confirmPasswordField(){
        return By.xpath("//android.view.View/android.view.View[1]/android.view.View[2]/android.widget.EditText[3]");
    }

    By continueButton(){
        return By.xpath("//android.widget.Button[@content-desc=\"Continue\"]");
    }

    By successUpdatePasswordPopUp(){
        return By.xpath("//android.widget.Button[@content-desc=\"Return to profile screen\"]");
    }

    By errorMessageNullField(String row){
        return By.xpath("//android.widget.ScrollView/android.widget.EditText[" +
                row +
                "]/android.view.View");
    }

    By errorMessage(String result){
        return By.xpath("//android.view.View[@content-desc=\"" +
                result +
                "\"]");
    }

    public void validateOnUpdatePasswordPage(){
        Assertions.assertTrue(isDisplayed(updatePasswordText()));
    }

    public void inputDataForUpdatePassword(String current, String newPass, String confirm, String password, String result) throws InterruptedException{

        if (current.equals("true")){
            this.currentPass =  password;
        } else if(result.equals("crntNull")) {
            this.currentPass = current;
        } else {
            this.currentPass = "ABCDefgh1234";
        }
        click(currentPasswordField());
        Thread.sleep(3000);
        sendKeys(currentPasswordField(), this.currentPass);

        if (newPass.equals("new")){
            this.newPassword = general.randomPassword();
        } else{
            this.newPassword = newPass;
        }
        click(newPasswordField());
        Thread.sleep(3000);
        sendKeys(newPasswordField(), this.newPassword);

        if (result.equals("success")){
            try (FileWriter file = new FileWriter("src//test//resources//filejson//newPassword.json")) {
                file.write(this.newPassword);
                file.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Thread.sleep(3000);
        }
        click(confirmPasswordField());
        Thread.sleep(3000);
        if (newPass.equals("new")){
            sendKeys(confirmPasswordField(), this.newPassword);
        } else{
            sendKeys(confirmPasswordField(), confirm);
        }

        click(continueButton());

    }

    public void validateResultAfterUpdatePassword(String result){
        if (result.equals("success")){
            Assertions.assertTrue(isDisplayed(successUpdatePasswordPopUp()));
            click(successUpdatePasswordPopUp());
        } else if (result.equals("crntNull")){
            Assertions.assertTrue(isDisplayed(errorMessage("Please enter your password")));
        }
        else {
            Assertions.assertTrue(isDisplayed(errorMessage(result)));
        }
    }
}
