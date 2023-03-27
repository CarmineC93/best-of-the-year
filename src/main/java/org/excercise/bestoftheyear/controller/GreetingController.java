package org.excercise.bestoftheyear.controller;

import org.excercise.bestoftheyear.Movie;
import org.excercise.bestoftheyear.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/greeting")
public class GreetingController {

    @GetMapping
    public String greeting(Model model){
        model.addAttribute("name", "Carmine");
        return "greeting";
    }

/*   Step 2
    Aggiungere al controller altri due metodi, che
    rispondono agli url - “/movies” - “/songs”
    In ognuno di questi metodi aggiungere al Model
    un attributo stringa con una lista di titoli
    di migliori film o canzoni (in base al metodo
    che stiamo implementando) separati da virgole.
    Utilizzare i due metodi getBest… per recuperare i
    film e le canzoni.
    Creare i rispettivi template Thymeleaf.*/

    private List<Movie> getBestMovies() {
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie(1, "primo film"));
        movies.add(new Movie(2, "secondo film"));
        return movies;
    }

    private List<Song> getBestSongs(){
        List<Song> songs = new ArrayList<>();
        songs.add(new Song(1, "prima canzone"));
        songs.add(new Song(2, "seconda canzone"));
        return songs;
    }

    @GetMapping("/movies")
    public String movies(Model model){
        List<Movie> bestMovies = getBestMovies();
        String moviesList = "";
        for(Movie movie : bestMovies){
            moviesList += movie.getName() + ", ";}

        model.addAttribute("allMovies", moviesList);
        return "movies";
    }

    @GetMapping("/songs")
    public String songs(Model model){
        List<Song> bestSongs = getBestSongs();
        String songsList = "";
        for(Song song : bestSongs){
            songsList += song.getName() + ", ";}

        model.addAttribute("allSongs", songsList);
        return "songs";

    }
}



