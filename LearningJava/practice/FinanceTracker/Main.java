import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        FinanceTracker financeTracker = new FinanceTracker();

        financeTracker.addTransaction(new Transaction(
                TransactionType.INCOME, Category.OTHER, 2500, "Google payroll"));
        financeTracker.addTransaction(new Transaction(
                TransactionType.EXPENSE, Category.HOUSING, 1200, "rent"));
        financeTracker.addTransaction(new Transaction(
                TransactionType.EXPENSE, Category.ENTERTAINMENT, 300, "Fun stuff"));
        financeTracker.addTransaction(new Transaction(
                TransactionType.EXPENSE, Category.UTILITIES, 200, "electricity"));

        System.out.println("Total Income: " + financeTracker.totalIncome());
        System.out.println("Total Expenses: " + financeTracker.totalExpenses());
        System.out.println("Current Balance: " + financeTracker.calculateBalance());

        System.out.println("\nAll Transactions:\n");
        financeTracker.getAllTransactions().forEach(System.out::println);

        Stream<Transaction> housingExpense = financeTracker.getTransactionsByCategory(Category.HOUSING);
        System.out.println("\nHousing Expense: \n");

        housingExpense.forEach(System.out::println);

        financeTracker.writeToFile("finances.txt");
        financeTracker.loadFromFile("finances.txt");

        System.out.println("\n--- After loading from file ---");
        System.out.println("Total Income: " + financeTracker.totalIncome());
        System.out.println("Current Balance: " + financeTracker.calculateBalance());
        System.out.println("");
    }
}
