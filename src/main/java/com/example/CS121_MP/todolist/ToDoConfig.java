package com.example.CS121_MP.todolist;

import com.example.CS121_MP.members.Members;
import com.example.CS121_MP.members.MembersRepository;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.util.List;

@Configuration
public class ToDoConfig {
    @Bean
    @Order(2)
    @Transactional
    CommandLineRunner todocommandLineRunner(ToDoRepository todoRepository) {
        return args -> {
            ToDo mpjob = new ToDo(
                    "#acads",
                    "Do MP",
                    "Read it again"
            );

            ToDo gamejob = new ToDo(
                    "#gaming",
                    "Reinstall Valo",
                    "Valorant troubleshooting"
            );

            ToDo sleepjob = new ToDo(
                    "#misc",
                    "Sleep",
                    "I'm tired so sleep"
            );

            todoRepository.saveAll(List.of(mpjob, gamejob, sleepjob));

        };
    }
}
