package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import org.json.simple.JSONObject;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class updatePetSteps {

    @Then("The PUT method should return {int}")
    public void thePUTMethodShouldReturn(int statusCode) {
        given().
            contentType(ContentType.JSON).
            body(addPetSteps.request).
        when().
            put(findPetsByStatusSteps.currentURL).
        then().
            statusCode(statusCode);
    }

    @When("The user sends PUT request using the following data")
    public void theUserSendsPUTRequestUsingTheFollowingData(DataTable dt) {
        JSONObject request = new JSONObject();
        List<Map<String, String>> list = dt.asMaps(String.class, String.class);

        for(int i=0; i<list.size(); i++) {
            request.put("id", list.get(i).get("id"));
            request.put("name", list.get(i).get("name"));
            request.put("status", list.get(i).get("status"));

            given().
                contentType(ContentType.JSON).
                body(request).
            when().
                post(findPetsByStatusSteps.currentURL).
            then().
                statusCode(200);
        }
    }
}
