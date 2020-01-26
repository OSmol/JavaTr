package by.javatr.libproject.controller;

import by.javatr.libproject.controller.command.Command;
import by.javatr.libproject.controller.command.CommandName;
import by.javatr.libproject.controller.command.impl.*;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
    private final Map<CommandName, Command> repository = new HashMap<>();

    public CommandProvider() {
        repository.put(CommandName.SIGN_IN, new SignIn());
        repository.put(CommandName.WRONG_REQUEST, new WrongRequest());
        repository.put(CommandName.REGISTRATION, new Registration());
        repository.put(CommandName.SB, new ShowBook());
        repository.put(CommandName.ADD_BOOK, new AddBook());
        repository.put(CommandName.DELETE_BOOK, new DeleteBook());
    }

    public Command getCommand(String name) {
        CommandName commandName = null;
        Command command = null;

        try {
            commandName = CommandName.valueOf(name.toUpperCase());
            command = repository.get(commandName);
        } catch (IllegalArgumentException | NullPointerException e) {
            command = repository.get(CommandName.WRONG_REQUEST);
        }

        return command;
    }
}
