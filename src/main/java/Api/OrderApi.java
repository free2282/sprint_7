package Api;
import Model.Orders.Post.OrderCreateRequestModel;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import static Config.ConfigApp.ORDERS_URL;

public class OrderApi extends BaseApi
{
    @Step("post, create order /api/v1/orders")
    public Response createOrder(OrderCreateRequestModel orderCreateRequestModel)
    {
        return basePostRequest(ORDERS_URL, orderCreateRequestModel);
    }
    @Step("get orders /api/v1/orders")
    public Response getOrders()
    {
        return baseGetRequest(ORDERS_URL);
    }
}
