public class Return extends Transaction {
    private Movie movie;
    private String customerId;
    public Return(String customerId, Movie movie) {
        this.movie = movie;
        this.customerId = customerId;
    }
    public void execute() {
        if (!movie.returnMovie()) {
            System.out.println("ERROR: Can't Return " + movie.title + " since it has not been borrowed");
        }
    }

    public String getCustomerId() {
        return customerId;
    }
    public String getReceipt() {
        return "Returned movie: " + movie.title;
    }
}
