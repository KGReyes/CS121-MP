package com.example.CS121_MP.music;

import com.example.CS121_MP.members.Members;
import com.example.CS121_MP.members.MembersRepository;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.util.List;

@Configuration
public class MusicConfig {
    @Bean
    @Order(3)
    @Transactional

    CommandLineRunner musiccommandLineRunner(MusicRepository musicRepository, MembersRepository membersRepository) {
        return args -> {
            Members isa = membersRepository.findMembersByUsername("Elisae").orElseThrow(() -> new IllegalStateException(("User not found")));
            Members kofi = membersRepository.findMembersByUsername("Koffers101").orElseThrow(() -> new IllegalStateException(("User not found")));
            Members nico = membersRepository.findMembersByUsername("Uh").orElseThrow(() -> new IllegalStateException(("User not found")));

            Music getthefunkout = new Music (
                    "Get the Funk Out",
                    "Extreme II - Pornograffiti",
                    "Extreme",
                    "https://upload.wikimedia.org/wikipedia/en/9/9a/Extreme-pornograffitti.jpg",
                    "https://open.spotify.com/track/1Q92pr5ZjhaOfNTvrjYLnE?si=37b792728a9f4c3b",
                    kofi
            );

            Music crazything = new Music (
                    "Crazy Little Thing Called Love",
                    "Frisky Business",
                    "Scary Pockets, Casey Abrams",
                    "https://i.scdn.co/image/ab67616d0000b273d4c1edae8e05c49eeb222e1d",
                    "https://open.spotify.com/track/2VwcMkLFi70Rl5ltGinWU3?si=7cf21acd0eec4aa8",
                    kofi
            );

            Music survive = new Music (
                    "I Will Survive",
                    "Off Center",
                    "Scary Pockets, Mario Jose",
                    "https://lastfm.freetls.fastly.net/i/u/500x500/87ef2cd74294e366383ffa64823ed0f8.jpg",
                    "https://open.spotify.com/track/0LzwLyzKsViB56qZOJ7xKg?si=4a9f7ed19da24196",
                    kofi
            );

            Music words = new Music (
                    "More Than Words",
                    "Extreme II - Pornograffiti",
                    "Extreme",
                    "https://upload.wikimedia.org/wikipedia/en/9/9a/Extreme-pornograffitti.jpg",
                    "https://open.spotify.com/track/1gVgkQFOKa8Wc1HYsJtPdH?si=cf8029a433c04cf6",
                    kofi
            );

            Music sinta = new Music (
                    "Sinta",
                    "Sinta",
                    "Rob Deniel",
                    "https://cdns-images.dzcdn.net/images/cover/40b00c5b1a993b57e5aed88c47122280/500x500.jpg",
                    "https://open.spotify.com/track/0aCmjkogiWIRu7205eZK6I?si=9e6857749d8b4df4",
                    kofi
            );

            Music value = new Music (
                    "Value",
                    "Value",
                    "ADO",
                    "https://i1.sndcdn.com/artworks-mejQXlsD6ypF-0-t500x500.jpg",
                    "https://open.spotify.com/track/6BEnpVB7g2j8mzWs3MC2kh?si=e903139574f64991",
                    nico
            );

            Music bibbidiba = new Music (
                    "Bibbidiba",
                    "Bibbidiba",
                    "Hoshimachi Suisei",
                    "https://e.snmc.io/i/600/s/6b8d8504ef918c7dc78ae9bec6e407d4/11937101/%E6%98%9F%E8%A1%97%E3%81%99%E3%81%84%E3%81%9B%E3%81%84-suisei-hoshimachi-%E3%83%93%E3%83%93%E3%83%87%E3%83%90-Cover-Art.jpg",
                    "https://open.spotify.com/track/0ShUHmWaz48KgyjaOG7Tpv?si=fffe24ca96b94d3e",
                    nico
            );

            Music show = new Music (
                    "Show",
                    "Ado \"Ready For My Show Playlist\"",
                    "ADO",
                    "https://upload.wikimedia.org/wikipedia/en/c/ca/Ado_-_Ado%27s_Utattemita.png",
                    "https://open.spotify.com/track/7o0TPSw494RG2Q4iWmd1v6?si=f213fd35871f458b",
                    nico
            );

            Music crime = new Music (
                    "Crime and Punishment",
                    "Ado’s Utattemita Album ",
                    "ADO",
                    "https://upload.wikimedia.org/wikipedia/en/c/ca/Ado_-_Ado%27s_Utattemita.png",
                    "https://open.spotify.com/track/7r46PpiDGgW7cQwXMHS5lU?si=bed3382b7b204d97",
                    nico
            );

            Music stopbreaking = new Music (
                    "If I Can Stop One Heart From Breaking",
                    "INSIDE ",
                    "Robin",
                    "https://pbs.twimg.com/media/GNHZLsOWwAEH_ry.jpg:large",
                    "https://open.spotify.com/track/7f3GFn9aFk8yKrrSQ8VnTp?si=2d95543774e0401e",
                    nico
            );

            Music prom = new Music (
                    "Prom",
                    "Ctrl (Deluxe)",
                    "SZA",
                    "https://images.genius.com/32d4c8dc502bde05ccf66701a098cb49.1000x1000x1.jpg",
                    "https://open.spotify.com/track/5MffAkbuTPBqRdPuPzaEb5?si=f686aa129a954a5e",
                    isa
            );

            Music autumn = new Music (
                    "Autumn",
                    "Nicole",
                    "NIKI",
                    "https://upload.wikimedia.org/wikipedia/en/1/1d/Nicole_%28Album%29_cover.png",
                    "https://open.spotify.com/track/7tKK8AGJ6Nfefm829JwLgr?si=e992edf81e1d4d82",
                    isa
            );

            Music dance = new Music (
                    "I Wanna Dance with Somebody (Who Loves Me)",
                    "Whitney",
                    "Whitney Houston",
                    "https://upload.wikimedia.org/wikipedia/en/1/15/Whitney_Houston_-_Whitney.png",
                    "https://open.spotify.com/track/2tUBqZG2AbRi7Q0BIrVrEj?si=7c25e0b27c344f14",
                    isa
            );

            Music girls = new Music (
                    "Girls Just Want To Have Fun",
                    "She’s So Unusual",
                    "Cyndi Lauper",
                    "https://upload.wikimedia.org/wikipedia/en/0/09/ShesSoUnusual1984.PNG",
                    "https://open.spotify.com/track/4y1LsJpmMti1PfRQV9AWWe?si=6e28c730a61e4d79",
                    isa
            );

            Music whatsnew = new Music (
                    "What’s New",
                    "Good News",
                    "Megan Thee Stallion",
                    "https://upload.wikimedia.org/wikipedia/en/b/bb/Megan_Thee_Stallion_-_Good_News.png",
                    "https://open.spotify.com/track/3jRHehB5ulTMKfK5WaqDqc?si=3568b3dc642b49a6",
                    isa
            );

            musicRepository.saveAll(List.of(
                    getthefunkout,
                    crazything,
                    survive,
                    words,
                    sinta,
                    value,
                    bibbidiba,
                    show,
                    crime,
                    stopbreaking,
                    prom,
                    autumn,
                    girls,
                    dance,
                    whatsnew));
        };
    }


}
