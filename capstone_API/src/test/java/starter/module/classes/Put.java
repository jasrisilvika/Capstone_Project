package starter.module.classes;

import Utils.General;
import io.cucumber.java.eo.Se;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.apache.commons.io.FileUtils;
import org.hamcrest.CoreMatchers;
import org.json.simple.JSONObject;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.in;

public class Put {
    private String classId;
    String name, instructor, type, startAt;
    General general = new General();
    protected static String base_url = "https://capstone-kelompok-3.herokuapp.com";

    @Step("I set an endpoint for PUT update class {string}")
    public String iSetAnEndpointForPUTUpdateClass(String result){
        return base_url + "/class/" + classId;
    }

    @Step("I request PUT update class {string} {int} {int} {string} {string} {string}")
    public JSONObject iRequestPUTUpdateClass(String name, Integer instructor, int price, String type, String startAt, String result) throws Exception{
        if (result.equals("invalid")){
            this.classId = "12";
        } else {
            this.classId = FileUtils.readFileToString(new File(System.getProperty("user.dir") + "//src//test//resources//filejson//classIdForUpdate.json"), StandardCharsets.UTF_8) ;
        }

        JSONObject reqData = new JSONObject();
        Map<String, Integer> idInstructor = new HashMap<>();
        if (name.equals("null")){
            this.name = null;
        } else {
            this.name = name;
        }
        if (type.equals("noType")){
            this.type = null;
        } else {
            this.type = type;
        }
        if (startAt.equals("null")){
            this.startAt = null;
        } else {
            this.startAt = general.dateNow();
        }

        idInstructor.put("id", instructor);
        reqData.put("idInstructor", idInstructor);
        reqData.put("name", this.name);
        reqData.put("startAt", this.startAt);
        reqData.put("type", this.type);
        if (price == 0){
            reqData.put("price", null);
        } else {
            reqData.put("price",price);
        }
        reqData.put("description", "zumba class for everyone");
        reqData.put("location", "From Home");

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(reqData.toJSONString())
                .when().put(iSetAnEndpointForPUTUpdateClass(classId));

        return reqData;
    }

    @Step("I validate the result after update class {string}")
    public void iValidateResultAfterUpdateClass(String result){
        if (result.equals("success")){
            SerenityRest.then().body("success", equalTo(true));
            SerenityRest.then().body("message", equalTo("Success update Class"));
        } else if (result.equals("invalid")){
            SerenityRest.then().body("error", equalTo("Internal Server Error"));
        } else if (result.equals("failed")){
            SerenityRest.then().body("success", equalTo(false));
        }
    }

}
