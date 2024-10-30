package com.example.playlistfullstack.Repository;

import com.example.playlistfullstack.Model.Playlist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlaylistRepo {
    @Autowired
    JdbcTemplate template;

    public List<Playlist> fetchAll(){//fordi man ikke kan lave en tostring anvender vi rowmapper som er en liste , beanproperty kan tage en række og bruge vores tomme konstruktør til at oprette objektet
        String sql = "SELECT * FROM playlist";
        RowMapper<Playlist> rowMapper = new BeanPropertyRowMapper<>(Playlist.class);
        return template.query(sql, rowMapper);
    }
    public void addPlaylist(Playlist p){
        String sql ="INSERT INTO playlist (id, artist, album_titel, tracks, track_duration, release_year, record_label) VALUES(?,?,?,?,?,?,?)";
        template.update(sql, p.getId(), p.getArtist(), p.getAlbum_titel(), p.getTracks(), p.getTrack_duration(), p.getRelease_year(), p.getRecord_label());
    }
    public Playlist findPlaylistById(int id){
        String sql = "SELECT * FROM playlist WHERE id = ?";
        RowMapper<Playlist> rowMapper = new BeanPropertyRowMapper<>(Playlist.class);
        Playlist p = template.queryForObject(sql, rowMapper, id);
        return p;
    }
    public Boolean deletePlaylist(int id) {
        String sql = "DELETE FROM playlist WHERE id = ?";
        return template.update(sql, id) > 0;
    }
    public void updatePlaylist(int id, Playlist p) {
        String sql="UPDATE playlist SET artist = ?, album_titel = ?, tracks = ?, track_duration = ?, release_year = ?, record_label = ? WHERE id = ? ";
        template.update(sql, p.getArtist(),p.getAlbum_titel(), p.getTracks(), p.getTrack_duration(), p.getRelease_year(), p.getRecord_label(), p.getId());
    }
}
