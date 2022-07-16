package com.example.app.pages;

import com.example.app.base.BasePageObject;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

public class SendUsFeedbackPages extends BasePageObject {
    By star(String star){
        return By.xpath("//android.view.View/android.view.View[2]/android.view.View[" +
                star +
                "]");
    }

    By feedbackField(){
        return By.xpath("//android.view.View[2]/android.widget.EditText");
    }

    By submitButton(){
        return By.xpath("//android.widget.Button[@content-desc=\"Submit\"]");
    }

    By sendUsFeedbackText(){
        return By.xpath("//android.view.View[@content-desc=\"Send us Feedbacks\"]");
    }

    public void validateOnSendUsFeedbacksField() throws InterruptedException{
        Assertions.assertTrue(isDisplayed(sendUsFeedbackText()));
        Thread.sleep(2000);
    }
    public void giveStar(String star){
        click(star("4"));
    }

    public void giveFeedback() throws InterruptedException{
        Thread.sleep(1000);
        click(feedbackField());
        Thread.sleep(2000);
        sendKeys(feedbackField(), "This is a good gym application");
    }

    public void clickSubmitButton(){
        click(submitButton());
    }
}
