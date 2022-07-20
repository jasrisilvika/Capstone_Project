package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import starter.pages.ManageOfflineBookingPage;

public class ManageOfflineBookingSteps {
    ManageOfflineBookingPage offlineBooking;

    @Given("I am on manage offline class booking menu")
    public void iAmOnManageOfflineClassBookingMenu(){
        offlineBooking.openUrl("https://react-front-end-capstone-kel-3.vercel.app/home");
        offlineBooking.maximiseScreen();
        offlineBooking.clickOfflineBookingMenu();
        offlineBooking.validateOnOfflineBookingPage();
    }

    @When("I click button on offline booking {int} {string}")
    public void iClickButtonOnOfflineBookingRow(int row, String button) {
        if (button.equals("delete")){
            offlineBooking.getNameOnListForDelete(row);
        }
        offlineBooking.clickButton(row, button);
    }

    @Then("I validate the popup offline booking show {string}")
    public void iValidateThePopupOfflineBookingShow(String button) {
        offlineBooking.validatePopUpShow(button);
    }

    @Then("I click cancel button on offline booking {string}")
    public void iClickCancelButtonOnOfflineBooking(String button) {
        offlineBooking.clickCancelButton(button);
    }


    @Then("I click confirm delete on offline booking")
    public void iClickConfirmDeleteOnOfflineBooking() {
        offlineBooking.clickConfirmDelete();
    }

    @And("I validate data was deleted {int}")
    public void iValidateDataWasDeletedRow(int row) throws Exception{
        offlineBooking.validateDataWasDeleted(row);
    }

    @Given("I am on manage online class booking menu")
    public void iAmOnManageOnlineClassBookingMenu() {
        offlineBooking.openUrl("https://react-front-end-capstone-kel-3.vercel.app/home");
        offlineBooking.maximiseScreen();
        offlineBooking.clickOnlineBookingMenu();
        offlineBooking.validateOnOnlineBookingPage();
    }
}
