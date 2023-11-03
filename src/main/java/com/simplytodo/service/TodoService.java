package com.simplytodo.service;

import com.simplytodo.entity.TodoTask;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;

@Service
public class TodoService {

    private static HashMap<Integer, TodoTask> todoTaskStore = new HashMap<Integer, TodoTask>();

    public TodoTask createOrUpdate(TodoTask todoTask) {
        return todoTaskStore.put(todoTask.getId(), todoTask);
    }

    public TodoTask getTask(int id) {
        return todoTaskStore.get(id);
    }

    public void delete(int id) {
        if(todoTaskStore.containsKey(id))
            todoTaskStore.remove(id);
    }

    public List<TodoTask> getAllTasks() {
        return  todoTaskStore.values().stream().toList();
    }

}
