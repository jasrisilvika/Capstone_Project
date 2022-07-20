package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import starter.pages.ManageMembershipPage;

public class ManageMembershipSteps {
    ManageMembershipPage membershipPage;

    @Given("I am on manage membership menu")
    public void iAmOnManageMembershipMenu(){
        membershipPage.openUrl("https://react-front-end-capstone-kel-3.vercel.app/home");
        membershipPage.maximiseScreen();
        membershipPage.clickMembershipMenu();
        membershipPage.validateOnMembershipPage();
    }

    @When("I click button on membership menu {int} {string}")
    public void iClickButtonOnMembershipMenuRow(int row, String vd_button) {
        if (vd_button.equals("delete")){
            membershipPage.getNameOnListForDelete(row);
        }
        membershipPage.clickVDButton(row, vd_button);
    }

    @Then("I validate the popup membership show {string}")
    public void iValidateThePopupMembershipShow(String vd_button) {
        membershipPage.validatePopUpShow(vd_button);
    }

    @Then("I click cancel button on membership {string}")
    public void iClickCancelButtonOnMembership(String vd_button) {
        membershipPage.clickCancelButton(vd_button);
    }

    @Then("I click confirm delete on membership")
    public void iClickConfirmDeleteOnMembership() {
        membershipPage.clickConfirmDelete();
    }

    @And("I validate data membership was deleted {int}")
    public void iValidateDataMembershipWasDeletedRow(int row) throws Exception{
        membershipPage.validateDataWasDeleted(row);

    }
}
