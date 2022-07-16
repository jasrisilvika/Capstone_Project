package com.example.app.pages;
import com.example.app.base.BasePageObject;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

public class ProfilePage extends BasePageObject {
    By logoutButton(){
        return By.xpath("//android.widget.ImageView[@content-desc=\"Logout\"]");
    }

    By popUpLogout(){
        return By.xpath("//android.view.View[@content-desc=\"Log out? You sure want to log out and go to the login screen?\"]");
    }

    By buttonOnProfilePage(String btn){
        return By.xpath("//android.widget.ImageView[@content-desc=\"" +
                btn +
                "\"]");
    }


    By emailOnPersonalDetail(String email){
        return By.xpath("//android.view.View[@content-desc=\"" +
                email +
                "\"]");
    }

    By personalDetailText(){
        return By.xpath("//android.view.View[@content-desc=\"Personal Details\"]");
    }

    By paymentInstructionText(){
        return By.xpath("//android.view.View[@content-desc=\"Payment Instruction\"]");
    }

    By paymentInstructionExpand(){
        return By.xpath("//android.view.View[@content-desc=\"ATM Transfer Instruction\"]");
    }

    By paymentInstructionExpanded(){
        return By.xpath("//android.widget.ScrollView/android.view.View");
    }

    By TnCText(){
        return By.xpath("//android.view.View[@content-desc=\"Terms and Conditions\"]");
    }

    By FAQText(){
        return By.xpath("//android.view.View[@content-desc=\"FAQ\"]");
    }

    By FAQ1Text(){
        return By.xpath("//android.view.View[@content-desc=\"What is A-A Gym?\"]");
    }

    By FAQ2Text(){
        return By.xpath("//android.view.View[@content-desc=\"Is the trainer professional?\"]");
    }

    By FAQ3Text(){
        return By.xpath( "//android.view.View[@content-desc=\"How to book?\"]");
    }

    By FAQ4Text(){
        return By.xpath("//android.view.View[@content-desc=\"How to joined class from home?\"]");
    }

    By progressButton(){
        return By.xpath("//android.widget.Button[@content-desc=\"Progress\"]");
    }
    public void clickLogoutButton(){
        swipeScreen(Direction.UP);
        click(logoutButton());
    }

    public void validatePopUpLogout(){
        Assertions.assertTrue(isDisplayed(popUpLogout()));
    }

    public void validateOnProfilePage(){
        Assertions.assertTrue(isDisplayed(logoutButton()));
    }

    public void clickButtonOnProfilePage(String btn){
        click(buttonOnProfilePage(btn));
    }

    public void validateOnPersonalDetail(String email){
        Assertions.assertTrue(isDisplayed(personalDetailText()));
        Assertions.assertTrue(isDisplayed(emailOnPersonalDetail(email)));
    }

    public void validateOnPaymentInstruction(){
        Assertions.assertTrue(isDisplayed(paymentInstructionText()));
        click(paymentInstructionExpand());
        Assertions.assertTrue(isDisplayed(paymentInstructionExpanded()));
    }

    public void validateOnTnC(){
        Assertions.assertTrue(isDisplayed(TnCText()));
    }

    public void validateOnFAQ(){
        click(FAQ1Text());
        click(FAQ2Text());
        click(FAQ3Text());
        click(FAQ4Text());
    }

    public void clickProgressButton(){
        click(progressButton());
    }

}
