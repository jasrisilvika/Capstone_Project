package com.example.steps;

import com.example.app.pages.ProfilePage;
import com.example.app.pages.SendUsFeedbackPages;
import com.example.app.pages.UpdatePasswordPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Tag;

public class ProfileSteps {
    UpdatePasswordPage updatePassword = new UpdatePasswordPage();
    ProfilePage profilePage = new ProfilePage();
    SendUsFeedbackPages sendUsFeedbacks = new SendUsFeedbackPages();

    @When("I click submenu on profile page {string}")
    public void iClickSubmenuOnProfileMenu(String btn){
        profilePage.clickButtonOnProfilePage(btn);
    }

    @Then("I validate the result after click submenu {string} {string}")
    public void iValidateTheResultAfterClickSubmenu(String btn, String email) throws InterruptedException{
        if (btn.equals("Personal Details")) {
            profilePage.validateOnPersonalDetail(email);
        } else if (btn.equals("Payment Instruction")){
            profilePage.validateOnPaymentInstruction();
        } else if (btn.equals("Terms & Conditions")){
            profilePage.validateOnTnC();
        } else if (btn.equals("FAQ")){
            profilePage.validateOnFAQ();
        } else if (btn.equals("Send us Feedbacks")){
            sendUsFeedbacks.validateOnSendUsFeedbacksField();
            sendUsFeedbacks.giveStar("4");
            sendUsFeedbacks.giveFeedback();
            sendUsFeedbacks.clickSubmitButton();
        }
    }

    @Then("I input data for update password {string} {string} {string} {string} {string}")
    public void iInputDataForUpdatePassword(String current, String newPass, String confirm, String password, String result) throws InterruptedException{
        updatePassword.inputDataForUpdatePassword(current, newPass, confirm, password, result);
    }

    @And("I validate the result after click submenu update password {string}")
    public void iValidateTheResultAfterClickSubmenuUpdatepassword(String result){
        updatePassword.validateResultAfterUpdatePassword(result);
    }
}
