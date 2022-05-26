package katas;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import model.Bookmark;
import model.Movie;
import model.MovieList;
import util.DataUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
    Goal: Retrieve the id, title, and smallest box art url for every video
    DataSource: DataUtil.getMovieLists()
    Output: List of ImmutableMap.of("id", "5", "title", "Bad Boys", "boxart": "url)
*/
public class Kata7 {
    public static List<Map> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();

//        movieLists.stream().map(movieList -> movieList.getVideos())
//                .flatMap(movies -> movies.stream())
//                .map(movie -> movie.getBoxarts())
//                .flatMap(boxArts -> boxArts.stream())
//                .reduce((a, b) -> a.getWidth()* a.getHeight() > b.getWidth()* b.getHeight() ? b : a)
//                .map(boxArt -> boxArt.getUrl());

         return movieLists.stream().map(movieList -> movieList.getVideos())
                .flatMap(movies -> movies.stream())
                .map(movie -> {
                    HashMap<String, String> map = new HashMap<>();
                    map.put("id", movie.getId().toString());
                    map.put("title", movie.getTitle());
                    map.put("boxart", movie.getBoxarts().stream()
                            .reduce((a, b) -> a.getWidth()*a.getHeight() > b.getWidth()* b.getHeight() ? b : a)
                            .map(boxArt -> boxArt.getUrl())
                            .orElseThrow());
                    return map;
                }).collect(Collectors.toList());

        //return ImmutableList.of(ImmutableMap.of("id", 5, "title", "Bad Boys", "boxart", "url"));
    }

    public static void main(String[] args) {
        Kata7 kata7 = new Kata7();
        System.out.println(kata7.execute());
    }
}
