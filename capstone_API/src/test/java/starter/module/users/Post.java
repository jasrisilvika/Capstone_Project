package starter.module.users;

import Utils.General;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;
import static org.hamcrest.Matchers.equalTo;
import java.io.FileWriter;
import java.io.IOException;

public class Post {
    General general = new General();
    String name, username, email, password;

    protected static String base_url = "https://capstone-kelompok-3.herokuapp.com";

    @Step("I set an endpoint for POST create users {string}")
    public String iSetAnEndpointForPOSTCreateUsers(String category){
        return base_url + "/users/register/" + category;
    }

    @Step("I request POST create users {string} {string} {string} {string} {string} {string} {string}")
    public void iRequestPOSTCreateUsers(String category, String name, String address, String username, String email, String contact, String password) {
        JSONObject reqData = new JSONObject();
        if (name.equals("new")) {
            this.name = general.randomName();
            try (FileWriter file = new FileWriter("src//test//resources//filejson//name.json")) {
                file.write(this.name);
                file.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (username.equals("new")){
            this.username = general.randomUsername();
            try (FileWriter file = new FileWriter("src//test//resources//filejson//username.json")) {
                file.write(this.username);
                file.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(email.equals("new")){
            this.email = general.randomEmail();
            try (FileWriter file = new FileWriter("src//test//resources//filejson//email.json")) {
                file.write(this.email);
                file.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (email.equals("same")){
            if (category.equals("superadmin")){
                this.email = "superAdminManualTest@gmail.com";
            } else if (category.equals("admin")){
                this.email = "testAdminManual@gmail.com";
            } else if (category.equals("user")){
                this.email = "userstesting156@email.com";
            }
        }
        if (password == null){
            this.password = null;
        } else {
            this.password = password;
        }


        reqData.put("name", this.name);
        reqData.put("address", address);
        reqData.put("username", this.username);
        reqData.put("email", this.email);
        if (contact.equals("0")){
            reqData.put("contact", null);
        } else {
            reqData.put("contact", contact);
        }
        reqData.put("password", this.password);

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(reqData.toJSONString())
                .when().post(iSetAnEndpointForPOSTCreateUsers(category));
    }

    @Step("I validate the result after POST create users {string} {string} {string}")
    public void iValidateTheResultAfterPOSTCreateUser(String category, String result, String contact){
        if (result.equals("success")){
            SerenityRest.then().body("success", equalTo(true));
            if (category.equals("superadmin")){
                SerenityRest.then().body("message", equalTo("Register Super Admin"));
            } else if (category.equals("admin")){
                SerenityRest.then().body("message", equalTo("Register Admin"));
            } else if (category.equals("user")){
                SerenityRest.then().body("message", equalTo("Register User"));
            }
            SerenityRest.then().body("data.name", equalTo(this.name));
            SerenityRest.then().body("data.email", equalTo(this.email));
            SerenityRest.then().body("data.contact", equalTo(contact));
            SerenityRest.then().body("data.username", equalTo(this.username));
        } else if (result.equals("failed")){
            SerenityRest.then().body("error", equalTo("Internal Server Error"));
        } else if (result.equals("failed2")){
            SerenityRest.then().body("success", equalTo(false));
        }

    }

}





