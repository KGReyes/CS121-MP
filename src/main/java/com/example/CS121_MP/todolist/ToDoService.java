package com.example.CS121_MP.todolist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToDoService {

    private final ToDoRepository todoRepository;

    @Autowired
    public ToDoService(ToDoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<ToDo> getAllToDo() {
        return todoRepository.findAll();
    }

    public void addNewToDo(ToDo todo) {
        Optional<ToDo> todoOptional = todoRepository.findToDoByJob(todo.getJob());
        if(todoOptional.isPresent()) {
            throw new IllegalStateException("Job already exists");
        }
        todoRepository.save(todo);
    }

    public void updateToDo(Long todoId, String category, String job, String description) {
        ToDo todo = todoRepository.findById(todoId).orElseThrow(()
        -> new IllegalStateException("Job id " + todoId + " doesn't exist"));

        if(category != null && !category.isEmpty()) {
            todo.setCategory(category);
        }

        if (job != null && !job.isEmpty()) {
            Optional<ToDo> todoOptional = todoRepository.findToDoByJob(job);
            if(todoOptional.isPresent()) {
                throw new IllegalStateException(("Job already exists"));
            }
            todo.setJob(job);
        }

        if(description != null && !description.isEmpty()) {
            todo.setDescription(description);
        }

        todoRepository.save(todo);
    }

    public Optional<ToDo> getToDoByJob(String job) {
        return todoRepository.findToDoByJob(job);
    }

    public Optional<ToDo> getToDoByCategory(String category) {
        return todoRepository.findToDoByCategory(category);
    }

    public void markAsDone(Long todoId, boolean done) {
        ToDo todo = todoRepository.findById(todoId).orElseThrow(()
        -> new IllegalStateException("Job Id " + todoId + " doesn't exist"));

        todo.setDone(done);
        todoRepository.save(todo);
    }

    public void deleteToDo(Long todoId) {
        boolean exists = todoRepository.existsById(todoId);
        if(!exists) {
            throw new IllegalStateException("ToDo Id " + todoId + " doesn't exist");
        }
        todoRepository.deleteById(todoId);
    }

}
