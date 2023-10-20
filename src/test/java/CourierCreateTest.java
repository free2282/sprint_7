import Generator.CourierGenerator;
import JsonModel.CourierCreateRequestModel;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import org.junit.Before;
import org.junit.Test;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import io.restassured.http.ContentType;
import static ConfigApp.ConfigApp.MAIN_URL;
import static Generator.CourierGenerator.*;
import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import ApiClient.CourierApiClient;
public class CourierCreateTest
{
    private CourierCreateRequestModel courierCreateRequestModel;
    private CourierApiClient courierApiClient;
    @Before
    public void setUp()
    {
        courierApiClient = new CourierApiClient();
        courierCreateRequestModel = getRandomCourierCreateWithFirstName();
    }

    @Test
    @DisplayName("create courier test")
    @Description("")
    public void createCourierTest()
    {
        Response response = courierApiClient.createCourier(courierCreateRequestModel);

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
        Response response = courierApiClient.createCourier(courierCreateRequestModelExistingLogin);
        assertEquals(SC_CONFLICT, response.statusCode());
    }

    @Test
    @DisplayName("create second existing courier")
    public void createCourierCheckCantCreateEqualCourier()
    {
        courierApiClient.createCourier(courierCreateRequestModel);
        Response response = courierApiClient.createCourier(courierCreateRequestModel);

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
        Response response = courierApiClient.createCourier(courierCreateRequestModeVoidLogin);
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
        Response response = courierApiClient.createCourier(courierCreateRequestModeVoidPassword);
        assertEquals(SC_BAD_REQUEST, response.statusCode());
    }
}
