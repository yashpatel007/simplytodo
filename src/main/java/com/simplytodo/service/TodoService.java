package com.simplytodo.service;

import com.simplytodo.dao.TodoTaskDao;
import com.simplytodo.entity.TodoTask;
import com.simplytodo.errors.TodoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;

@Service
public class TodoService {

    @Autowired
    TodoTaskDao todoTaskDao;

    public TodoTask createOrUpdate(TodoTask todoTask) throws TodoException {
        return todoTaskDao.createOrUpdate(todoTask);
    }

    public TodoTask getTask(int id) throws TodoException {
        return todoTaskDao.getTask(id);
    }

    public void delete(int id) throws TodoException {
       todoTaskDao.delete(id);
    }

    public List<TodoTask> getAllTasks() throws TodoException {
        return todoTaskDao.getAllTasks();
    }

}
