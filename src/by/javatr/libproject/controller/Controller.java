package by.javatr.libproject.controller;

import by.javatr.libproject.controller.command.Command;

public final class Controller {
    private final CommandProvider provider = new CommandProvider();

    private final char paramDelimiter = ' ';

    public String executeTask(String request) {
        String commandName;
        String value;
        Command executionCommand;

        try {
            commandName = request.substring(0, request.indexOf(paramDelimiter));
            value = request.substring(request.indexOf(paramDelimiter) + 1);
        } catch (StringIndexOutOfBoundsException e) {
            return "Wrong command parameters";
        }

        executionCommand = provider.getCommand(commandName);

        String response = null;

        response = executionCommand.execute(value);

        return response;
    }
}
