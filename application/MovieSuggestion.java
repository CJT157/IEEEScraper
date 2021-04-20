import java.io.File;

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

    public void loadMovieInfo() {
        File movieList = new File("movieList.txt");
        // Load movie file and create list of movies from it
    }


}
