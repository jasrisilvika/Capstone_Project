package starter.module.booking;


import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Post {
    private String classId, userId;
    protected static String base_url = "https://capstone-kelompok-3.herokuapp.com";

    @Step("I set an endpoint for POST create booking")
    public String iSetAndEndpointForPOSTCreateBooking(){
        return base_url + "/booking";
    }

    @Step("I request POST create booking {string}")
    public JSONObject iRequestPOSTCreateBooking(String result) throws Exception{
        JSONObject reqData = new JSONObject();
        Map<String, String> idClass = new HashMap<>();
        Map<String, String> idUser = new HashMap<>();
        if (result.equals("integration")){
            this.classId = FileUtils.readFileToString(new File(System.getProperty("user.dir") + "//src//test//resources//filejson//idClassForPost.json"), StandardCharsets.UTF_8);
            this.userId = FileUtils.readFileToString(new File(System.getProperty("user.dir") + "//src//test//resources//filejson//userId.json"), StandardCharsets.UTF_8) ;
//            this.userId = "15";
        } else if(result.equals("invalidCLassId")){
            this.classId = "12";
            this.userId = FileUtils.readFileToString(new File(System.getProperty("user.dir") + "//src//test//resources//filejson//userId.json"), StandardCharsets.UTF_8) ;
        } else if (result.equals("nullClassId")){
            this.classId = null;
            this.userId = FileUtils.readFileToString(new File(System.getProperty("user.dir") + "//src//test//resources//filejson//userId.json"), StandardCharsets.UTF_8) ;
        } else if (result.equals("invalidUserId")){
            this.classId = FileUtils.readFileToString(new File(System.getProperty("user.dir") + "//src//test//resources//filejson//idClassForPost.json"), StandardCharsets.UTF_8);
            this.userId = "12";
        } else if (result.equals("nullUserId")){
            this.classId = FileUtils.readFileToString(new File(System.getProperty("user.dir") + "//src//test//resources//filejson//idClassForPost.json"), StandardCharsets.UTF_8);
            this.userId = null;
        }
        idClass.put("id", this.classId);
        idUser.put("id", this.userId);
        reqData.put("classId", idClass);
        reqData.put("idUser", idUser);

        SerenityRest.given().header("Content-Type", "application/json")
                .body(reqData.toJSONString())
                .when().post(iSetAndEndpointForPOSTCreateBooking());

        return reqData;
    }

    @Step("I validate the result after POST create booking {string}")
    public void iValidateTheResultAfterPOSTCreateBooking(String result){
        if (result.equals("integration")){
            SerenityRest.then().body("success", equalTo(true));
            SerenityRest.then().body("message", equalTo("Add Booking Class"));
        } else {
            SerenityRest.then().body("error", equalTo("Internal Server Error"));
        }
    }

    @Step("I get a booking id for other request")
    public String iGetABookingIdForOtherRequest(){
        Response response = SerenityRest.lastResponse();
        String bookingId = response.body().path("data.id").toString();
        try (FileWriter file = new FileWriter("src//test//resources//filejson//bookingId.json")) {
            file.write(bookingId);
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(bookingId);
        return bookingId;
    }
}
