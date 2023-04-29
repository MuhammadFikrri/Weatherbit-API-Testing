package starter.Weatherbit;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class GetWeatherAPI
{
    //    Get current weather
    @Step("Get current weather")
    public void getCurrentWeather(String token)
    {
        SerenityRest.given()
                .header("Authorization", "Bearer" + token);
    }
}
