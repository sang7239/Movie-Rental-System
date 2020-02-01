public abstract class Validator {
    public abstract boolean isValidTransaction(Transaction transaction);
    public abstract boolean isValidFormat(Transaction transaction);
}
