package starter.Weatherbit.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import org.assertj.core.api.Assertions;
import starter.Weatherbit.GetWeatherAPI;
import starter.Weatherbit.Utils.Constant;

import java.util.List;
import java.util.Map;

public class GetWeatherStepDef
{
    @Steps
    GetWeatherAPI getWeatherAPI;

    @Given("User already have valid API key")
    public void userAlreadyHaveValidAPIKey()
    {
        getWeatherAPI.getCurrentWeather(Constant.WEATHER_API_KEY);
    }

    @When("User sent GET request")
    public void theUserSentsGETRequestAndGetTheStateCodeValue()
    {
        SerenityRest.when().get(Constant.BASE_URL);
    }

    @And("Response body state code should be {string}")
    public void responseBodyStateCodeShouldBe(String stateCode)
    {
        List<Map<String, String>> responseDataList = SerenityRest.lastResponse().getBody().jsonPath().getList("data");
        String state_code = responseDataList.get(0).get("state_code");
        Assertions.assertThat(stateCode).isEqualTo(state_code);
        System.out.println("Response body state_code " + state_code + " equal to expected state code " + stateCode);
    }

    @And("It should parse the response body")
    public void itShouldParseTheResponseBody()
    {
        String response = SerenityRest.lastResponse().getBody().asString();
        System.out.println("Response body : ");
        System.out.println(response);
        List<Map<String, String>> responseDataList = SerenityRest.lastResponse().getBody().jsonPath().getList("data");
        System.out.println("Response data list : ");
        System.out.println(responseDataList);
    }

    @And("Get the value of the state_code")
    public void getTheValueOfTheDataState_code()
    {
        List<Map<String, String>> responseDataList = SerenityRest.lastResponse().getBody().jsonPath().getList("data");
        String state_code = responseDataList.get(0).get("state_code");
        System.out.println("state_code value : ");
        System.out.println(state_code);
    }
}
