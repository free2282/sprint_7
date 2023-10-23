import Api.OrderApi;
import JsonModel.OrderCreateRequestModel;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static Generator.OrderGenerator.getRandomCourierCreateWithFirstName;
import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_CREATED;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class CreateOrderTest
{
    private OrderCreateRequestModel orderCreateRequestModel;
    private OrderApi orderApi;
    private final String[] color;


    @Parameterized.Parameters
    public static Object[][] param()
    {
        String[] firstTestCase = {"BLACK"};
        String[] secondTestCase = {"GREY"};
        String[] thirdTestCase = {"GREY", "BLACK"};
        String[] fourthTestCase = {"BLACK", "GREY"};
        String[] fifthTestCase = {};
        return new Object[][]
                {
                        {firstTestCase},
                        {secondTestCase},
                        {thirdTestCase},
                        {fourthTestCase},
                        {fifthTestCase}
                };
    }
    public CreateOrderTest(String[] color)
    {
        this.color = color;
    }

    @Before
    public void setUp()
    {
        orderApi = new OrderApi();
        orderCreateRequestModel = getRandomCourierCreateWithFirstName();
    }
    @Test
    @DisplayName("order create parametrized test")
    @Description("Api /api/v1/orders")
    public void orderCreteTest()
    {
        orderCreateRequestModel.setColor(color);
        Response response = orderApi.createOrder(orderCreateRequestModel);

        response.then().assertThat().body("track", notNullValue());
        assertEquals(SC_CREATED, response.statusCode());
    }
}
