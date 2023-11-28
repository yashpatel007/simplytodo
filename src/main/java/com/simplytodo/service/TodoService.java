package com.simplytodo.service;

import com.simplytodo.dao.TodoTaskDao;
import com.simplytodo.dao.TodoTaskMongoDAO;
import com.simplytodo.entity.Metadata;
import com.simplytodo.entity.TodoTask;
import com.simplytodo.entity.User;
import com.simplytodo.errors.TodoException;
import com.simplytodo.repository.TodoTaskMongoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TodoService {

    @Autowired
    private User loggedUser;

    /*@Autowired(required = false)
    private TodoTaskDao todoTaskDao;*/

    /*@Autowired
    private TodoTaskRepository todoTaskRepository;*/

    @Autowired
    private TodoTaskMongoDAO todoTaskDao;

    @Autowired
    private TodoTaskMongoRepo todoTaskRepository;

    public TodoTask createOrUpdate(TodoTask todoTask) throws TodoException {

        Metadata<User> metadata = new Metadata<>();
        metadata.setCreated_by_user_id(loggedUser.getId());
        metadata.setObjectType(User.class.getTypeName());

        todoTask.setMetadata(metadata);
        todoTask.setUser_id(loggedUser.getId());
        return todoTaskRepository.insert(todoTask);
    }

    public TodoTask getTask(int id) throws TodoException {
        return todoTaskRepository.findById(id);
    }

    public void delete(int id) throws TodoException {
       todoTaskRepository.deleteById(id);
    }

    public List<TodoTask> getAllTasks() throws TodoException {
        return todoTaskRepository.findAlltasksByUserId(loggedUser.getId());
    }

    public List<TodoTask> getAllTasksbytitleForuser(long user_id, String title) throws TodoException {
        return todoTaskDao.getAllTasksbytitleForuser(user_id, title);
    }

}
