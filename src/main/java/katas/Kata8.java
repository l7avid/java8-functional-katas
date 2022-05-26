package katas;

import com.codepoetics.protonpack.StreamUtils;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import model.Bookmark;
import model.Movie;
import model.MovieList;
import util.DataUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
    Goal: Combine videos and bookmarks by index (StreamUtils.zip) (https://github.com/poetix/protonpack)
    DataSource: DataUtil.getMovies()
    Output: List of ImmutableMap.of("videoId", "5", "bookmarkId", "3")
*/
public class Kata8 {
    public static List<Map> execute() {
        List<Movie> movies = DataUtil.getMovies();
        List<Bookmark> bookMarks = DataUtil.getBookMarks();

        Stream<Movie> movieID = movies.stream();
        Stream<Bookmark> bookmarkID = bookMarks.stream();

        List<Map> zipped = StreamUtils.zip(movieID, bookmarkID, (a, b) -> Map.of("videoId", a.getId(), "bookmarkId", b.getId())).collect(Collectors.toList());

        return zipped;
    }

    public static void main(String[] args) {
        Kata8 kata8 = new Kata8();
        System.out.println(kata8.execute());
    }
}
