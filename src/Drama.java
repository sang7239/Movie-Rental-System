public class Drama extends Movie implements Comparable<Movie>{
    private int priority;
    public Drama(String genre, int stocks, String director, String title, int year, int priority) {
        super(genre, stocks, director, title, year);
        this.priority = priority;
    }

    public String toString() {
        return this.title;
    }
    public int getPriority() {
        return priority;
    }
    // hashValue: title + year + director + "D"
    public int getHashValue() {
        String val = super.title + super.year + super.director + "D";
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
        if (other instanceof Drama) {
            if (this.director.compareTo(other.director) != 0) {
                return this.title.compareTo(other.title);
            }
            return this.director.compareTo(other.director);
        }
        return super.compareTo(other);
    }
}
