package com.example.CS121_MP.music;

import com.example.CS121_MP.members.Members;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class MusicService {

    private final MusicRepository musicRepository;

    @Autowired
    public MusicService(MusicRepository musicRepository) {
        this.musicRepository = musicRepository;
    }

    public List<Music> getAllMusic() {
        return musicRepository.findAll();
    }

    public Optional<Music> getMusicByTitle(String title) {
        return musicRepository.findMusicByTitle(title);
    }

    public Optional<Music> getMusicByAlbum(String album) {
        return musicRepository.findMusicByAlbum(album);
    }

    public Optional<Music> getMusicByArtist(String artist) {
        return musicRepository.findMusicByArtist(artist);
    }

    public List<Music> getMusicByMembers(Members members) {
        return musicRepository.findMusicByMembers((members));
    }

    public void addMusic (Music music) {
        Optional<Music> musicOptional = musicRepository.findMusicByTitle(music.getTitle());
        if(musicOptional.isPresent()) {
            throw new IllegalStateException("Track exists on record");
        }
        musicRepository.save(music);
    }

    public void updateMusic (Long musicId, String title, String album, String artist, String albumart, String spotify) {
        Music music = musicRepository.findById(musicId).orElseThrow(()
        -> new IllegalStateException("Track Id " + musicId + " doesn't exist"));

        if (title != null && !title.isEmpty() && !Objects.equals(music.getTitle(), title)) {
            Optional<Music> musicOptional = musicRepository.findMusicByTitle(title);
            if(musicOptional.isPresent()) {
                throw new IllegalStateException("Track " + title + " already exists");
            }
            music.setTitle(title);
        }

        if(album != null && !album.isEmpty() && !Objects.equals(music.getAlbum(), album)){
            music.setAlbum(album);
        }

        if(artist != null && !artist.isEmpty() && !Objects.equals(music.getArtist(), artist)){
            music.setArtist(artist);
        }

        if (albumart != null && !albumart.isEmpty()) {
            music.setAlbumart(albumart);
        }

        if (spotify != null && !spotify.isEmpty()) {
            music.setSpotify(spotify);
        }
        musicRepository.save(music);
    }

    public void deleteMusic(Long musicId) {
        boolean exists = musicRepository.existsById(musicId);
        if (!exists) {
            throw new IllegalStateException("Track Id " + musicId + " doesn't exist");
        }
        musicRepository.deleteById(musicId);
    }
}
