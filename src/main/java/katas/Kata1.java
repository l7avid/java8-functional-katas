package katas;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import model.Movie;
import util.DataUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
    Goal: use map() to project an array of videos into an array of {id, title}-pairs
    DataSource: DataUtil.getMovies()
    Output: List of ImmutableMap.of("id", "5", "title", "Bad Boys")
*/

public class Kata1 {

    public static List<Map> execute() {
        List<Movie> movies = DataUtil.getMovies();

        return movies.stream().map(movie -> {
            HashMap mapMovie = new HashMap<>();
            mapMovie.put("id", movie.getId());
            mapMovie.put("title", movie.getTitle());
            return mapMovie;

        }).collect(Collectors.toList());

    }

    public static void main(String[] args) {
        Kata1 kata1 = new Kata1();
        System.out.println(kata1.execute());
    }
}
