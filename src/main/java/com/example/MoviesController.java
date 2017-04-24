package com.example;

/**
 * Created by anup on 23/04/17.
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MoviesController {

    @GetMapping("")
    public List<Movie> searchMovies(@RequestParam("q") String query) {
        RestTemplate restTemplate = new RestTemplate();
        String uri = String.format("http://www.omdbapi.com/?s=%s", query);
        Result result = restTemplate.getForObject(uri, Result.class);
        return result.getMovies();
    }

    static class Result {
        @JsonProperty("Search")
        private List<Movie> movies;

        public List<Movie> getMovies() {
            return movies;
        }

        public void setMovies(List<Movie> movies) {
            this.movies = movies;
        }
    }

}
