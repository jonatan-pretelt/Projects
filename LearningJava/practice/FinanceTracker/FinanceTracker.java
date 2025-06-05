import java.util.List;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.stream.Stream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;

public class FinanceTracker implements Serializable {

    private List<Transaction> transactions;
  
    private static final long serialVersionUID = 1L;

    FinanceTracker() {
        transactions = new ArrayList<Transaction>();
    }

    public void addTransaction(Transaction newTransaction) {
        transactions.add(newTransaction);
    }

    public Stream<Transaction> getAllTransactions() {

        Stream<Transaction> transactionStream = transactions.stream();
        return transactionStream;
    }

    public double totalIncome() {
        TransactionType income = TransactionType.INCOME;
        double totalIncome = transactions.stream()
                .filter(t -> t.getTransactionType() == income)
                .mapToDouble(Transaction::getAmount)
                .sum();
        return totalIncome;
    }

    public double totalExpenses() {
        TransactionType expense = TransactionType.EXPENSE;
        double totalExpenses = transactions.stream()
                .filter(t -> t.getTransactionType() == expense)
                .mapToDouble(Transaction::getAmount)
                .sum();
        return totalExpenses;
    }

    public double calculateBalance() {
        double balance = totalIncome() - totalExpenses();
        return balance;
    }

    public Stream<Transaction> getTransactionsByCategory(Category category) {
        return transactions.stream().filter(t -> t.getTransactionCategory() == category);
    }

    public void writeToFile(String filePath) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath))) {
            objectOutputStream.writeObject(this.transactions);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public List<Transaction> loadFromFile(String filePath) {
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath)) ){
            this.transactions = (List<Transaction>) objectInputStream.readObject();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return this.transactions;

    }
}
