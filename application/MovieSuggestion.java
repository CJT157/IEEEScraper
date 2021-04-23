import java.io.File;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

    public void loadMovieInfo() throws FileNotFoundException, ParseException, MalformedURLException {
        File movieList = new File(userDirectory + "/top_movies.txt");
        Scanner movieScanner = new Scanner(movieList);
        while (movieScanner.hasNextLine()) {
            String title = "";
            Date release = new Date();
            String plot = "";
            double rating = 0;
            URL poster = new URL("www.google.com");
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
                        String genreList = movieScanner.nextLine().replaceAll("[", " ").replaceAll("]", " ").replaceAll("'", "").trim();
                        String[] genresStrings = genreList.split(", ");
                        for (String item : genresStrings) {
                            genres.add(item);
                        }
                        break;
                    case 3:
                    //directors
                        String directorList = movieScanner.nextLine().replaceAll("[", " ").replaceAll("]", " ").replaceAll("'", "").trim();
                        directors.add(directorList);
                        break;
                    case 4:
                    //plot
                        plot = movieScanner.nextLine();
                        break;
                    case 5:
                    //rating
                        rating = Double.parseDouble(movieScanner.nextLine());
                        break;
                    case 6:
                    //actors
                        String actorList = movieScanner.nextLine().replaceAll("[", " ").replaceAll("]", " ").replaceAll("'", "").trim();
                        String[] actorStrings = actorList.split(", ");
                        for (String item : actorStrings) {
                            stars.add(item);
                        }
                        break;
                    case 7:
                    //poster
                        poster = new URL(movieScanner.nextLine());
                        break;
                }
            }
            movies.add(new Movie(title, release, plot, rating, poster, genres, directors, stars));
        }
        movieScanner.close();
    }

    public ArrayList<Movie> getMatchingMovies(String genre1, String genre2, String genre3){
        ArrayList<Movie> matchingMovies = new ArrayList<Movie>();
        ArrayList<String> validGenres = new ArrayList<String>();

        if(!genre1.equals("")){
            validGenres.add(genre1);
        }
        if (!genre2.equals("")) {
            validGenres.add(genre2);
        }
        if (!genre3.equals(genre3)) {
            validGenres.add(genre3);
        }

        for (Movie m : movies) {
            for (String genre : m.getGenres()) {
                for(int i = 0; i < validGenres.size(); i++){
                    if (genre.equals(validGenres.get(i))) {
                        
                    }
                }
            }
        }

        return matchingMovies;
    } 


}
 