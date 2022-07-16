package starter.module.classes;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.nio.charset.StandardCharsets;

import static org.hamcrest.CoreMatchers.equalTo;

public class Delete {
    private String classId;
    protected static String base_url = "https://capstone-kelompok-3.herokuapp.com";

    @Step("I set an endpoint for DELETE a class")
    public String iSetAnEndpointForDELETEAClass(String classId){
        return base_url + "/class/"+ classId;
    }

    @Step("I request DELETE a class {string}")
    public void iRequestDELETEAClass(String result) throws Exception {
        if (result.equals("success")){
//            this.classId = "5144";
            this.classId = FileUtils.readFileToString(new File(System.getProperty("user.dir") + "//src//test//resources//filejson//id.json"), StandardCharsets.UTF_8) ;
        } else {
            this.classId = "888";
        }
        SerenityRest.given()
                .header("Content-Type", "application/json")
                .when()
                .delete(iSetAnEndpointForDELETEAClass(classId));
    }

    @Step("I validate the result after DELETE a class {string}")
    public void iValidateTheResultAfterDELETEAClass(String result){
        if (result.equals("success")){
            SerenityRest.then().body("success", equalTo(true));
            SerenityRest.then().body("message", equalTo("Deleted"));
        }

    }
}
