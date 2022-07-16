package com.example.steps;

import com.example.app.pages.HomePage;
import com.example.app.pages.LoginPage;
import com.example.app.pages.ProfilePage;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

public class LoginSteps {
    LoginPage login = new LoginPage();
    HomePage homePage = new HomePage();
    ProfilePage profilePage = new ProfilePage();

    @And("I click login button on register")
    public void iClickLoginButtonRegister() {
        login.clickLoginButtonOnRegister();
    }

    @And("I click login button on login")
    public void iClickLoginButtonLogin() {
        login.validateOnLoginPage();
        login.clickLoginButtonLogin();
    }

    @When("I input the data for login {string} {string}")
    public void iInputTheDataForLogin(String email, String password) throws InterruptedException, IOException {
        login.inputDataLogin(email, password);
    }

    @Then("I validate the result after login {string}")
    public void iValidateTheResultAfterLogin(String result) {
        if (result.equals("success")) {
            homePage.validateOnHomePage();
        } else {
            login.validateDataAfterLogin(result);
        }
    }

    @And("I click remember me button")
    public void iClickRememberMeButton(){
        login.clickRememberMe();
    }


    @And("I click profile button")
    public void iClickProfileButton(){
        homePage.clickProfilButton();
        profilePage.validateOnProfilePage();
    }

    @And("I click logout button")
    public void iClickLogoutButton(){
        profilePage.clickLogoutButton();
//        profilePage.validatePopUpLogout();
    }

}
