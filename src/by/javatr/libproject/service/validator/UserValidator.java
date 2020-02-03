package by.javatr.libproject.service.validator;

public class UserValidator {
    /**
     * login c ограничением 3-15 символов,
     * которыми могут быть буквы и цифры,
     * первый символ обязательно буква
     */
    public static boolean validateLogin(String login) {
        return login.matches("^[a-zA-Z][a-zA-Z0-9]{3,15}$");
    }

    /**
     * password с ограничением 3-18 символов,
     * которыми могут быть буквы и цифры,
     * первый символ обязательно буква
     */
    public static boolean validatePassword(String password) {

        return  password.matches("^[a-zA-Z][a-zA-Z0-9]{3,18}$");
    }
}
