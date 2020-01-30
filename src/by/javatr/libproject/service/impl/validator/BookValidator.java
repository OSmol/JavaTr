package by.javatr.libproject.service.impl.validator;

public class BookValidator {
    public static boolean validateBookYear(int year) {

        String s = String.valueOf(year);
        return s.matches("\\d{1,4}$");
    }


    public static boolean validateAuthorName(String name) {
        return name.matches("([a-zA-Z-]|[а-яА-Я-]){2,25}([\\s]([a-zA-Z-]|[а-яА-Я-]){1,25}){0,3}$");
    }


}
