package org.excercise.bestoftheyear.controller;

import org.excercise.bestoftheyear.model.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/songs")
public class SongController {

    private List<Song> getBestSongs(){
        List<Song> songs = new ArrayList<>();
        songs.add(new Song(1, "prima canzone"));
        songs.add(new Song(2, "seconda canzone"));
        return songs;
    }



    @GetMapping
    public String songs(Model model){
        List<Song> bestSongs = getBestSongs();
        String songsList = "";
        for(Song song : bestSongs){
            songsList += song.getName() + ", ";}

        model.addAttribute("allSongs", songsList);
        return "songs";
    }

    @GetMapping("/{id}")
    public String movieDetail(@PathVariable(name = "id") int songId, Model model){
        for(Song s:getBestSongs()){
            if (s.getId() == songId){
                model.addAttribute("song", s);
            }
        }
        //richiamiamo un nuovo file template
        return "song-detail";
    }

}
