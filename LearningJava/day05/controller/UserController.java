package controller;

import service.UserService;
import model.User;
import java.util.Scanner;

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
        System.out.println("Name: ");
        String name = scanner.nextLine();

        System.out.println("Age: ");
        int age = Integer.parseInt(scanner.nextLine());

        userService.addUser(name, age);
        System.out.println("User added.");
    }

    private void listUsers() {
        for (User user : userService.getAllUsers()) {
            System.out.println(user.getName() + "(" + user.getAge() + ")");
        }
    }

    private void findUser(){
        System.out.println("Name to find: ");
        String name = scanner.nextLine();

        User user = userService.findByName(name);
        if(user == null){
            System.out.println("User not found.");
        }else{
            System.out.println(user.getName() + " is " + user.getAge());
        }
    }

    

}
