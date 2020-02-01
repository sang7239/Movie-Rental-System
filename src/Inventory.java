import java.util.Collections;
import java.util.List;

public class Inventory extends Transaction {
    private List<Movie> movies;
    public Inventory(List<Movie> movies) {
        this.movies = movies;
    }
    public void execute() {
        System.out.println("--------------------------Movie Store Inventory--------------------------");
        Collections.sort(movies);
        for (Movie m : movies) {
            System.out.println("Movie Title: " + m.toString() + " stocks: " + m.getStocks());
        }
        System.out.println("-------------------------------------------------------------------------");
    }

    public String getReceipt() {
        return null;
    }

    public String getCustomerId() {
        return null;
    }
}
