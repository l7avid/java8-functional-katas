package katas;

import model.Movie;
import util.DataUtil;

import java.util.List;

/*
    Goal: Retrieve the url of the largest boxart using map() and reduce()
    DataSource: DataUtil.getMovieLists()
    Output: String
*/

public class Kata6 {
    public static String execute() {
        List<Movie> movies = DataUtil.getMovies();

        return movies.stream()
                .map(movie -> movie.getBoxarts())
                .flatMap(boxArts -> boxArts.stream())
                .reduce((a, b) -> a.getWidth()*a.getHeight() > b.getWidth()*b.getHeight() ? a : b)
                .map(boxArt -> boxArt.getUrl())
                .orElseThrow();

    }

    public static void main(String[] args) {
        Kata6 kata6 = new Kata6();
        System.out.println(kata6.execute());
    }
}
