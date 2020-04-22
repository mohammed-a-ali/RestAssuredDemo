package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import static io.restassured.RestAssured.*;

import java.util.List;
import java.util.Map;

public class addPetSteps {

    protected static JSONObject request = new JSONObject();

    @When("The user sends a request using the following data")
    public void theUserSendsARequest(DataTable dt) {
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

    @Then("The POST method should return {int}")
    public void thePostMethodShouldReturn(int statusCode) {

    }
}
