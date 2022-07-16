package starter.stepdefinitions;

import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_scouse.An;
import starter.module.booking.Get;
import starter.module.booking.Post;
import starter.module.booking.Put;

public class BookingSteps {

    Post post = new Post();
    Get get = new Get();
    Put put = new Put();

    String bookingId, bookingIdBfrAcc, userIdAfterBooking;

    @Given("I set an endpoint for POST create booking")
    public void iSetAndEndpointForPOSTCreateBooking(){
        post.iSetAndEndpointForPOSTCreateBooking();
    }

    @When("I request POST create booking {string}")
    public void iRequestPOSTCreateBooking(String result) throws Exception{
        post.iRequestPOSTCreateBooking(result);
    }

    @And("I validate the result after POST create booking {string}")
    public void iValidateTheResultAfterPOSTCreateBooking(String result){
        post.iValidateTheResultAfterPOSTCreateBooking(result);
    }

    @And("I get a booking id for other request {string}")
    public void iGetABookingIdForOtherRequest(String result){
        if (result.equals("integration")){
            this.bookingId = post.iGetABookingIdForOtherRequest();
        }
    }

    @Given("I set an endpoint for GET booking {string}")
    public void iSetAnEndpointForGETBooking(String book){
        get.iSetAnEndpointForGETBooking(book);
    }

    @When("I request GET booking {string}")
    public void iRequestGETBooking(String book){
        get.iRequestGETBooking(book);
    }

    @And("I validate the result after GET booking {string}")
    public void iValidateTheResultAfterGETBooking(String book){
        get.iValidateTheResultAfterGETBooking(book);
        if (book.equals("before")){
            this.bookingIdBfrAcc = get.getBookingIdBfrAcc();
        } else if (book.equals("all")){
            this.userIdAfterBooking = get.getUserIdAfterBooking();
        }
    }

    @Given("I set an endpoint for GET booking by id")
    public void iSetAnEndpointForGETBookingById(){
        get.iSetAnEndpointForGETBookingById(this.bookingId);
    }

    @When("I request GET booking by id {string}")
    public void iRequestGETBookingById(String result) throws Exception{
        get.iRequestGETBookingById(result);
    }

    @And("I validate the result after get booking by id {string}")
    public void iValidateTheResultAfterGETBookingById(String result) throws Exception{
        get.iValidateTheResultAfterGETBookingById(result);
    }

    @Given("I set an endpoint for PUT accept class")
    public void iSetAnEndpointForPUTAcceptClass(){
        put.iSetAnEndpointForPUTAcceptClass(bookingIdBfrAcc);
    }

    @When("I request PUT accept class {string}")
    public void iRequestPUTAcceptClass(String result) throws Exception{
        put.iRequestPUTAcceptClass(result);
    }

    @And("I validate the {string} after PUT accept class")
    public void iValidateResultAfterAcceptClass(String result){
        put.iValidateResultAfterAcceptClass(result);
    }

    @Given("I set an endpoint for GET booking by user id")
    public void iSetAnEndpointForGETBookingByUserId(){
        get.iSetAnEndpointForGETBookingByUserId(this.userIdAfterBooking);
    }

    @When("I request GET booking by user id {string}")
    public void iRequestGETBookingByUserId(String result) throws Exception{
        get.iRequestGETBookingByUserId(result);
    }

    @And("I validate the result after GET booking by user id {string}")
    public void iValidateResultAfterGETBookingByUserId(String result){
        get.iValidateResultAfterGETBookingByUserId(result);
    }
}
