import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MenuManager {

    private FinanceTracker financeTracker;

    public MenuManager(FinanceTracker financeTracker) {
        this.financeTracker = financeTracker;
    }

    public void noTransactionMessage() {
        System.out.println("There are no transactions to display\n");
    }

    public void displayMenu() {
        System.out.println("=== Personal Finance Tracker ===\r\n" + //
                "1. Add Income\r\n" + //
                "2. Add Expense  \r\n" + //
                "3. View All Transactions\r\n" + //
                "4. View Transactions by Category\r\n" + //
                "5. View Financial Summary\r\n" + //
                "6. Save Data\r\n" + //
                "7. Load Data\r\n" + //
                "8. Exit\r\n" + //
                "Enter your choice:");
    }

    public int getUserChoice(Scanner sc) {
        int userChoice = -1;

        try {
            if (sc.hasNextInt()) {
                userChoice = sc.nextInt();
                sc.nextLine();
            } else {
                System.out.println("Please enter a valid option.");
                sc.nextLine();
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Invalid choice. Try again.");
            sc.nextLine();
        }

        return userChoice;

    }

    public void handleViewByCategory(Scanner sc) {
        for (Category c : Category.values()) {

            System.out.println(c.ordinal() + " " + c);
        }

        System.out.println("Enter your choice: ");
        int userChoice = getUserChoice(sc);
        if (userChoice >= 0 && userChoice < Category.values().length) {
            Category selectedCategory = Category.values()[userChoice];
            List<Transaction> selectedTransactions = financeTracker.getTransactionsByCategory(selectedCategory)
                    .collect(Collectors.toList());
            if (!selectedTransactions.isEmpty()) {
                selectedTransactions.forEach(System.out::println);

            } else {
                noTransactionMessage();
            }
        } else {
            System.out.println("Invalid category.");
        }

    }

    public void handleAddIncome(Scanner sc) {
        System.out.println("\nEnter INCOME amount: ");
        double amount = sc.nextDouble();
        sc.nextLine();
        System.out.println("Enter short detail of transaction: ");
        String detail = sc.nextLine();

        Transaction newTransaction = new Transaction(TransactionType.INCOME, Category.OTHER, amount, detail);
        financeTracker.addTransaction(newTransaction);

    }

    public void handleAddExpense(Scanner sc) {
        System.out.println("What is the category? ");
        for (Category c : Category.values()) {

            System.out.println(c.ordinal() + " " + c);
        }
        int userChoice = getUserChoice(sc);
        Category selectedCategory = Category.values()[userChoice];
        System.out.println("\nEnter amount: ");
        double amount = sc.nextDouble();
        sc.nextLine();
        System.out.println("Enter short detail of transaction: ");
        String detail = sc.nextLine();

        Transaction newTransaction = new Transaction(TransactionType.EXPENSE, selectedCategory, amount, detail);
        financeTracker.addTransaction(newTransaction);

    }

    public void handleSaveData(Scanner sc) {
        System.out.println("Enter filename (Do not include '.txt'): ");
        String filename = sc.nextLine();
        financeTracker.writeToFile(filename + ".txt");
        System.out.println("File successfully saved.");
    }

    public void handleLoadData(Scanner sc) {
        System.out.println("Enter filename to load (Do not include '.txt'): ");
        String filename = sc.nextLine();

        financeTracker.loadFromFile(filename + ".txt");

    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            displayMenu();
            int choice = getUserChoice(sc);
            switch (choice) {
                case 1:
                    handleAddIncome(sc);
                    break;
                case 2:
                    handleAddExpense(sc);
                    break;
                case 3:
                    if (financeTracker.getAllTransactions().count() > 0)
                        financeTracker.getAllTransactions().forEach(System.out::println);
                    else
                        noTransactionMessage();
                    break;
                case 4:
                    handleViewByCategory(sc);
                    break;
                case 5:
                    System.out.println("Total Income: " + financeTracker.totalIncome());
                    System.out.println("Total Expenses: " + financeTracker.totalExpenses());
                    System.out.println("Balance: " + financeTracker.calculateBalance());
                    break;
                case 6:
                    handleSaveData(sc);
                    break;
                case 7:
                    handleLoadData(sc);
                    break;
                case 8:
                    System.out.println("Good Bye!");
                    return;

                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }
}
