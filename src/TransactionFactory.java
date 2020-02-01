import java.util.List;

public class TransactionFactory {
    public Transaction generateTransaction(String data, MovieInventory movieInventory) {
        char operation = data.charAt(0);
        if (operation == 'B' || operation == 'R') {
            String[] movie = data.split(" ", 5);
            String customerId = movie[1];
            String media = movie[2];
            String genre = movie[3];
            Movie m = movieInventory.findMovie(genre, movie[4]);
            if (m != null) {
                if (operation == 'B') {
                    return new Borrow(customerId, m);
                } else { // operation == 'R'
                    return new Return(customerId, m);
                }
            }
            return null;
        } else if (operation == 'H') {
            String customerId = data.split(" ")[1];
            if (movieInventory.existsCustomer(customerId)) {
                List<String> history = movieInventory.getHistoryOfCustomer(customerId);
                if (history != null) {
                    return new History(customerId, history);
                } else {
                    return null;
                }
            } else {
                return null;
            }
        } else if (operation == 'I') {
            return new Inventory(movieInventory.retrieveMovies());
        }
        return null;
    }
}
