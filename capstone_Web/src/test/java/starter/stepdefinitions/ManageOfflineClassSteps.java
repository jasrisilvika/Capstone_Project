package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.ManageOfflineClassPage;

public class ManageOfflineClassSteps {
    @Steps
    ManageOfflineClassPage offlineClassPage;

    @Given("I am on manage offline class menu")
    public void iAmOnManageOfflineClassMenu(){
        offlineClassPage.openUrl("https://react-front-end-capstone-kel-3.vercel.app/home");
        offlineClassPage.maximiseScreen();
        offlineClassPage.clickManageOfflineClass();
        offlineClassPage.validateOnManageOfflineClassMenu();
    }

    @When("I click button on offline class {int} {string}")
    public void iClickViewButtonOnOfflineClass(int row, String crud_button){
        if (crud_button.equals("delete")){
            offlineClassPage.getNameOnListForDelete(row);
        }
        offlineClassPage.clickCRUDbutton(crud_button, row);
    }

    @Then("I validate the popup view offline class will show")
    public void iValidateThePopupViewOfflineClassWillShow(){
        offlineClassPage.viewOfflineClassPopUpShow();
    }

    @When("I click cancel button on view offline class")
    public void iClickCancelButtonOnViewOfflineClass() {
        offlineClassPage.clickCancelOnView();
    }

    @Then("I validate the result after using cancel button on view offline classes")
    public void iValidateTheResultAfterUsingCancelButtonOnViewOfflineClasses() {
        offlineClassPage.validateOnManageOfflineClassMenu();
    }

    @And("I click button add on offline class {string}")
    public void iClickButtonOnOfflineClassRow(String crud_button) {
        offlineClassPage.clickAddOnOfflineClass();
        offlineClassPage.validateAddOfflineClassPopUpShow(crud_button);
    }

    @When("I input the data for add new offline class {string} {string} {string} {int} {string} {int} {string} {string} {string}")
    public void iInputTheDataForAddNewOfflineClassTimePrice(String name_class, String trainer, String date, int time, String location, int price, String desc, String result, String crud_button) {
        offlineClassPage.inputDataForAddOfflineClass(name_class, trainer, date, time, location, price, desc, result, crud_button);
    }

    @And("I click save button on offline class {string}")
    public void iClickSaveButtonOnOfflineClass(String crud_button) {
        offlineClassPage.clickSaveButton(crud_button);
    }

    @Then("I validate the result after create new offline class {string}")
    public void iValidateTheResultAfterCreateNewOfflineClass(String result) {
        if (result.equals("success")){
            offlineClassPage.validateOnManageOfflineClassMenu();
        }

    }

    @When("I input the data for edit offline class {string} {string} {string} {int} {string} {int} {string} {string} {string}")
    public void iInputTheDataForEditOfflineClassTimePrice(String name_class, String trainer, String date, int time, String location, int price, String desc, String result, String crud_button) {
        offlineClassPage.inputDataForEditOfflineClass(name_class, trainer, date, time, location, price, desc, result, crud_button);
    }

    @Then("I validate the result after edit offline class {string} {int} {string}")
    public void iValidateTheResultAfterEditOfflineClassRow(String result, int row, String name_class) {
        offlineClassPage.validateResultAfterEditOfflineClass(result, row, name_class);
    }

    @And("I validate the confirm delete show")
    public void iValidateTheConfirmDeleteShow() {
        offlineClassPage.validateConfirmDeletePopUpShow();
    }

    @And("I click confirm delete on offline class")
    public void iClickConfirmDeleteOnOfflineClass() {
        offlineClassPage.clickConfirmButton();
    }

    @Then("I validate the offline class successfully deleted {int}")
    public void iValidateTheOfflineClassSuccessfullyDeleted(int row) throws Exception{
        offlineClassPage.validateDataWasDeletedSuccessfully(row);
    }

    @And("I validate the popup offline class show {string}")
    public void iValidateThePopupOfflineClassShow(String crud_button) {
        if (crud_button.equals("edit")){
            offlineClassPage.editPopUpShow();
        } else if(crud_button.equals("delete")){
            offlineClassPage.validateConfirmDeletePopUpShow();
        }
    }

    @When("I click cancel button offline class {string}")
    public void iClickCancelButtonOfflineClass(String crud_button) {
        offlineClassPage.clickCancelButton(crud_button);
    }

    @Then("I validate the result after cancel offline button")
    public void iValidateTheResultAfterCancelOfflineButton() {
        offlineClassPage.validateOnManageOfflineClassMenu();
    }

}
