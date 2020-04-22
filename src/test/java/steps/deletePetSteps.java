package steps;

import io.cucumber.java.en.When;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.ResponseAwareMatcher.*;
import static org.hamcrest.Matchers.*;

public class deletePetSteps {

    @When("The user DELETE pet by id")
    public void theUserDELETEPetById() {
        given().delete(findPetsByStatusSteps.currentURL).then().statusCode(200);
    }
}
