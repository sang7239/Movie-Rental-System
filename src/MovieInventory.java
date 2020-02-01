import java.util.*;

public class MovieInventory {
    // title -> movie
    protected Map<String, Movie> movieInventory;
    // month, year, actor -> title
    protected Map<Integer, String> classics;
    protected Map<String, Customer> directory;
    protected Map<String, List<String>> history;
    protected MovieInventory() {
        this.movieInventory = new HashMap<>();
        this.classics = new HashMap<>();
        this.directory = new HashMap<>();
        this.history = new HashMap<>();
    }

    protected void insertMovie(Movie movie) {
        if (movie.genre.equalsIgnoreCase("C")) {
            insertClassicsMovie(movie);
        } else {
            movieInventory.put(movie.title, movie);
        }
    }

    protected void insertClassicsMovie(Movie movie) {
        if (!classics.containsKey(movie.getHashValue())) {
            classics.put(movie.getHashValue(), movie.title);
            movieInventory.put(movie.title, movie);
        } else {
            movieInventory.get(movie.title).addStock(movie.stocks);
        }
    }

    protected List<Movie> retrieveMovies() {
        List<Movie> movies = new LinkedList<>();
        for (String title : movieInventory.keySet()) {
            movies.add(movieInventory.get(title));
        }
        return movies;
    }
    //        C 9 1938 Katherine Hepburn
    //        F Pirates of the Caribbean, 2003
    protected Movie findMovie(String genre, String movieData) {
        if (genre.equalsIgnoreCase("C")) {
            String[] movie = movieData.split(" ");
            return findClassicsMovie(Integer.parseInt(movie[0]), Integer.parseInt(movie[1]), movie[2], movie[3]);
        } else if (genre.equalsIgnoreCase("F")){
            String[] movie = movieData.split(",");
            String title = movie[0].trim();
            if (movieInventory.containsKey(title)) {
                return movieInventory.get(title);
            } else {
                return null;
            }
        } else if (genre.equalsIgnoreCase("D")) {
            String[] movie = movieData.split(",");
            String title = movie[1].trim();
            if (movieInventory.containsKey(title)) {
                return movieInventory.get(title);
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    protected Movie findClassicsMovie(int month, int year, String firstName, String lastName) {
        String key = "" + month + year + firstName + lastName;
        if (classics.containsKey(key.hashCode())) {
            String title = classics.get(key.hashCode());
            return movieInventory.get(title);
        }
        return null;
    }

    protected void insertCustomer(String id, String firstName, String lastName) {
        directory.put(id, new Customer(firstName, lastName));
    }

    protected boolean existsCustomer(String id) {
        return directory.containsKey(id);
    }

    protected List<Customer> getCustomers() {
        List<Customer> customers = new ArrayList<>();
        for (String id : directory.keySet()) {
            customers.add(directory.get(id));
        }
        return customers;
    }

    protected List<String> getHistoryOfCustomer(String customerId) {
        if (history.containsKey(customerId)) {
            return history.get(customerId);
        }
        return null;
    }
    protected void addToHistory(String customerId, String receipt) {
        if (!history.containsKey(customerId)) {
            history.put(customerId, new LinkedList<>());
        }
        history.get(customerId).add(receipt);
    }
}
