package Api;

import JsonModel.CourierCreateRequestModel;
import JsonModel.CourierLogInRequestModel;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import static ConfigApp.ConfigApp.*;
import static io.restassured.RestAssured.given;

public class CourierApi extends BaseApi
{
    @Step("Send request to /api/v1/courier for creating courier")
    public Response createCourier(CourierCreateRequestModel courierCreateRequestModel)
    {
        return basePostRequest(CREATE_COURIER_URL, courierCreateRequestModel);
    }
    @Step("Send request to /api/v1/login for log in in system by courier")
    public Response loginCourier(CourierLogInRequestModel courierLogInRequestModel)
    {
        return basePostRequest(LOGIN_COURIER_URL, courierLogInRequestModel);
    }
}
