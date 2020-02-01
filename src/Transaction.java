public abstract class Transaction {
    public Transaction() {
    }
    public abstract void execute();
    public abstract String getCustomerId();
    public abstract String getReceipt();
}
