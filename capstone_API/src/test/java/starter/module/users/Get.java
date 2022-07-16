package starter.module.users;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.eo.Se;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.io.FileWriter;
import java.io.IOException;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class Get {
    protected static String base_url = "https://capstone-kelompok-3.herokuapp.com";

    @Step("I set an endpoint for GET all users {string}")
    public String iSetAnEndpointForGETAllUsers(String category){
        if (category.equals("users")){
            return base_url + "/" + category;
        } else {
            return base_url + "/users/" + category;
        }
    }

    @Step("I request GET all users {string}")
    public void iRequestGETAllUsers(String category){
        SerenityRest.given()
                .when().get(iSetAnEndpointForGETAllUsers(category));
    }

    @Step("I validate the status code is {int}")
    public void iValidateTheStatusCodeIs(int status_code){
        restAssuredThat(response -> response.statusCode(status_code));
    }

    @Step("I validate the result after GET users {string}")
    public void iValidateTheResultAfterGETUsers(String category){
        SerenityRest.then().body("success", equalTo(true));
        if (category.equals("superadmin")){
            SerenityRest.then().body("message", equalTo("Get User as SuperAdmin"));
        } else if(category.equals("admin")){
            SerenityRest.then().body("message", equalTo("Get User as Admin"));
        } else if (category.equals("user")){
            SerenityRest.then().body("message", equalTo("Get User"));
        } else if (category.equals("users")){
            SerenityRest.then().body("message", equalTo("Get All Users"));
        }
    }

    @Step("I set an endpoint for GET user by id {int}")
    public String iSetAnEndpointForGETUserById(int id){
        return base_url + "/users/" + id;
    }

    @Step("I request GET user by id {int}")
    public void iRequestGETUserById(int id){
        SerenityRest.given()
                .when()
                .get(iSetAnEndpointForGETUserById(id));
    }

    @Step("I validate the result after GET user by id {string} {int}")
    public void iValidateTheResultAfterGETUserById(String result, int id){
        if (result.equals("success")){
            SerenityRest.then().body("success", equalTo(true));
            SerenityRest.then().body("message", equalTo("Get User by ID"));
            SerenityRest.then().body("data.id", equalTo(id));
        } else {
            SerenityRest.then().body("success", equalTo(false));
            SerenityRest.then().body("message", equalTo("Failed to get user by ID"));
        }
    }

    @Step("I get an user id for other request {string}")
    public String iGetAnUserIdForOtherRequest(){
        Response response = SerenityRest.lastResponse();
        String userId = response.body().path("data.id").toString();

        try (FileWriter file = new FileWriter("src//test//resources//filejson//userId.json")) {
            file.write(userId);
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(userId);
        return userId;
    }

    @Step("I get an id for update password")
    public String iGetAnIdForUpdatePassword(){
        Response response = SerenityRest.lastResponse();
        String idUpdatePass = response.body().path("data[4].id").toString();
        try (FileWriter file = new FileWriter("src//test//resources//filejson//idUpdatePass.json")) {
            file.write(idUpdatePass);
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(idUpdatePass);
        return idUpdatePass;
    }

    @Step("I get an user id for update user")
    public String iGetAnUserIdForUpdateUser(){
        Response response = SerenityRest.lastResponse();
        String idUpdateUser = response.body().path("data[2].id").toString();
        try (FileWriter file = new FileWriter("src//test//resources//filejson//idUpdateUser.json")) {
            file.write(idUpdateUser);
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(idUpdateUser);
        return idUpdateUser;
    }
}

