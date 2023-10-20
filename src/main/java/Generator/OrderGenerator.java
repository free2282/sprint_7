package Generator;

import JsonModel.CourierCreateRequestModel;
import JsonModel.OrderCreateRequestModel;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import static org.apache.commons.lang3.RandomUtils.nextInt;

public class OrderGenerator
{
    public static OrderCreateRequestModel getRandomCourierCreateWithFirstName()
    {
        Date currentDate = new Date();
        SimpleDateFormat deliveryDateGenerator = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        String formattedDate = dateFormat.format(currentDate);
        String dataForDeliveryDate = deliveryDateGenerator.format(currentDate);

        Random rnd = new Random();
        String firstName = formattedDate;
        String lastName = formattedDate;
        String address = formattedDate;
        String metroStation = formattedDate;
        String phone = formattedDate;
        int rentTime = rnd.nextInt(10);
        String deliveryDate = dataForDeliveryDate;
        String comment = formattedDate;
        String[] color = {};
        return new OrderCreateRequestModel(firstName, lastName, address, metroStation, phone, rentTime, deliveryDate, comment, color);
    }
}
