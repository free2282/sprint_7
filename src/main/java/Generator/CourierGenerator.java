package Generator;
import JsonModel.CourierCreateRequestModel;
import JsonModel.CourierLogInRequestModel;
import org.apache.commons.lang3.RandomStringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CourierGenerator
{
    public static CourierCreateRequestModel getRandomCourierCreateWithFirstName()
    {
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String formattedDate = dateFormat.format(currentDate);

        String login = formattedDate;
        String password = formattedDate;
        String firstName = formattedDate;

        return new CourierCreateRequestModel(login, password, firstName);
    }
    public static CourierCreateRequestModel getRandomCourierCreateWithoutFirstName()
    {
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String formattedDate = dateFormat.format(currentDate);

        String login = formattedDate;
        String password = formattedDate;

        return new CourierCreateRequestModel(login, password);
    }

}
