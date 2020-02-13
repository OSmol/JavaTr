package by.javatr.libproject.service.validator;

public class UserValidator {

    public static boolean validateLogin(String login) {
        return login.matches("^[a-zA-Z][a-zA-Z0-9]{3,15}$");
    }

    public static boolean validatePassword(String password) {

        return  password.matches("^[a-zA-Z][a-zA-Z0-9]{3,18}$");
    }
}
