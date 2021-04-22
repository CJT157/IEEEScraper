import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MovieSuggestion {
    
    private static MovieSuggestion movieSuggestion;
    private static String userDirectory = System.getProperty("user.dir");

    /**
     * Singleton method to make sure the movieSuggestion object is consistent wherever we use it
     * @return movieSuggestion object
     */
    public static MovieSuggestion getMovieSuggestion() {
        if (movieSuggestion == null) {
            movieSuggestion = new MovieSuggestion();
        }
        return movieSuggestion;
    }

    private MovieSuggestion() {}

    public void loadMovieInfo() throws FileNotFoundException {
        File movieList = new File(userDirectory + "/top_movies.txt");
        Scanner movieScanner = new Scanner(movieList);
        while (movieScanner.hasNextLine()) {
            String info = movieScanner.nextLine();
        }
        // Load movie file and create list of movies from it
    }


}
