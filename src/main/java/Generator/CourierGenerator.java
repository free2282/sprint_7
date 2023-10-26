package Generator;
import Model.Courier.Post.CourierCreateRequestModel;

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
