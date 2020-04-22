package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import utilities.LoadProperties;
import static io.restassured.RestAssured.*;

public class findPetsByStatusSteps {

    String baseURL = LoadProperties.environment.getProperty("URL");
    public static String currentURL = "";
    int responseStatusCode = 0;

    @Given("The user opens {string} endPoint")
    public void the_user_clicks_on_page(String endPoint) {
        currentURL = baseURL + endPoint;
    }

    @When("The user sends GET request to get all {string} pets")
    public void theUserSendsRequestToGetAllPets(String status) {
        currentURL = currentURL + "?status="+ status;
        Response response = get(currentURL);
        responseStatusCode = response.getStatusCode();
    }

    @Then("The status code should be {int}")
    public void theStatusCodeShouldBe(int statusCode) {
        Assert.assertEquals(responseStatusCode, statusCode);
    }

    @And("The user should see the response body")
    public void theUserShouldSeeTheResponseBody() {
        given().
            contentType(ContentType.JSON).
            get(currentURL).
        then().
            log().all();
    }
}
