package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import starter.pages.ManageOnlineClassPage;

public class ManageOnlineClassSteps {
    ManageOnlineClassPage onlineClassPage;

    @Given("I am on manage online class menu")
    public void iAmOnManageOnlineClassMenu() {
        onlineClassPage.openUrl("https://react-front-end-capstone-kel-3.vercel.app/home");
        onlineClassPage.maximiseScreen();
        onlineClassPage.clickManageOnlineClass();
        onlineClassPage.validateOnManageOnlineClassMenu();
    }

    @When("I click button on online class {int} {string}")
    public void iClickButtonOnOnlineClassRow(int row, String crud_button) {
        if (crud_button.equals("delete")){
            onlineClassPage.getNameOnListForDelete(row);
        }
        onlineClassPage.clickCRUDbutton(crud_button, row);
    }

    @Then("I validate the popup view online class will show")
    public void iValidateThePopupViewOnlineClassWillShow() {
        onlineClassPage.viewOnlineClassPopUpShow();
    }

    @When("I click cancel button on view online class")
    public void iClickCancelButtonOnViewOnlineClass() {
        onlineClassPage.clickCancelOnView();
    }

    @Then("I validate the result after using cancel button on view online classes")
    public void iValidateTheResultAfterUsingCancelButtonOnViewOnlineClasses() {
        onlineClassPage.validateOnManageOnlineClassMenu();
    }

    @And("I click button add on online class {string}")
    public void iClickButtonAddOnOnlineClass(String crud_button) {
        onlineClassPage.clickAddOnOnlineClass();
        onlineClassPage.validateAddOnlineClassPopUpShow(crud_button);
    }

    @When("I input the data for add new online class {string} {string} {string} {int} {string} {int} {string} {string} {string}")
    public void iInputTheDataForAddNewOnlineClassTimePrice(String name_class, String trainer, String date, int time, String location, int price, String desc, String result, String crud_button) {
        onlineClassPage.inputDataForAddOnlineClass(name_class, trainer, date, time, location, price, desc, result, crud_button);
    }

    @And("I click save button on online class {string}")
    public void iClickSaveButtonOnOnlineClass(String crud_button) {
        onlineClassPage.clickSaveButton(crud_button);
    }

    @Then("I validate the result after create new online class {string}")
    public void iValidateTheResultAfterCreateNewOnlineClass(String result) {
        if (result.equals("success")){
            onlineClassPage.validateOnManageOnlineClassMenu();
        }
    }

    @When("I input the data for edit online class {string} {string} {string} {int} {string} {int} {string} {string} {string}")
    public void iInputTheDataForEditOnlineClassTimePrice(String name_class, String trainer, String date, int time, String location, int price, String desc, String result, String crud_button) {
        onlineClassPage.inputDataForEditOnlineClass(name_class, trainer, date, time, location, price, desc, result, crud_button);
    }

    @Then("I validate the result after edit online class {string} {int} {string}")
    public void iValidateTheResultAfterEditOnlineClassRow(String result, int row, String name_class) {
        onlineClassPage.validateResultAfterEditOnlineClass(result, row, name_class);
    }

    @And("I validate the confirm delete online class show")
    public void iValidateTheConfirmDeleteOnlineClassShow() {
        onlineClassPage.validateConfirmDeletePopUpShow();
    }

    @And("I click confirm delete on online class")
    public void iClickConfirmDeleteOnOnlineClass() {
        onlineClassPage.clickConfirmButton();
    }

    @Then("I validate the online class successfully deleted {int}")
    public void iValidateTheOnlineClassSuccessfullyDeletedRow(int row) throws Exception{
        onlineClassPage.validateDataWasDeletedSuccessfully(row);
    }

    @And("I validate the popup online class show {string}")
    public void iValidateThePopupOnlineClassShow(String crud_button) {
        if (crud_button.equals("edit")){
            onlineClassPage.editPopUpShow();
        } else if(crud_button.equals("delete")){
            onlineClassPage.validateConfirmDeletePopUpShow();
        }
    }

    @When("I click cancel button online class {string}")
    public void iClickCancelButtonOnlineClass(String crud_button) {
        onlineClassPage.clickCancelButton(crud_button);
    }

    @Then("I validate the result after cancel online button")
    public void iValidateTheResultAfterCancelOnlineButton() {
        onlineClassPage.validateOnManageOnlineClassMenu();
    }
}
