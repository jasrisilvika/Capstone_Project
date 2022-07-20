package starter.stepdefinitions;

import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_scouse.An;
import net.thucydides.core.annotations.Steps;
import starter.pages.LoginPage;

public class LoginSteps {
    @Steps
    LoginPage loginPage;
    @Given("I am on login page")
    public void iAmOnLoginPage(){
        loginPage.openUrl("https://react-front-end-capstone-kel-3.vercel.app/login");
        loginPage.maximiseScreen();
        loginPage.validateOnLoginPage();
    }

    @When("I input the data for login {string} {string}")
    public void  iInputTheDataForLogin(String username, String password){
        loginPage.inputUsername(username);
        loginPage.inputPassword(password);
    }

    @And("I click login button")
    public void iClickLoginButton(){
        loginPage.clickLoginButton();
    }

//    @Then("I validate the result after login {string}")
//    public void iValidateTheResultAfterLogin(String result){
//
//    }
}
