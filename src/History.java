import java.util.List;

public class History extends Transaction {
    List<String> history;
    String customerId;
    public History(String customerId, List<String> history) {
        this.customerId = customerId;
        this.history = history;
    }
    public void execute() {
        System.out.println("--------------------Transaction History for " + customerId + "-------------------------");
        for (String transaction : history) {
            System.out.println(transaction);
        }
        System.out.println("-------------------------------------------------------------------------");
    }

    public String getCustomerId() {
        return null;
    }
    public String getReceipt() {
        return null;
    }
}
