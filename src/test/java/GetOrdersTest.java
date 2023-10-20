import ApiClient.OrderApiCLient;
import JsonModel.GetOrders.GetOrdersResponseApiModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;
import com.fasterxml.jackson.databind.ObjectMapper;
import static org.apache.http.HttpStatus.SC_BAD_REQUEST;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;

public class GetOrdersTest
{
    private OrderApiCLient orderApiCLient;

    @Before
    public void setUp()
    {
        orderApiCLient = new OrderApiCLient();
    }

    @Test
    @DisplayName("get orders test")
    @Description("Api /api/v1/orders")
    public void getOrdersTest()
    {
        Response response = orderApiCLient.getOrders();
        assertEquals(SC_OK, response.statusCode());

        GetOrdersResponseApiModel responseToPojo =  response.body().as(GetOrdersResponseApiModel.class);
        assertFalse(responseToPojo.getOrders().isEmpty());
    }
}
