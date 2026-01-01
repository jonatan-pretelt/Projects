package controller;

import service.InvalidUserException;
import service.UserService;
import model.User;
import java.util.Scanner;
import java.util.Optional;

public class UserController {
    private UserService userService;
    private Scanner scanner = new Scanner(System.in);

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public void start() {
        while (true) {
            System.out.println("\n1. Add user");
            System.out.println("2. List users");
            System.out.println("3. Find user");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> addUser();
                case "2" -> listUsers();
                case "3" -> findUser();
                case "4" -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }

        }
    }

    private void addUser() {
        try{
            System.out.println("Name: ");
        String name = scanner.nextLine();

        System.out.println("Age: ");
        int age = Integer.parseInt(scanner.nextLine());

        userService.addUser(name, age);
        System.out.println("User added.");
        } catch(InvalidUserException e){
            System.out.println("Error: " + e.getMessage());
        }
        
    }

    private void listUsers() {
        for (User user : userService.getAllUsers()) {
            System.out.println(user.getName() + "(" + user.getAge() + ")");
        }
    }

    private void findUser() {
        System.out.println("Name to find: ");
        String name = scanner.nextLine();

        userService.findByName(name).ifPresentOrElse(
                user -> System.out.println(user.getName() + " is " + user.getAge()),
                () -> System.out.println("User not found."));
    }

}
