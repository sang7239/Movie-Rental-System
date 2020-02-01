import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        MovieStore movieStore = new MovieStore("will's movie store", "data4movies.txt", "data4customers.txt");
        movieStore.executeTransactions("data4commands.txt");
    }
}
