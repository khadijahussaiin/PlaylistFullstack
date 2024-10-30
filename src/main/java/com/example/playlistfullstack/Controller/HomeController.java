package com.example.playlistfullstack.Controller;

import com.example.playlistfullstack.Model.Playlist;
import com.example.playlistfullstack.Service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    PlaylistService playlistService;

    @GetMapping("/")
    public String index(Model model) {
        List<Playlist> Playlist_List = playlistService.fetchAll();
        model.addAttribute("playlists", Playlist_List);
        return "home/index"; // henviser til src/main/resources/templates/home/index.html
    }

    @GetMapping("/create")
    public String create() {
        return "home/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Playlist p) {
        playlistService.addPlaylist(p);
        return "redirect:/";
    }

    @GetMapping("/viewOne/{id}")
    public String viewOne(@PathVariable("id") int id, Model model) {
        model.addAttribute("playlist", playlistService.findPlaylistById(id));
        return "home/viewOne";
    }

    @GetMapping("/deleteOne/{id}")
    public String deleteOne(@PathVariable("id") int id) {
        boolean deleted = playlistService.deletePlaylist(id);
        if (deleted) {
            return "redirect:/";
        } else {
            return "redirect:/";
        }
    }
    @GetMapping("/updateOne/{id}")
    public String updateOne(@PathVariable("id") int id, Model model){
        model.addAttribute("playlist", playlistService.findPlaylistById(id));
        return "home/updateOne";
    }
    @PostMapping("/updatePlaylist")
    public String updatePlaylist(@ModelAttribute Playlist playlist){
        playlistService.updatePlaylist(playlist.getId(), playlist);
        return "redirect:/";
    }
}
