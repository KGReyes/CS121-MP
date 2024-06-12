package com.example.CS121_MP.music;

import com.example.CS121_MP.members.Members;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/music")
public class MusicController {

    private final MusicService musicService;

    @Autowired
    public MusicController(MusicService musicService) {
        this.musicService = musicService;
    }

    @GetMapping
    public List<Music> getAllMusic() {
        return musicService.getAllMusic();
    }

    @GetMapping(path = "/title/{title}")
    public Optional<Music> getMusicByTitle(@PathVariable String title) {
        return musicService.getMusicByTitle(title);
    }

    @GetMapping(path = "/album/{album}")
    public Optional<Music> getMusicByAlbum(@PathVariable String album) {
        return musicService.getMusicByAlbum(album);
    }

    @GetMapping(path = "/artist/{artist}")
    public Optional<Music> getMusicByArtist(@PathVariable String artist) {
        return musicService.getMusicByArtist(artist);
    }

    @GetMapping(path = "/member/{members}")
    public List<Music> getMusicByMembers(Members members) {
        return musicService.getMusicByMembers(members);
    }

    @PostMapping
    public void registerMusic(@RequestBody Music music) {
        musicService.addMusic(music);
    }

    @PutMapping(path = "/{musicId}")
    public ResponseEntity<?> updateMusic (
            @PathVariable("musicId") Long musicId,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String album,
            @RequestParam(required = false) String artist,
            @RequestParam(required = false) String albumart,
            @RequestParam(required = false) String spotify) {
        musicService.updateMusic(musicId, title, album, artist, albumart, spotify);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(path = "{musicId}")
    public void deleteMusic(@PathVariable("musicId") Long musicId) {
        musicService.deleteMusic(musicId);
    }

}
