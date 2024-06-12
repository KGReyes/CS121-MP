package com.example.CS121_MP.todolist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/todo")
public class ToDoController {

    private final ToDoService todoService;

    @Autowired
    public ToDoController(ToDoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public List<ToDo> getAllToDo() {
        return todoService.getAllToDo();
    }

    @GetMapping(path = "/job/{job}")
    public Optional<ToDo> getToDoByJob(@RequestBody String job) {
        return todoService.getToDoByJob(job);
    }

    @GetMapping(path = "/category/{category}")
    public Optional<ToDo> getToDoByCategory(@RequestBody String category) {
        return todoService.getToDoByCategory(category);
    }

    @PostMapping
    public void registerToDo(@RequestBody ToDo todo) {
        todoService.addNewToDo(todo);
    }

    @PutMapping(path = "/{todoId}/done")
    public void markAsDone(
            @PathVariable Long todoId,
            @RequestParam boolean done) {
        todoService.markAsDone(todoId, done);
    }

    @PutMapping(path = "/{todoId}")
    public void updateToDo(
            @PathVariable("todoId") Long todoId,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String job,
            @RequestParam(required = false) String description) {
        todoService.updateToDo(todoId, category, job, description);
    }

    @DeleteMapping(path = "{todoId}")
    public void deleteToDo(@PathVariable("todoId") Long todoId) {
        todoService.deleteToDo(todoId);
    }


}
