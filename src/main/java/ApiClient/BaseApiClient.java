package ApiClient;

import io.qameta.allure.Step;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class BaseApiClient
{
    @Step("Send base construction for request ")
    public RequestSpecification getPostSpecification()
    {
       return  given()
                .filter(new RequestLoggingFilter())
                .filter(new RequestLoggingFilter())
                .contentType(ContentType.JSON);

    }
}
