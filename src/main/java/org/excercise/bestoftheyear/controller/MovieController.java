package org.excercise.bestoftheyear.controller;

import org.excercise.bestoftheyear.model.Movie;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Controller
@RequestMapping("/movies")
public class MovieController {

    private List<Movie> getBestMovies() {
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie(1, "primo film"));
        movies.add(new Movie(2, "secondo film"));
        return movies;
    }

    @GetMapping
    public String movies(Model model){
        List<Movie> bestMovies = getBestMovies();

        /*//metodo con stream e lambda
        String moviesList = getBestMovies().stream().map((s)->s.getName()).collect(Collectors.joining(", "));
*/
        /*
        //metodo con un ciclo
        String moviesList = "";
        for(Movie movie : bestMovies){
            moviesList += movie.getName() + ", ";}*/

        //model.addAttribute("allMovies", moviesList);

        model.addAttribute("movies",  bestMovies);
        return "movies";
    }

    @GetMapping("/{id}")
    public String movieDetail(@PathVariable(name = "id") int movieId, Model model){
        for(Movie m:getBestMovies()){
            if (m.getId() == movieId){
                model.addAttribute("movie", m);
            }
        }
        //richiamiamo un nuovo file template
        return "movie-detail";
    }

}
