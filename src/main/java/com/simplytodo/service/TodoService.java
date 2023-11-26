package com.simplytodo.service;

import com.simplytodo.dao.TodoTaskDao;
import com.simplytodo.entity.Metadata;
import com.simplytodo.entity.TodoTask;
import com.simplytodo.entity.User;
import com.simplytodo.errors.TodoException;
import com.simplytodo.repository.TodoTaskRepository;
import jakarta.annotation.Resource;
import jakarta.persistence.Transient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TodoService {

    @Autowired
    private User loggedUser;

    @Autowired(required = false)
    private TodoTaskDao todoTaskDao;

    @Autowired
    private TodoTaskRepository todoTaskRepository;

    public TodoTask createOrUpdate(TodoTask todoTask) throws TodoException {

        Metadata<User> metadata = new Metadata<>();
        metadata.setCreatedBy(loggedUser);
        metadata.setObjectType(User.class.getTypeName());

        todoTask.setMetadata(metadata);
        todoTask.setUser(loggedUser);
        return todoTaskRepository.saveAndFlush(todoTask);
    }

    public TodoTask getTask(int id) throws TodoException {
        return todoTaskRepository.findById(id);
    }

    public void delete(int id) throws TodoException {
       todoTaskRepository.deleteById(id);
    }

    public List<TodoTask> getAllTasks() throws TodoException {
        return todoTaskRepository.findAll();
    }

}
