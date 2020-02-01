public class Borrow extends Transaction {
    private Movie movie;
    private String customerId;
    public Borrow(String customerId, Movie movie) {
        this.movie = movie;
        this.customerId = customerId;
    }
    public void execute() {
        if (!movie.borrowMovie()) {
            System.out.println("ERROR: Can't borrow " + "\"" + movie.title + "\" because no stock left");
        }
    }

    public String getCustomerId() {
        return customerId;
    }
    public String getReceipt() {
        return "Borrowed movie: " + movie.title;
    }
}
