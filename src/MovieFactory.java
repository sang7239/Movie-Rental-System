public class MovieFactory {
    public Movie generateMovie(String genre, int stock, String movieInfo) {
        String[] attr = movieInfo.trim().split(",");
        String director = attr[0].trim();
        String title = attr[1].trim();
        if (genre.equalsIgnoreCase("F")) {
            int year = Integer.parseInt(attr[2].trim());
            return new Comedy("F", stock, director, title, year, 1);
        } else if (genre.equalsIgnoreCase("D")) {
            int year = Integer.parseInt(attr[2].trim());
            return new Drama("D", stock, director, title, year, 2);
        } else if (genre.equalsIgnoreCase("C")) {
            String[] details = attr[2].trim().split(" ");
            String firstName = details[0];
            String lastName = details[1];
            int releaseMonth = Integer.parseInt(details[2]);
            int releaseYear = Integer.parseInt(details[3]);
            return new Classics("C", stock, director, title, firstName, lastName, releaseMonth, releaseYear, 3);
        } else {
            return null;
        }
    }
}
