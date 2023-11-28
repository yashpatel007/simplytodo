package com.simplytodo.repository;

import com.simplytodo.entity.TodoTask;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoTaskMongoRepo extends MongoRepository<TodoTask, String> {
    public TodoTask findById(int id);
    public void deleteById(int id);
    public TodoTask findByTitle(String title);
    public TodoTask insert(TodoTask todoTask);

    @Query("{ 'user_id' : ?0 }")
    public List<TodoTask> findAlltasksByUserId(long userId);
}
