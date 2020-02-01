public class Classics extends Movie implements Comparable<Movie>{
    private int month;
    private String firstName;
    private String lastName;
    private int priority;
    public Classics(String genre, int stocks, String director, String title, String firstName, String lastName, int month, int year, int priority) {
        super(genre, stocks, director, title, year);
        this.month = month;
        this.firstName = firstName;
        this.lastName = lastName;
        this.priority = priority;
    }

    public String toString() {
        return this.title;
    }

    public int getPriority() {
        return this.priority;
    }

    public int getHashValue() {
        String val = "" + this.month + super.year + this.firstName + this.lastName;
        return val.hashCode();
    }

    public void addStock(int stock) {
        super.stocks += stock;
    }

    public int getStocks() {
        return this.stocks;
    }

    public boolean borrowMovie() {
        if (stocks > 0) {
            stocks--;
            borrowed = true;
            return true;
        } else {
            return false;
        }
    }

    public boolean returnMovie() {
        if (borrowed) {
            stocks++;
            borrowed = false;
            return true;
        } else {
            return false;
        }
    }

    public int compareTo(Movie other) {
        if (other instanceof Classics) {
            Classics classics = (Classics) other;
            if (this.year == classics.year) {
                if (this.month == classics.month) {
                    return this.firstName.compareTo(classics.firstName) == 0
                            ? this.lastName.compareTo(classics.lastName) : this.firstName.compareTo(classics.firstName);
                }
                return this.month - classics.month;
            }
            return this.year - classics.year;
        }
        return super.compareTo(other);
    }
}
