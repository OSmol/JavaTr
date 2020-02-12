package by.javatr.libproject.controller.command;

public interface Command {
    String execute(String request);

    default boolean checkSize(String[] array, int countParam) {
        return array.length == countParam;
    }
}
