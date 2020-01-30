package by.javatr.libproject.service.validator;

public class UserValidator {
    /**
     * login c ограничением 1-20 символов,
     * которыми могут быть буквы и цифры,
     * символ подчеркивания, дефис,
     * первый символ обязательно буква
     */
    public static boolean validateLogin(String login) {
        return login.matches("^[a-zA-Z][a-zA-Z0-9]{3,15}$");
    }

    /**
     * password с ограничением 6-18 символов,
     * которыми могут быть буквы и цифры,
     * символ подчеркивания, дефис,
     * первый символ обязательно буква
     */
    public static boolean validatePassword(String password) {

        return  password.matches("^[a-zA-Z][a-zA-Z0-9]{3,18}$");
    }
}
