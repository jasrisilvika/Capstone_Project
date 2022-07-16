package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.pt.E;
import net.thucydides.core.annotations.Steps;

import starter.module.users.Get;
import starter.module.users.Post;
import starter.module.users.Put;

public class UsersSteps {
    String userId, idUpdatePass, idUpdateUser;
    @Steps
    Get get;

    @Steps
    Post post;

    @Steps
    Put put;

    @Given("I set an endpoint for GET all users {string}")
    public void iSetAnEndpointForGETAllUsers(String category){
        get.iSetAnEndpointForGETAllUsers(category);
    }

    @When("I request GET all users {string}")
    public void iRequestGETAllUsers(String category){
        get.iRequestGETAllUsers(category);
    }

    @And("I validate the status code is {int}")
    public void iValidateTheStatusCodeIs(int status_code){
        get.iValidateTheStatusCodeIs(status_code);
    }

    @Then("I validate the result after GET users {string}")
    public void iValidateTheResultAfterGETUsers(String category){
        get.iValidateTheResultAfterGETUsers(category);
    }

    @Given("I set an endpoint for GET user by id {int}")
    public void iSetAnEndpointForGETUserById(int id){
        get.iSetAnEndpointForGETUserById(id);
    }

    @When("I request GET user by id {int}")
    public void iRequestGETUserById(int id){
        get.iRequestGETUserById(id);
    }

    @And("I validate the result after GET user by id {string} {int}")
    public void iValidateTheResultAfterGETUserById(String result, int id){
        get.iValidateTheResultAfterGETUserById(result, id);
    }

    @Given("I set an endpoint for POST create users {string}")
    public void iSetAnEndpointForPOSTCreateUsers(String category){
        post.iSetAnEndpointForPOSTCreateUsers(category);
    }

    @When("I request POST create users {string} {string} {string} {string} {string} {string} {string}")
    public void iRequestPOSTCreateUsers(String category, String name, String address, String username, String email, String contact, String password){
        post.iRequestPOSTCreateUsers(category, name, address, username, email, contact, password);
    }

    @And("I validate the result after POST create users {string} {string} {string}")
    public void iValidateTheResultAfterPOSTCreateUser(String category, String result, String contact){
        post.iValidateTheResultAfterPOSTCreateUser(category, result, contact);
    }

    @And("I get an user id for other request {string}")
    public void iGetAnUserIdForOtherRequest(String category){
        if (category.equals("user")){
            this.userId = get.iGetAnUserIdForOtherRequest();
        }
    }

    @Given("I set an endpoint for PUT update password user")
    public void iSetAnEndpointForPUTUpdatePasswordUser(){
        put.iSetAnEndpointForPUTUpdatePasswordUser(this.idUpdatePass);
    }

    @When("I request PUT update password user {string} {string}")
    public void iRequestPUTUpdatePasswordUser(String password, String result) throws Exception {
        put.iRequestPUTUpdatePasswordUser(password, result);
    }

    @And("I validate the result after update password user {string} {string}")
    public void iValidateTheResultAfterUpdatePasswordUser(String result, String password){
        put.iValidateTheResultAfterUpdatePasswordUser(result, password);
    }

    @And("I get an id for update password")
    public void iGetAnIdForUpdatePassword(){
        this.idUpdatePass = get.iGetAnIdForUpdatePassword();
    }

    @Given("I set an endpoint for PUT update user {string}")
    public void iSetAnEndpointForPUTUpdateUser(String result){
        put.iSetAnEndpointForPUTUpdateUser(this.idUpdateUser);

    }

    @When("I request PUT update user {string} {string} {string} {string} {string}")
    public void iRequestPUTUpdateUser(String name, String username, String email, String contact, String result) throws Exception {
        put.iRequestPUTUpdateUser(name, username, email, contact, result);
    }

    @And("I validate the result after PUT update user {string}")
    public void iValidateTheResultAfterPUTUpdateUser(String result){
        put.iValidateTheResultAfterPUTUpdateUser(result);
    }

    @And("I get an user id for update user {string}")
    public void iGetAnUserIdForUpdateUser(String category){
        if (category.equals("user")){
            this.idUpdateUser = get.iGetAnUserIdForUpdateUser();
        }
    }

}
