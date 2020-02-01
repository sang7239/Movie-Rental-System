public class Comedy extends Movie implements Comparable<Movie>{
    private int priority;
    public Comedy(String genre, int stocks, String director, String title, int year, int priority) {
        super(genre, stocks, director, title, year);
        this.priority = priority;
    }

    public String toString() {
        return this.title;
    }

    public int getPriority() {
        return this.priority;
    }
    // hashValue: title + year + director + "C"

    public int getHashValue() {
        String val = super.title + super.year + super.director + "C";
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
        if (other instanceof Comedy) {
            if (this.title.compareTo(other.title) == 0) {
                return this.year - other.year;
            }
            return this.title.compareTo(other.title);
        }
        return super.compareTo(other);
    }
}
