package com.example.CS121_MP.members;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.time.LocalDate;
import java.util.List;

import static java.time.Month.*;

@Configuration
public class MembersConfig {

    @Bean
    @Order(1)
    CommandLineRunner commandLinRunner(MembersRepository membersrepository) {
        return args -> {
            Members isa = new Members (
                    "Isabella",
                    "Elisae",
                    LocalDate.of(2003, DECEMBER, 25)
            );

            Members kofi = new Members (
                    "Kofi",
                    "Koffers101",
                    LocalDate.of(2003, FEBRUARY, 21)
            );

            Members nico = new Members (
                    "Nico",
                    "Uh",
                    LocalDate.of(2003, AUGUST, 11)
            );

            membersrepository.saveAll(List.of(isa, kofi, nico));
        };
    }
}
