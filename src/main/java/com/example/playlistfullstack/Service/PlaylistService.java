package com.example.playlistfullstack.Service;

import com.example.playlistfullstack.Model.Playlist;
import com.example.playlistfullstack.Repository.PlaylistRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaylistService {
    @Autowired
    PlaylistRepo playlistRepo;

    public List<Playlist> fetchAll(){
        return playlistRepo.fetchAll();
    }
    public void addPlaylist(Playlist p){
        playlistRepo.addPlaylist(p);
    }
    public Playlist findPlaylistById(int id){
        return playlistRepo.findPlaylistById(id);
    }
    public Boolean deletePlaylist(int id){
        return playlistRepo.deletePlaylist(id);
    }
    public void updatePlaylist(int id, Playlist p){
        playlistRepo.updatePlaylist(id, p);

    }
}
