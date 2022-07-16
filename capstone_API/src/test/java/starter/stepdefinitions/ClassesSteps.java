package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.module.classes.Delete;
import starter.module.classes.Get;
import starter.module.classes.Post;
import starter.module.classes.Put;

public class ClassesSteps {
    public String classId;
    @Steps
    Get get;
    @Steps
    Post post;
    @Steps
    Delete delete;
    @Steps
    Put put;

    @Given("I set an endpoint for GET all classes")
    public void iSetAnEndpointForGETAllClasses(){
        get.iSetAnEndpointForGETAllClasses();
    }

    @When("I request GET all classes")
    public void iRequestGETAllCLasses(){
        get.iRequestGETAllCLasses();
    }

    @And("I validate the result after GET all classes")
    public void iValidateTheResultAfterGETAllClasses(){
        get.iValidateTheResultAfterGETAllClasses();
    }

    @And("I get an id for other request {string}")
    public void iGetAnIdForOtherRequest(String req){
        this.classId = get.iGetAnIdForOtherRequest(req);
    }

    @And("I get an id for other request post booking")
    public void iGetAnIdForOtherRequestPostBooking(){
        get.iGetAnIdForOtherRequestPostBooking();
    }

    @Given("I set an endpoint for POST create class {string}")
    public void iSetAnEndpointForPOSTCreateClass(String category){
        post.iSetAnEndpointForPOSTCreateClass(category);
    }

    @When("I request POST create class {string} {string} {int} {string} {int} {string} {string}")
    public void iRequestPostCreateClass(String category, String name, int instructor,  String desc, int price, String location, String result){
        post.iRequestPostCreateClass(category, name, instructor, desc, price, location, result);
    }

    @And("I validate the result after POST create class {string} {string} {int} {string} {int} {string} {string}")
    public void iValidateTheResultAfterPOSTCreateClass(String result, String name, int instructor, String desc, int price, String location, String category){
        post.iValidateTheResultAfterPOSTCreateClass(result, name, instructor, desc, price, location, category);
    }

    @Given("I set an endpoint for DELETE a class")
    public void iSetAnEndpointForDELETEAClass(){
        delete.iSetAnEndpointForDELETEAClass(this.classId);
    }

    @When("I request DELETE a class {string}")
    public void iRequestDELETEAClass(String result) throws Exception{
        delete.iRequestDELETEAClass(result);
    }

    @And("I validate the result after DELETE a class {string}")
    public void iValidateTheResultAfterDELETEAClass(String result){
        delete.iValidateTheResultAfterDELETEAClass(result);
    }

    @Given("I set an endpoint for GET class by id")
    public void iSetAndEndpointForGETClassById(){
        get.iSetAndEndpointForGETClassById(this.classId);
    }

    @When("I request GET class by id {string}")
    public void iRequestGETClassById(String result) throws Exception{
        get.iRequestGETClassById(result);
    }

    @And("I validate the result after GET class by id {string}")
    public void iValidateTheResultAfterGETClassById(String result){
        get.iValidateTheResultAfterGETClassById(result);
    }

    @When("I request POST create class {string} {string} {string} {int} {string}")
    public void iRequestPOSTCreateClassForNullInstructor(String category, String name, String desc, int price, String location){
        post.iRequestPOSTCreateClassForNullInstructor(category, name, desc, price, location);
    }

    @And("I validate the result after POST create class {string}")
    public void iValidateTheResultAfterPOSTCreateClassNullInstructor(String result){
        post.iValidateTheResultAfterPOSTCreateClassNullInstructor(result);
    }

    @Given("I set an endpoint for PUT update class {string}")
    public void iSetAnEndpointForPUTUpdateClass(String result){
        put.iSetAnEndpointForPUTUpdateClass(this.classId);
    }

    @When("I request PUT update class {string} {int} {int} {string} {string} {string}")
    public void iRequestPUTUpdateClass(String name, int instructor, int price, String type, String startAt, String result) throws Exception{
        put.iRequestPUTUpdateClass(name, instructor, price, type, startAt, result);
    }

    @And("I validate the result after update class {string}")
    public void iValidateResultAfterUpdateClass(String result){
        put.iValidateResultAfterUpdateClass(result);
    }

}
