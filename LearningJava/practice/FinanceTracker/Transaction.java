import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Transaction implements Serializable {

    private TransactionType transactionType;
    private Category transactionCategory;
    private double amount;
    private String detail; //Stores information such as who is charging or providing the income.
    private LocalDate date;
    private static final long serialVersionUID = 1L;


    public Transaction(TransactionType transactionType, Category transactionCategory, double amount, String detail){
        this.transactionType = transactionType;
        this.transactionCategory = transactionCategory;
        this.amount = Math.abs(amount);
        this.detail = detail;
        this.date = LocalDate.now();

    }

    public Transaction(TransactionType transactionType, Category transactionCategory, double amount, String detail, LocalDate date){
        this(transactionType, transactionCategory, amount, detail);
        this.date = date;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public Category getTransactionCategory() {
        return transactionCategory;
    }

    public void setTransactionCategory(Category transactionCategory) {
        this.transactionCategory = transactionCategory;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = Math.abs(amount);
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public LocalDate getDate(){
        return date;
    }

    public void setDate(LocalDate date){
        this.date = date;
    }

      @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        return String.format("%s | %s | $%.2f | %s | %s", 
                           date.format(formatter),
                           transactionType,
                           amount,
                           transactionCategory,
                           detail);
    }
    
}
