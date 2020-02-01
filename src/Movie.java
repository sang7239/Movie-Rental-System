public abstract class Movie implements Comparable<Movie> {
    public String genre;
    public int stocks;
    public String director;
    public String title;
    public int year;
    public boolean borrowed;
    public Movie(String genre, int stocks, String director, String title, int year) {
        this.genre = genre;
        this.stocks = stocks;
        this.director = director;
        this.title = title;
        this.year = year;
        this.borrowed = false;
    }
    public abstract String toString();
    protected abstract int getPriority();
    protected abstract int getHashValue();
    public abstract void addStock(int stock);
    public abstract int getStocks();
    public abstract boolean borrowMovie();
    public abstract boolean returnMovie();
    public int compareTo(Movie other) {
        return this.getPriority() - other.getPriority();
    }
}
