package ApiClient;
import JsonModel.OrderCreateRequestModel;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import static ConfigApp.ConfigApp.MAIN_URL;

public class OrderApiCLient extends BaseApiClient
{
    @Step("post, create order /api/v1/orders")
    public Response createOrder(OrderCreateRequestModel orderCreateRequestModel)
    {
        return getPostSpecification()
                .body(orderCreateRequestModel)
                .when()
                .post(MAIN_URL + "/api/v1/orders");
    }
    @Step("get orders /api/v1/orders")
    public Response getOrders()
    {
        return getPostSpecification()
                .when()
                .get(MAIN_URL + "/api/v1/orders");
    }
}
