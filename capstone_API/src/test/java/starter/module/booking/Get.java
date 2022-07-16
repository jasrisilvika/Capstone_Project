package starter.module.booking;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static org.hamcrest.CoreMatchers.equalTo;

public class Get {
    String bookingId;
    String userIdAfterBooking;
    protected static String base_url = "https://capstone-kelompok-3.herokuapp.com";

    @Step("I set an endpoint for GET booking {string}")
    public String iSetAnEndpointForGETBooking(String book){
        if (book.equals("all")){
            return base_url + "/booking";
        } else if(book.equals("before")){
            return base_url + "/booking/false";
        } else {
            return base_url + "/booking/true";
        }
    }

    @Step("I request GET booking {string}")
    public void iRequestGETBooking(String book){
        SerenityRest.given().when().get(iSetAnEndpointForGETBooking(book));
    }

    @Step("I validate the result after GET booking {string}")
    public void iValidateTheResultAfterGETBooking(String book){
        SerenityRest.then().body("success", equalTo(true));
        if (book.equals("all")){
            SerenityRest.then().body("message", equalTo("Get All Booking"));
        } else if (book.equals("before")){
            SerenityRest.then().body("message", equalTo("Booking before ACC"));
        } else {
            SerenityRest.then().body("message", equalTo("Booking Accepted"));
        }
    }

    @Step("I set an endpoint for GET booking by id")
    public String iSetAnEndpointForGETBookingById(String bookingId){
        return base_url + "/booking/" + bookingId;
    }

    @Step("I request GET booking by id {string}")
    public void iRequestGETBookingById(String result) throws Exception{
        if (result.equals("success")){
            this.bookingId = FileUtils.readFileToString(new File(System.getProperty("user.dir") + "//src//test//resources//filejson//bookingId.json"), StandardCharsets.UTF_8);
        } else if (result.equals("failed")){
            this.bookingId = "123";
        }


        SerenityRest.given().when().get(iSetAnEndpointForGETBookingById(this.bookingId));
    }

    @Step("I validate the result after get booking by id {string}")
    public void iValidateTheResultAfterGETBookingById(String result) throws Exception{
        if (result.equals("success")){
            this.bookingId = FileUtils.readFileToString(new File(System.getProperty("user.dir") + "//src//test//resources//filejson//bookingId.json"), StandardCharsets.UTF_8);
            SerenityRest.then().body("success", equalTo(true));
            SerenityRest.then().body("message", equalTo("Get Booking " + bookingId));
        } else {
            this.bookingId = "123";
            SerenityRest.then().body("success", equalTo(false));
            SerenityRest.then().body("message", equalTo(" Failed to get Booking " + bookingId));
        }
    }

    @Step("I validate the result after GET booking {string}")
    public String getBookingIdBfrAcc(){
        Response response = SerenityRest.lastResponse();
        String bookingIdBfrAcc = response.body().path("data[0].id").toString();
        try (FileWriter file = new FileWriter("src//test//resources//filejson//bookingIdBfrAcc.json")) {
            file.write(bookingIdBfrAcc);
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(bookingIdBfrAcc);
        return bookingIdBfrAcc;
    }

    @Step("I validate the result after GET booking {string}")
    public String getUserIdAfterBooking(){
        Response response = SerenityRest.lastResponse();
        String userIdAfterBooking = response.body().path("data[4].idUser.id").toString();
        try (FileWriter file = new FileWriter("src//test//resources//filejson//userIdAfterBooking.json")) {
            file.write(userIdAfterBooking);
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(userIdAfterBooking);
        return userIdAfterBooking;
    }

    @Step("I set an endpoint for GET booking by user id")
    public String iSetAnEndpointForGETBookingByUserId(String userIdAfterBooking){
        return base_url + "/booking/iduser/" + userIdAfterBooking;
    }

    @Step("I request GET booking by user id {string}")
    public void iRequestGETBookingByUserId(String result) throws Exception{
        if (result.equals("success")){
            this.userIdAfterBooking = FileUtils.readFileToString(new File(System.getProperty("user.dir") + "//src//test//resources//filejson//userIdAfterBooking.json"), StandardCharsets.UTF_8);
        } else if (result.equals("failed")){
            this.userIdAfterBooking = "664";
        }

        SerenityRest.given().when().get(iSetAnEndpointForGETBookingByUserId(this.userIdAfterBooking));
    }

    @Step("I validate the result after GET booking by user id {string}")
    public void iValidateResultAfterGETBookingByUserId(String result){
        SerenityRest.then().body("success", equalTo(true));
        if (result.equals("success")){
            SerenityRest.then().body("message", equalTo("Get Booking Class By User ID"));
        } else if (result.equals("failed")){
            this.userIdAfterBooking = "664";
            SerenityRest.then().body("message", equalTo(" Id User " +
                    this.userIdAfterBooking +
                    " not Available "));
        }
    }

}
