package com.example.CS121_MP.todolist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ToDoRepository extends JpaRepository<ToDo, Long> {
    @Query("SELECT t FROM ToDo t WHERE t.category = ?1")
    Optional<ToDo> findToDoByCategory(String category);
    @Query("SELECT t FROM ToDo t WHERE t.job LIKE CONCAT('%', :job, '%')")

    Optional<ToDo> findToDoByJob(String job);

}
