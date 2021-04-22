import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class MovieSuggestion {
    
    private static MovieSuggestion movieSuggestion;
    private static ArrayList<Movie> movies = new ArrayList<Movie>();
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

    public void loadMovieInfo() throws FileNotFoundException, ParseException {
        File movieList = new File(userDirectory + "/top_movies.txt");
        Scanner movieScanner = new Scanner(movieList);
        while (movieScanner.hasNextLine()) {
            String title = "";
            Date release = new Date();
            String plot = "";
            double rating = 0;
            String poster = "";
            ArrayList<String> genres = new ArrayList<String>();
            ArrayList<String> directors = new ArrayList<String>();
            ArrayList<String> stars = new ArrayList<String>();
            for (int i = 0; i < 8; i++) {
                switch (i) {
                    case 0:
                        title = movieScanner.nextLine();
                        break;
                    case 1:
                        release = new SimpleDateFormat("yyyy-dd-MM").parse(movieScanner.nextLine());
                        break;
                    case 2:
                    //genres
                    break;
                    case 3:
                    //directors
                        rating = Double.parseDouble(movieScanner.nextLine());
                        break;
                    case 4:
                    //plot
                        plot = movieScanner.nextLine();
                        break;
                    case 5:
                    //rating
                        
                        break;
                    case 6:
                    //actors
                        break;
                    case 7:
                    //poster
                        poster = movieScanner.nextLine();
                        break;
                }
            }
            movies.add(new Movie(title, release, plot, rating, poster, genres, directors, stars));
        }
        
    }


}
