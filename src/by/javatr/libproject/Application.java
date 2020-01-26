package by.javatr.libproject;

import by.javatr.libproject.controller.Controller;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Controller controller = new Controller();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hello, User! Its library project by Novikov A.S.");

        String request = null;
        for (; ; ) {
            System.out.println("Введите комманду:");
            request = scanner.nextLine();
            System.out.println(controller.executeTask(request));
        }

    }
}
