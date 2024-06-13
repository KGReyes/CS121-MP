package com.example.CS121_MP.music;

import com.example.CS121_MP.members.Members;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table
public class Music {

    @Id
    @SequenceGenerator(
            name = "music_sequence",
            sequenceName = "music_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "music_sequence"
    )

    private long id;
    private String title;
    private String album;
    private String artist;
    private String albumart;
    private String spotify;

    @ManyToOne
    @JoinColumn(name = "memberId", nullable = false)
    @JsonBackReference
    private Members members;

    public Music() {
    }

    public Music(String title, String album, String artist, String albumart, String spotify, Members members) {
        this.title = title;
        this.album = album;
        this.artist = artist;
        this.albumart = albumart;
        this.spotify = spotify;
        this.members = members;
    }

    @Override
    public String toString() {
        return "Music{" +
                "title='" + title + '\'' +
                ", album='" + album + '\'' +
                ", artist='" + artist + '\'' +
                ", albumart='" + albumart + '\'' +
                ", spotify='" + spotify + '\'' +
                ", members=" + members +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbumart() {
        return albumart;
    }

    public void setAlbumart(String albumart) {
        this.albumart = albumart;
    }

    public String getSpotify() {
        return spotify;
    }

    public void setSpotify(String spotify) {
        this.spotify = spotify;
    }

    public Members getMembers() {
        return members;
    }

    public void setMembers(Members members) {
        this.members = members;
    }
}
