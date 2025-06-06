
public class Main {
    public static void main(String[] args) {
        FinanceTracker financeTracker = new FinanceTracker();

        MenuManager menuManager = new MenuManager(financeTracker);
        menuManager.run();

    }
}
