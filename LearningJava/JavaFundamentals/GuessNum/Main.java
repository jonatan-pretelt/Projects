import java.util.Random;
import java.util.Scanner;

class Main {

    public static void displayQuestion() {

        System.out.println("Guess an integer number between 1 and 20? ");

    }

    public static int getUserNumber(Scanner sc) {

        
        int userGuess = sc.nextInt();
        sc.nextLine(); // throwaway line
        
        return userGuess;
    }

    public static void main(String[] args) {

        Random randomGenerator = new Random();
        int secretNum = randomGenerator.nextInt(20);
        System.out.println("Secret number: " + secretNum);
        Scanner sc = new Scanner(System.in);
        while (true) {
            displayQuestion();
            int userGuess = getUserNumber(sc);
            
            if (userGuess == secretNum) {
                System.out.println("Nice you guessed the number " + secretNum);
                break;
            }

        }

        sc.close();

    }
}