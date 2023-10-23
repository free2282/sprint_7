import Api.CourierApi;
import JsonModel.CourierCreateRequestModel;
import JsonModel.CourierLogInRequestModel;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;

import static Generator.CourierGenerator.*;
import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.*;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class CourierLogInTest
{
    private CourierCreateRequestModel courierCreateRequestModel;
    private CourierLogInRequestModel courierLogInRequestModel;
    private CourierApi courierApi;

    @Before
    public void setUp()
    {
        courierApi = new CourierApi();
        courierCreateRequestModel = getRandomCourierCreateWithoutFirstName();

        courierApi.createCourier(courierCreateRequestModel);
    }
    @Test
    @DisplayName("login courier with expecting 200 status code test")
    @Description("Api /api/v1/login")
    public void logInCourierExpected200Test()
    {
        courierLogInRequestModel = new CourierLogInRequestModel(courierCreateRequestModel.getLogin(), courierCreateRequestModel.getPassword());
        Response response = courierApi.loginCourier(courierLogInRequestModel);

        assertEquals(SC_OK, response.getStatusCode());
        response.then().assertThat().body("id", notNullValue());
    }

    @Test
    @DisplayName("login courier with null login param of request ")
    @Description("Api /api/v1/login")
    public void logInCourierNullLoginExpected400Test()
    {
        courierLogInRequestModel = new CourierLogInRequestModel(null, courierCreateRequestModel.getPassword());
        Response response = courierApi.loginCourier(courierLogInRequestModel);

        assertEquals(SC_BAD_REQUEST, response.getStatusCode());
    }

    @Test
    @DisplayName("login courier with null password param of request ")
    @Description("Api /api/v1/login")
    public void logInCourierNullPasswordExpected400Test() // в реальности тк падает, 500 оошибка
    {
        courierLogInRequestModel = new CourierLogInRequestModel(courierCreateRequestModel.getLogin(), null);
        Response response = courierApi.loginCourier(courierLogInRequestModel);

        assertEquals(SC_BAD_REQUEST, response.getStatusCode());
    }

    @Test
    @DisplayName("login courier with error login param of request ")
    @Description("Api /api/v1/login")
    public void logInCourierInvalidLoginExpected404Test()
    {
        courierLogInRequestModel = new CourierLogInRequestModel(courierCreateRequestModel.getLogin() + "fvrwefgvergv", courierCreateRequestModel.getPassword());
        Response response = courierApi.loginCourier(courierLogInRequestModel);

        assertEquals(SC_NOT_FOUND, response.getStatusCode());
    }
    @Test
    @DisplayName("login courier with invalid password param of request ")
    @Description("Api /api/v1/login")
    public void logInCourierInvalidPasswordExpected404Test()
    {
        courierLogInRequestModel = new CourierLogInRequestModel(courierCreateRequestModel.getLogin(), courierCreateRequestModel.getPassword() + "wqerqwefwefweef");
        Response response = courierApi.loginCourier(courierLogInRequestModel);

        assertEquals(SC_NOT_FOUND, response.getStatusCode());
    }
}
