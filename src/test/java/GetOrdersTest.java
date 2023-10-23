import Api.OrderApi;
import JsonModel.GetOrders.GetOrdersResponseApiModel;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;

import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;

public class GetOrdersTest
{
    private OrderApi orderApi;

    @Before
    public void setUp()
    {
        orderApi = new OrderApi();
    }

    @Test
    @DisplayName("get orders test")
    @Description("Api /api/v1/orders")
    public void getOrdersTest()
    {
        Response response = orderApi.getOrders();
        assertEquals(SC_OK, response.statusCode());

        GetOrdersResponseApiModel responseToPojo =  response.body().as(GetOrdersResponseApiModel.class);
        assertFalse(responseToPojo.getOrders().isEmpty());
    }
}
