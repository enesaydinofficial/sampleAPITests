package toolsqaApi;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;

public class CityWeatherApi {

    public static void main(String[] args) {

        CityWeatherApi.cityGetWeather("İstanbul");

        System.out.println("----------------------------");

        CityWeatherApi.cityGetWeather("Kocaeli");

    }

    @Test
    private static void cityGetWeather(String cityName) {

        RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city/";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET, cityName);
        String responseBody = response.getBody().asString();
        System.out.println("Response Body is =>  " + responseBody);


    }
}
