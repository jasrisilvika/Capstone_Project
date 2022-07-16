package starter.module.users;

import Utils.General;
import io.cucumber.java.an.E;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;

import java.io.File;
import java.nio.charset.StandardCharsets;
import static org.hamcrest.CoreMatchers.equalTo;

public class Put {
    private String idUpdatePass, idUpdateUser;
    General general = new General();
    String name, username, email, contact, password;
    protected static String base_url = "https://capstone-kelompok-3.herokuapp.com";

    @Step("I set an endpoint for PUT update password user")
    public String iSetAnEndpointForPUTUpdatePasswordUser(String idUpdatePass){
        return base_url + "/users/update/password/" + idUpdatePass;
    }

    @Step("I request PUT update password user {string} {string}")
    public JSONObject iRequestPUTUpdatePasswordUser(String password, String result) throws Exception {
        if (result.equals("success") || result.equals("null")){
            this.idUpdatePass = FileUtils.readFileToString(new File(System.getProperty("user.dir") + "//src//test//resources//filejson//idUpdatePass.json"), StandardCharsets.UTF_8) ;
        } else if (result.equals("failed")){
            this.idUpdatePass = "111";
        }

        if (password.equals("null")){
            this.password = null;
        } else {
            this.password = password;
        }

        JSONObject reqData = new JSONObject();
        reqData.put("password", this.password);

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(reqData.toJSONString())
                .when().put(iSetAnEndpointForPUTUpdatePasswordUser(idUpdatePass));
        return reqData;
    }

    @Step("I validate the result after update password user {string} {string}")
    public void iValidateTheResultAfterUpdatePasswordUser(String result, String password){
        if (result.equals("success")){
            SerenityRest.then().body("success", equalTo(true));
            SerenityRest.then().body("message", equalTo("Update Password"));
            SerenityRest.then().body("data.password", equalTo(password));
        } else if (result.equals("failed")){
            SerenityRest.then().body("error", equalTo("Internal Server Error"));
        } else if (result.equals("null")){
            SerenityRest.then().body("success", equalTo(false));
            SerenityRest.then().body("message", equalTo("Failed to update Password"));
        }
    }

    @Step("I set an endpoint for PUT update user {string}")
    public String iSetAnEndpointForPUTUpdateUser(String idUpdateUser){
        return base_url + "/users/" + idUpdateUser;
    }

    @Step("I request PUT update user {string} {string} {string} {string} {string}")
    public void iRequestPUTUpdateUser(String name, String username, String email, String contact, String result) throws Exception{
        if (result.equals("invalid")){
            this.idUpdateUser = "555";
        } else {
            this.idUpdateUser = FileUtils.readFileToString(new File(System.getProperty("user.dir") + "//src//test//resources//filejson//idUpdateUser.json"), StandardCharsets.UTF_8) ;
        }
        JSONObject reqData = new JSONObject();
        if (name.equals("new")){
            this.name = general.randomName();
        } else if (name.equals("null")){
            this.name = null;
        }
        if (email.equals("new")){
            this.email = general.randomEmail();
        } else if(email.equals("same")){
            this.email = "testuser908@email.com";
        } else if (email.equals("null")){
            this.email = null;
        }
        if (username.equals("new")){
            this.username = general.randomUsername();
        } else if (username.equals("null")){
            this.username = null;
        }
        if (contact.equals("null")){
            this.contact = null;
        } else {
            this.contact = contact;
        }

        reqData.put("name", this.name);
        reqData.put("email", this.email);
        reqData.put("username", this.username);
        reqData.put("contact", this.contact);
        reqData.put("address", "Bogor Kota");
        reqData.put("password", "NewPass12");

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(reqData.toJSONString())
                .when().put(iSetAnEndpointForPUTUpdateUser(idUpdateUser));
    }

    @Step("I validate the result after PUT update user {string}")
    public void iValidateTheResultAfterPUTUpdateUser(String result){
        if (result.equals("success")){
            SerenityRest.then().body("success", equalTo(true));
        } else if (result.equals("failed") || result.equals("invalid")){
            SerenityRest.then().body("error", equalTo("Internal Server Error"));
        } else if (result.equals("err")){
            SerenityRest.then().body("success", equalTo(false));
        }
    }

}
