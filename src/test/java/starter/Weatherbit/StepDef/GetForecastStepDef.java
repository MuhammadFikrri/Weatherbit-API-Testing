package starter.Weatherbit.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import starter.Weatherbit.Utils.Constant;

import java.util.List;
import java.util.Map;

public class GetForecastStepDef
{
    @When("User sent GET hourly forecast request")
    public void userSentGETHourlyForecastRequest()
    {
        SerenityRest.when().get(Constant.BASE_URL_FORECAST);
    }

    @And("It should parse the response body of forecast request")
    public void itShouldParseTheResponseBodyOfForecastRequest()
    {
        String response = SerenityRest.lastResponse().getBody().asString();
        System.out.println("Response body : ");
        System.out.println(response);
        List<Map<String, String>> responseDataList = SerenityRest.lastResponse().getBody().jsonPath().getList("data");
        System.out.println("Response data list : ");
        System.out.println(responseDataList);
    }

    @And("Get the value of the timestamp_utc, weather for all the data entries")
    public void getTheValueOfTheTimestamp_utcWeatherForAllTheDataEntries()
    {
        List<Map<String, String>> weather = SerenityRest.lastResponse().getBody().jsonPath().getList("data.weather.description");
        List<Map<String, String>> timestamp_utc = SerenityRest.lastResponse().getBody().jsonPath().getList("data.timestamp_utc");

        System.out.println("timestamp_utc value :");
        System.out.println(timestamp_utc);
        System.out.println("weather value :");
        System.out.println(weather);
    }
}
