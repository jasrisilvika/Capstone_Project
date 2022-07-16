package starter.module.classes;

import Utils.General;
import com.vladsch.flexmark.ext.xwiki.macros.MacroAttribute;
import io.cucumber.java.eo.Se;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.equalTo;

public class Post {
    General general = new General();
    String startAt, name;
    protected static String base_url = "https://capstone-kelompok-3.herokuapp.com";

    @Step("I set an endpoint for POST create class {string}")
    public String iSetAnEndpointForPOSTCreateClass(String category){
        return base_url + "/class/" + category;
    }

    @Step("I request POST create class {string} {string} {int} {string} {int} {string} {string}")
    public JSONObject iRequestPostCreateClass(String category, String name, Integer instructor, String desc, int price, String location, String result){
        JSONObject reqData = new JSONObject();
        Map<String, Integer> idInstructor = new HashMap<>();
        if (result.equals("nullStartAt")){
            this.startAt = null;
        } else {
            this.startAt = general.dateNow();
        }
        if (name.equals("null")){
            this.name = null;
        } else {
            this.name = name;
        }


        idInstructor.put("id", instructor);
        reqData.put("name", this.name);
        reqData.put("idInstructor", idInstructor);
        reqData.put("startAt",this.startAt);
        reqData.put("description",desc);
        if (price == 0){
            reqData.put("price", null);
        } else {
            reqData.put("price",price);
        }
        reqData.put("location",location);

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(reqData.toJSONString())
                .when().post(iSetAnEndpointForPOSTCreateClass(category));
        return reqData;
    }



    @Step("I validate the result after POST create class {string} {string} {int} {string} {int} {string} {string}")
    public void iValidateTheResultAfterPOSTCreateClass(String result, String name, int instructor, String desc, int price, String location, String category){
        if (result.equals("success")){
            SerenityRest.then().body("success", equalTo(true));
            if (category.equals("online")) {
                SerenityRest.then().body("message", equalTo("Success Create New Online Class"));
            }
            else if(category.equals("offline")){
                SerenityRest.then().body("message", equalTo("Success Create New Offline Class"));
            }
            SerenityRest.then().body("data.name",equalTo(name));
            SerenityRest.then().body("data.description", equalTo(desc));
            SerenityRest.then().body("data.idInstructor.id", equalTo(instructor));
            SerenityRest.then().body("data.price", equalTo(price));
            SerenityRest.then().body("data.location", equalTo(location));
        }
        else if(result.equals("failed")){
            SerenityRest.then().body("success", equalTo(false));
        } else {
            SerenityRest.then().body("error", equalTo("Internal Server Error"));
        }
    }

    @Step("I request POST create class {string} {string} {string} {int} {string}")
    public JSONObject iRequestPOSTCreateClassForNullInstructor(String category, String name, String desc, int price, String location){
        JSONObject reqData = new JSONObject();
        Map<String, Integer> idInstructor = new HashMap<>();
        this.startAt = general.dateNow();

        idInstructor.put("id", null);
        reqData.put("name", name);
        reqData.put("idInstructor", idInstructor);
        reqData.put("startAt",this.startAt);
        reqData.put("description",desc);
        reqData.put("price",price);
        reqData.put("location",location);

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(reqData.toJSONString())
                .when().post(iSetAnEndpointForPOSTCreateClass(category));
        return reqData;
    }

    @Step("I validate the result after POST create class {string}")
    public void iValidateTheResultAfterPOSTCreateClassNullInstructor(String result){
        if (result.equals("nullIdInst")){
            SerenityRest.then().body("error", equalTo("Internal Server Error"));
        }
    }
}
