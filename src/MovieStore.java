import java.io.File;
import java.io.IOException;
import java.util.*;

public class MovieStore {
    private String name;
    private MovieInventory movieInventory;
    private Validator validator;
    public MovieStore(String name, String movieList, String customerList) throws IOException {
        this.name = name;
        this.movieInventory = new MovieInventory();
        this.validator = new TransactionValidator();
        Scanner movieScanner = new Scanner(new File(movieList));
        addMovies(movieScanner);
        Scanner customerScanner = new Scanner(new File(customerList));
        addCustomers(customerScanner);
    }

    private void addMovies(Scanner scanner) {
        MovieFactory generator = new MovieFactory();
        while (scanner.hasNextLine()) {
            String data = scanner.nextLine();
            String[] attr = data.split(", ", 3);
            String genre = attr[0];
            int stock = Integer.parseInt(attr[1]);
            String info = attr[2];
            Movie movie = generator.generateMovie(genre, stock, info);
            if (movie != null) {
                movieInventory.insertMovie(movie);
            }
        }
    }

    private void addCustomers(Scanner scanner) {
        while (scanner.hasNextLine()) {
            String data = scanner.nextLine();
            String[] attr = data.split(" ");
            String id = attr[0];
            movieInventory.insertCustomer(id, attr[1], attr[2]);
        }
    }

    public void executeTransactions(String file) throws IOException {
        Scanner scanner = new Scanner(new File(file));
        TransactionFactory generator = new TransactionFactory();
        while (scanner.hasNextLine()) {
            String data = scanner.nextLine();
            Transaction transaction = generator.generateTransaction(data, movieInventory);
            if (transaction != null) {
                transaction.execute();
                if (transaction.getCustomerId() != null) {
                    movieInventory.addToHistory(transaction.getCustomerId(), transaction.getReceipt());
                }
            }
        }
    }
}