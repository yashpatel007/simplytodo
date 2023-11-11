package com.simplytodo.controller;
import com.simplytodo.entity.TodoTask;
import com.simplytodo.errors.TodoException;
import com.simplytodo.service.TodoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @ApiOperation(value = "Get the todo task info based on task id",
            notes = "Pass in task id to get task info")
    @GetMapping("/task/{id}")
    public TodoTask getTask(@PathVariable int id) throws TodoException {
        return todoService.getTask(id);
    }

    @ApiOperation(value = "Get all the todo tasks",
            notes = "Get all the todo tasks")
    @GetMapping("/tasks")
    public List<?> getAllTasks() throws TodoException {
        return todoService.getAllTasks();
    }

    @ApiOperation(value = "Delete the todo task based on task id",
            notes = "Pass in task id to delete task")
    @DeleteMapping("/task/{id}")
    public void deleteTask(@PathVariable int id) throws TodoException {
        todoService.delete(id);
    }


    @ApiOperation(value = "Create a new todo task",
            notes = "Pass in task info to create a new task")
    @PostMapping("/task")
    public TodoTask createTask(@RequestBody TodoTask todoTask) throws TodoException {
        return todoService.createOrUpdate(todoTask);
    }

    @ApiOperation(value = "Update the todo task",
            notes = "Pass in task info to update the task")
    @PatchMapping("/task")
    public TodoTask updateTask(@RequestBody TodoTask todoTask) throws TodoException {
        return todoService.createOrUpdate(todoTask);
    }
}
