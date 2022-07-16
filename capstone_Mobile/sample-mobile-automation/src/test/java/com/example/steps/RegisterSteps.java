package com.example.steps;

import com.example.app.pages.HomePage;
import com.example.app.pages.LoginPage;
import com.example.app.pages.ProfilePage;
import com.example.app.pages.RegisterPage;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegisterSteps {
    RegisterPage register = new RegisterPage();
    HomePage homePage = new HomePage();
    LoginPage login = new LoginPage();
    ProfilePage profilePage = new ProfilePage();

    @Given("I am on splash screen")
    public void iAmOnSplashScreen(){
        register.validateOnSplashScreen();
    }

    @And("I click get started button")
    public void iClickGetStartedButton(){
        register.clickGetStartedButton();
        register.clickGetStartedButton();
        register.clickGetStartedButton();
    }

    @When("I input the data for register {string} {string} {string} {string} {string}")
    public void iInputTheDataForRegister(String username, String email, String phone_number, String password, String confirm_password) throws InterruptedException{
        register.inputDataForRegister(username, email, phone_number, password, confirm_password);
    }

    @And("I click sign up button")
    public void iClickSignUpButton(){
        register.clickSignUpButton();
    }

    @Then("I validate result after register {string}")
    public void iValidateResultAfterRegister(String result){
        if (result.equals("success")){
            homePage.validateOnHomePage();
        } else{
            register.validateErrorMessage(result);
        }
    }


    @Then("I go to sign up page")
    public void iGoToSignUpPage(){
        register.validateOnSignUpPage();
    }

    @Then("Pop Up message will show")
    public void popUpMessageWillShow(){
        register.validatePopUpShow();
    }

    @And("I click yes or no {string}")
    public void iClickYesOrNo(String yesOrNo){
        register.clickYesOrNo(yesOrNo);
    }

    @Then("I validate the result after yes or no {string}")
    public void iValidateTheResultAfterYesOrNo(String yesOrNo){
        if (yesOrNo.equals("Yes")){
            login.validateOnLoginPage();
        } else if (yesOrNo.equals("No")){
            register.validateOnSignUpPage();
        } else {
            profilePage.validateOnProfilePage();
        }
    }
}
