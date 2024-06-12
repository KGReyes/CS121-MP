package com.example.CS121_MP.hobbies;

import com.example.CS121_MP.members.Members;
import com.example.CS121_MP.members.MembersRepository;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.util.List;

@Configuration
public class HobbiesConfig {
    @Bean
    @Order(4)
    @Transactional
    CommandLineRunner hobbiescommandLineRunner(HobbiesRepository hobbiesRepository, MembersRepository membersRepository) {
        return args -> {
            Members isa = membersRepository.findMembersByUsername("Elisae").orElseThrow(() -> new IllegalStateException(("User not found")));
            Members kofi = membersRepository.findMembersByUsername("Koffers101").orElseThrow(() -> new IllegalStateException(("User not found")));
            Members nico = membersRepository.findMembersByUsername("Uh").orElseThrow(() -> new IllegalStateException(("User not found")));

            Hobbies singing = new Hobbies(
                  "Singing",
                  "Just singing any songs really",
                  "https://cdn.prod.website-files.com/655e0fa544c67c1ee5ce01c7/655e0fa544c67c1ee5ce0f3f_9-vocal-warm-ups.webp",
                  isa
            );

            Hobbies drawing = new Hobbies(
                    "Drawing",
                    "Drawing is life",
                    "https://www.shihoriobata.com/wp-content/uploads/2021/09/fox-drawing-easy-web.jpg",
                    isa
            );

            Hobbies film = new Hobbies(
                    "Watching Films",
                    "Just watching whatever",
                    "https://i.ytimg.com/vi/Qm3R6e4b-SU/hq720.jpg?sqp=-oaymwEhCK4FEIIDSFryq4qpAxMIARUAAAAAGAElAADIQj0AgKJD&rs=AOn4CLBoh2tT2ojkPD8qgAO5ueAAJ1WxSg",
                    kofi
            );

            Hobbies gaming = new Hobbies(
                    "Playing Video Games",
                    "Just playing stuff",
                    "https://preview.redd.it/firefly-is-special-v0-rf4ztx8v4gic1.jpeg?width=1080&format=pjpg&auto=webp&s=0a41f5071868a7d301e9a93358ac9a9657a2075e",
                    nico
            );

            hobbiesRepository.saveAll(List.of(singing, drawing, film, gaming));
        };
    }
}

//https://i.ytimg.com/vi/6oMUiZXYQC4/hqdefault.jpg