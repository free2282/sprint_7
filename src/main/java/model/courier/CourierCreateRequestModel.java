package model.courier;

public class CourierCreateRequestModel
{
      String login ;
      String password ;
      String firstName ;

    public CourierCreateRequestModel(String login, String password, String firstName)
    {
        this.login = login;
        this.password = password;
        this.firstName = firstName;
    }

    public CourierCreateRequestModel(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public CourierCreateRequestModel()
    {

    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }
}
