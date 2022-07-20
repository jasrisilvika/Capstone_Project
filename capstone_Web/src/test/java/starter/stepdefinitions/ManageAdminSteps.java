package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.ManageAdminPage;

public class ManageAdminSteps {
    @Steps
    ManageAdminPage manageAdminPage;
    @Given("I am on manage admin menu")
    public void iAmOnManageAdminMenu(){
        manageAdminPage.openUrl("https://react-front-end-capstone-kel-3.vercel.app/home");
        manageAdminPage.maximiseScreen();
        manageAdminPage.clickManageAdminMenu();
        manageAdminPage.validateOnManageAdminMenu();
    }

    @When("I click view button {int}")
    public void iCLickViewButton(int row){
            manageAdminPage.clickViewButton(row);

    }

    @Then("The view admin popup will show")
    public void theViewAdminPopupWillShow(){
        manageAdminPage.validatePopUpViewAdmin();
    }

    @And("I click new button")
    public void iClickNewButton() {
        manageAdminPage.clickNewButton();
        manageAdminPage.validatePopUpAddAdmin();
    }

    @When("I click cancel button")
    public void iClickCancelButton(){
//        manageAdminPage.scroll();
//        manageAdminPage.validateOnManageAdminMenu();
        manageAdminPage.clickCancelOnView();
    }

    @Then("The view admin popup will disappear")
    public void theViewAdminPopupWillDisappear() {
        manageAdminPage.validateOnManageAdminMenu();
    }

    @And("I click cancel button on view")
    public void iClickCancelButtonOnView() {
        manageAdminPage.clickCancelOnView();
        manageAdminPage.validateOnManageAdminMenu();
    }


    @And("I click save button {string}")
    public void iClickSaveButton(String feature) {
        manageAdminPage.clickSaveButton(feature);
    }

    @Then("I validate the result after create new admin {string}")
    public void iValidateTheResultAfterCreateNewAdmin(String result) {
        manageAdminPage.validateAfterAddAdmin(result);
    }

    @When("I input the data {string} {string} {string} {string} {string} {string}")
    public void iInputTheData(String name, String username, String password, String email, String phone_number, String feature) {
        manageAdminPage.inputData(name, username, password, email, phone_number, feature);
    }

    @And("I click edit button {int}")
    public void iClickEditButton(int row) {
        manageAdminPage.clickEdit(row);
        manageAdminPage.validateEditModal();
    }

    @Then("I validate the result after edit admin {int} {string}")
    public void iValidateTheResultAfterEditAdmin(int row, String name) {
        manageAdminPage.validateResultAfterEditAdmin(row);
    }

    @When("I click delete button {int}")
    public void iClickDeleteButtonRow(int row) {
        manageAdminPage.getNameOnListForDelete(row);
        manageAdminPage.clickDelete(row);
    }

    @And("I validate the confirm delete show {int}")
    public void iValidateTheConfirmDeleteShow(int row) {
        manageAdminPage.validateConfirmDeleteModal(row);
    }

    @And("I click confirm delete button")
    public void iClickConfirmDeleteButton() {
        manageAdminPage.clickConfirmDelete();
    }

    @Then("I validate the data was deleted successfully {int}")
    public void iValidateTheDataWasDeletedSuccessfullyRow(int row) throws Exception{
        manageAdminPage.validateDataWasDeleteSuccessfully(row);
    }


    @When("I click cancel button on confirm delete")
    public void iClickCancelButtonOnConfirmDelete() {
        manageAdminPage.clickCancelButtonOnConfirmDelete();
    }

    @Then("I validate the confirm pup up will disappear")
    public void iValidateTheConfirmPupUpWillDisappear() {
        manageAdminPage.validateOnManageAdminMenu();
    }

    @When("I click button {int} {string}")
    public void iClickButtonRow(int row, String button) {
        manageAdminPage.clickButton(row, button);
    }

    @Then("The popup will show {string}")
    public void thePopupWillShow(String button) {
        manageAdminPage.validatePopUpShow(button);
    }

    @And("I click cancel button {string}")
    public void iClickCancelButton(String button) {
        manageAdminPage.clickCancel(button);
        manageAdminPage.validateOnManageAdminMenu();
    }

    @When("I input the data for invalid {string} {string} {string} {string} {string} {string}")
    public void iInputTheDataForInvalid(String name, String username, String password, String email, String phone_number, String feature) {
//        manageAdminPage.inputName(name, feature);
        manageAdminPage.inputForEditAdmin(name, username, password, email, phone_number, feature);

    }


    @When("I input the data for edit {string} {string} {string} {string} {string} {string}")
    public void iInputTheDataForEdit(String name, String username, String password, String email, String phone_number, String feature) {
        manageAdminPage.inputForEditAllValidData(name, username, password, email, phone_number, feature);
    }

    @Then("I validate the result after edit admin not valid {string}")
    public void iValidateTheResultAfterEditAdminNotValid(String result){
        manageAdminPage.validateTheResultAfterEditAdminNotValid(result);
    }
}
