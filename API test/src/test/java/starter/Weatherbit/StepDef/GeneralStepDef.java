package starter.Weatherbit.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;

public class GeneralStepDef {
    @Then("Should return status code {int}")
    public void shouldReturnStatusCode(int statusCode)
    {
        SerenityRest.then().statusCode(statusCode);
    }
}