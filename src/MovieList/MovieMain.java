package MovieList;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MovieMain {
    public static void main(String[] args) {
        List<Movie> movies = Arrays.asList(
                new Movie("Inception", "Christopher Nolan", 2011, 8.8),
                new Movie("The Dark Knight", "Christopher Nolan", 2008, 9.0),
                new Movie("Interstellar", "Christopher Nolan", 2014, 6.6),
                new Movie("Pulp Fiction", "Quentin Tarantino", 1994, 8.9),
                new Movie("Fight Club", "David Fincher", 1999, 8.8),
                new Movie("The Matrix", "Lana Wachowski", 1999, 7.7),
                new Movie("Forrest Gump", "Robert Zemeckis", 1994, 8.8),
                new Movie("The Shawshank Redemption", "Frank Darabont", 1994, 9.3),
                new Movie("Gladiator", "Ridley Scott", 2000, 8.5),
                new Movie("The Lord of the Rings: The Return of the King", "Peter Jackson", 2003, 8.9)
        );

//        movies.stream().filter(movie -> movie.getRating() > 8.0).forEach(System.out::println);
//
//        List<String> directors = movies.stream().map(Movie::getDirector).distinct().toList();
//        directors.forEach(System.out::println);
//
//        movies.stream().max(Comparator.comparingDouble(Movie::getRating)).ifPresent(System.out::println);
//
//        long count = movies.stream().filter(movie -> movie.getReleaseYear() > 2010).count();
//        System.out.println(count);

//        movies.stream().sorted(Comparator.comparing(Movie::getReleaseYear)).forEach(System.out::println);

//        movies.stream().filter(movie -> movie.getDirector().equals("Christopher Nolan")).forEach(System.out::println);

        Map<String, List<Movie>> map = movies.stream().collect(Collectors.groupingBy(Movie::getDirector));
        map.forEach((director, movieList) -> {
            System.out.println(director);
            movieList.forEach(movie -> System.out.println("   " + movie.getTitle()));
        });
    }
}
