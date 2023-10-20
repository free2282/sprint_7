package ApiClient;

import JsonModel.CourierCreateRequestModel;
import JsonModel.CourierLogInRequestModel;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import static ConfigApp.ConfigApp.MAIN_URL;
import static io.restassured.RestAssured.given;

public class CourierApiClient extends BaseApiClient
{
    @Step("Send request to /api/v1/courier for creating courier")
    public Response createCourier(CourierCreateRequestModel courierCreateRequestModel)
    {
        return getPostSpecification()
                .body(courierCreateRequestModel)
                .when()
                .post(MAIN_URL + "/api/v1/courier");
    }
    @Step("Send request to /api/v1/login for log in in system by courier")
    public Response loginCourier(CourierLogInRequestModel courierLogInRequestModel)
    {
        return getPostSpecification()
                .body(courierLogInRequestModel)
                .when()
                .post(MAIN_URL + "/api/v1/courier/login");
    }
}
