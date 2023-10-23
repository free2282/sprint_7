import JsonModel.CourierCreateRequestModel;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import io.restassured.response.Response;

import static Generator.CourierGenerator.*;
import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import Api.CourierApi;
public class CourierCreateTest
{
    private CourierCreateRequestModel courierCreateRequestModel;
    private CourierApi courierApi;
    @Before
    public void setUp()
    {
        courierApi = new CourierApi();
        courierCreateRequestModel = getRandomCourierCreateWithFirstName();
    }

    @Test
    @DisplayName("create courier test")
    @Description("")
    public void createCourierTest()
    {
        Response response = courierApi.createCourier(courierCreateRequestModel);

        response.then().assertThat().body("ok", equalTo(true)); // проверка тела ответа ok
        assertEquals(SC_CREATED, response.statusCode()); // проверка статуса ответа
    }

    @Test
    @DisplayName("create courier with existing login")
    public void createCourierWithEXistedLogin()
    {
        CourierCreateRequestModel courierCreateRequestModelExistingLogin = new CourierCreateRequestModel
                (
                "ninja",
                "qwe12rf423",
                "Borya"
                );
        Response response = courierApi.createCourier(courierCreateRequestModelExistingLogin);
        assertEquals(SC_CONFLICT, response.statusCode());
    }

    @Test
    @DisplayName("create second existing courier")
    public void createCourierCheckCantCreateEqualCourier()
    {
        courierApi.createCourier(courierCreateRequestModel);
        Response response = courierApi.createCourier(courierCreateRequestModel);

        assertEquals(SC_CONFLICT, response.statusCode()); // проверка статуса ответа
    }

    @Test
    @DisplayName("create courier with void login")
    public void createCourierWithVoidLogin()
    {
        CourierCreateRequestModel courierCreateRequestModeVoidLogin = new CourierCreateRequestModel
                (
                        null,
                        "qwe12rf423",
                        "Borya"
                );
        Response response = courierApi.createCourier(courierCreateRequestModeVoidLogin);
        assertEquals(SC_BAD_REQUEST, response.statusCode());
    }
    @Test
    @DisplayName("create courier with void password")
    public void createCourierWithVoidPassword()
    {
        CourierCreateRequestModel courierCreateRequestModeVoidPassword = new CourierCreateRequestModel
                (
                        "ninja",
                        null,
                        "Borya"
                );
        Response response = courierApi.createCourier(courierCreateRequestModeVoidPassword);
        assertEquals(SC_BAD_REQUEST, response.statusCode());
    }
}
