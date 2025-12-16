import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        greetUser();

    }

    public static void greetUser(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("What is your name? ");
        String name = scanner.nextLine();

        System.out.println("Nice to meet you, " + name + "!");

        System.out.println("How old are you?");
        
        int age = Integer.parseInt(scanner.nextLine());

        System.out.println("Next year you will be " + (age + 1));
    }
}