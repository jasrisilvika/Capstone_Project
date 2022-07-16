package starter.module.booking;
import io.cucumber.java.eo.Se;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.nio.charset.StandardCharsets;

import static org.hamcrest.Matchers.equalTo;
public class Put {
    private String bookingIdBfrAcc;
    protected static String base_url = "https://capstone-kelompok-3.herokuapp.com";

    @Step("I set an endpoint for PUT accept class")
    public String iSetAnEndpointForPUTAcceptClass(String bookingIdBfrAcc){
        return base_url + "/booking/acc/" + bookingIdBfrAcc;
    }

    @Step("I request PUT accept class {string}")
    public void iRequestPUTAcceptClass(String result) throws Exception{
        if (result.equals("success")){
            this.bookingIdBfrAcc = FileUtils.readFileToString(new File(System.getProperty("user.dir") + "//src//test//resources//filejson//bookingIdBfrAcc.json"), StandardCharsets.UTF_8) ;
        } else {
            this.bookingIdBfrAcc = "888";
        }
        SerenityRest.given()
                .when().put(iSetAnEndpointForPUTAcceptClass(this.bookingIdBfrAcc));
    }

    @Step("I validate the {string} after PUT accept class")
    public void iValidateResultAfterAcceptClass(String result){
        if (result.equals("success")){
            SerenityRest.then().body("success", equalTo(true));
            SerenityRest.then().body("message", equalTo("berhasil"));
        } else {
            SerenityRest.then().body("error", equalTo("Internal Server Error"));
        }
    }
}

