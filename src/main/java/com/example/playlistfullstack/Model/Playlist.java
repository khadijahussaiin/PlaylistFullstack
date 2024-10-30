package com.example.playlistfullstack.Model;
import java.time.LocalTime;
import java.time.Year;

public class Playlist {
    private int id;
    private String artist;
    private String album_titel;
    private int tracks;
    private LocalTime  track_duration;
    private int release_year;
    private String record_label;

    public Playlist() {//Man skal oprette en tom kontruktør fordi...

    }
    public Playlist(int id, String artist, String album_titel, int tracks, LocalTime track_duration, int release_year, String record_label){
        this.id=id;
        this.artist=artist;
        this.album_titel=album_titel;
        this.tracks=tracks;
        this.track_duration=track_duration;
        this.release_year=release_year;
        this.record_label=record_label;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getArtist() {
        return artist;
    }
    public void setArtist(String artist) {
        this.artist = artist;
    }
    public String getAlbum_titel() {
        return album_titel;
    }
    public void setAlbum_titel(String album_titel) {
        this.album_titel = album_titel;
    }
    public int getTracks() {
        return tracks;
    }
    public void setTracks(int tracks) {
        this.tracks = tracks;
    }
    public LocalTime getTrack_duration() {
        return track_duration;
    }
    public void setTrack_duration(LocalTime track_duration) {
        this.track_duration = track_duration;
    }
    public int getRelease_year() {
        return release_year;
    }
    public void setRelease_year(int release_year) {
        this.release_year = release_year;
    }
    public String getRecord_label() {
        return record_label;
    }
    public void setRecord_label(String record_label) {
        this.record_label = record_label;
    }
}
