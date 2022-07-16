package starter.module.classes;

import io.cucumber.java.eo.Se;
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
    private String classId;
    protected static String base_url = "https://capstone-kelompok-3.herokuapp.com";

    @Step("I set an endpoint for GET all classes")
    public String iSetAnEndpointForGETAllClasses(){
        return base_url + "/class";
    }

    @Step("I request GET all classes")
    public void iRequestGETAllCLasses(){
        SerenityRest.given()
                .when().get(iSetAnEndpointForGETAllClasses());
    }

    @Step("I validate the result after GET all classes")
    public void iValidateTheResultAfterGETAllClasses(){
        SerenityRest.then().body("success", equalTo(true));
        SerenityRest.then().body("message", equalTo("Success Get All Class"));
    }

    @Step("I get an id for other request {string}")
    public String iGetAnIdForOtherRequest(String req){
        Response response = SerenityRest.lastResponse();
        if (req.equals("delete")){
            String classId = response.body().path("data[9].id").toString();

            try (FileWriter file = new FileWriter("src//test//resources//filejson//id.json")) {
                file.write(classId);
                file.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(classId);
            return classId;
        } else {
            String classId = response.body().path("data[5].id").toString();

            try (FileWriter file = new FileWriter("src//test//resources//filejson//classIdForUpdate.json")) {
                file.write(classId);
                file.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(classId);
            return classId;
        }

    }


    @Step("I get an id for other request post booking")
    public String iGetAnIdForOtherRequestPostBooking(){
        Response response = SerenityRest.lastResponse();
        String classId = response.body().path("data[7].id").toString();

        try (FileWriter file = new FileWriter("src//test//resources//filejson//idClassForPost.json")) {
            file.write(classId);
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(classId);
        return classId;
    }

    @Step("I set an endpoint for GET class by id {string}")
    public String iSetAndEndpointForGETClassById(String classId){
        return base_url + "/class/" + classId;
    }

    @Step("I request GET class by id {string}")
    public void iRequestGETClassById(String result) throws Exception{
        if (result.equals("success")){
        this.classId = FileUtils.readFileToString(new File(System.getProperty("user.dir") + "//src//test//resources//filejson//id.json"), StandardCharsets.UTF_8) ;
            SerenityRest.given().when().get(iSetAndEndpointForGETClassById(classId));
        } else
        SerenityRest.given().when().get(iSetAndEndpointForGETClassById("22"));
    }

    @Step("I validate the result after GET class by id {string}")
    public void iValidateTheResultAfterGETClassById(String result){
        if (result.equals("failed")){
            SerenityRest.then().body("success", equalTo(false));
            SerenityRest.then().body("message", equalTo("Failed Get Class By Id"));
        } else {
            SerenityRest.then().body("success", equalTo(true));
            SerenityRest.then().body("message", equalTo("Success Get Class By Id"));
        }
    }
}
