package Api;

import io.qameta.allure.Step;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static Config.ConfigApp.MAIN_URL;
import static io.restassured.RestAssured.given;

public class BaseApi
{
    @Step("Send base construction for request ")
    public Response baseGetRequest(String url)
    {
       return  given()
                .filter(new RequestLoggingFilter())
                .filter(new ResponseLoggingFilter())
                .contentType(ContentType.JSON)
               .when().get(MAIN_URL + url);

    }

    @Step("Send base construction for request ")
    public Response basePostRequest(String url, Object model)
    {
        return  given()
                .filter(new RequestLoggingFilter())
                .filter(new ResponseLoggingFilter())
                .contentType(ContentType.JSON)
                .body(model).when().post(MAIN_URL + url);

    }
}
