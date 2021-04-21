import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MovieSuggestion {
    
    private static MovieSuggestion movieSuggestion;

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
        File movieList = new File("movieList.txt");
        Scanner movieScanner = new Scanner(movieList);
        while (movieScanner.hasNextLine()) {
            //read stuff here
        }
        // Load movie file and create list of movies from it
    }


}
