package by.javatr.libproject.controller.command.impl;

import by.javatr.libproject.controller.command.Command;

public class WrongRequest implements Command {
    @Override
    public String execute(String request) {
        return "Command not found";
    }
}
