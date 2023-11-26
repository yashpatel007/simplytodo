package com.simplytodo.repository;

import com.simplytodo.entity.TodoTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TodoTaskRepository extends JpaRepository<TodoTask, Integer> {
    public TodoTask findById(int id);
    public void deleteById(int id);
    public TodoTask save(TodoTask todoTask);
    public List<TodoTask> findAll();
}
