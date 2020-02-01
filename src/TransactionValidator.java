public class TransactionValidator extends Validator {
    @Override
    public boolean isValidTransaction(Transaction transaction) {
        return false;
    }

    public boolean isValidFormat(Transaction transaction) {
        return false;
    }
}
