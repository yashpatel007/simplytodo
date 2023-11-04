package com.simplytodo.controller;
import com.simplytodo.entity.TodoTask;
import com.simplytodo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping("/task/{id}")
    public TodoTask getTask(@PathVariable int id){
        return todoService.getTask(id);
    }

    @GetMapping("/tasks")
    public List<?> getAllTasks(){
        return todoService.getAllTasks();
    }

    @DeleteMapping("/task/{id}")
    public void deleteTask(@PathVariable int id){
        todoService.delete(id);
    }

    @PostMapping("/task")
    public TodoTask createTask(@RequestBody TodoTask todoTask){
        return todoService.createOrUpdate(todoTask);
    }

    @PatchMapping("/task")
    public TodoTask updateTask(@RequestBody TodoTask todoTask){
        return todoService.createOrUpdate(todoTask);
    }
}
