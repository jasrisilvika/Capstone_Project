package com.example.steps;

import com.example.app.pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomeSteps {
    HomePage homepage = new HomePage();

    @When("I click see all class {string}")
    public void iClickSeeAllClass(String category){
        homepage.clickSeeAll(category);
    }

    @Then("All classes will show {string}")
    public void allClassesWillShow(String category){
        homepage.allClassesWillShow(category);
    }

    @And("I choose a class {string} {string}")
    public void iChooseAClass(String classes, String category){
        homepage.iChooseAClass(classes, category);
    }

    @Then("I validate result after view detail {string}")
    public void iValidateResultAfterViewDetail(String classes){
        homepage.iValidateResultAfterViewDetail(classes);
    }

    @And("I click see all available class {string} {string}")
    public void iClickSeeAllAvailableClass(String category, String classes){
        homepage.clickSeeAvailableClass(category, classes);
    }

    @When("I click book now button")
    public void iClickBookNowButton(){
        homepage.iClickBookNowButton();
    }

    @And("I click payment instruction button {string}")
    public void iClickPaymentInstructionButton(String email){
        homepage.clickPaymentInstructionButton(email);
    }

    @Then("I validate the result after booking class")
    public void iValidateTheResultAfterBookingClass(){
        homepage.validateResultAfterBookingClass();
    }

    @When("I click the tips {string}")
    public void iClickTheTips(String tips){
        homepage.iClickTheTips(tips);
    }

    @Then("I validate the result after click tips")
    public void iValidateTheResultAfterClickTips() throws InterruptedException{
        homepage.iValidateTheResultAfterClickTips();
    }

    @When("I click schedule menu")
    public void iClickScheduleMenu(){
        homepage.iClickScheduleMenu();
    }

    @And("I click pay now button")
    public void iClickPayNowButton(){
        homepage.clickPayNowButton();
    }

    @Then("I validate the result after pay the booking")
    public void iValidateTheResultAfterPayTheBooking() throws InterruptedException {
        homepage.iValidateTheResultAfterPayTheBooking();
    }
}
