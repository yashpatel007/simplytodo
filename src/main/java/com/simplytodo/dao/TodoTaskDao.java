package com.simplytodo.dao;

import com.simplytodo.entity.TodoTask;
import com.simplytodo.enums.TodoTaskStatus;
import com.simplytodo.errors.TodoErrorStatus;
import com.simplytodo.errors.TodoException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
@Profile("notused")
//@ConditionalOnProperty(name = "spring.datasource.driverClassName", havingValue = "org.postgresql.Driver")
@Deprecated
public class TodoTaskDao{
    @Value("${spring.datasource.url}")
    private String DB_URL;
    @Value("${spring.datasource.username}")
    private String USERNAME;
    @Value("${spring.datasource.password}")
    private String Password;

    Connection connection = null;

    public TodoTaskDao() throws SQLException {
        connection = DriverManager.getConnection(DB_URL, USERNAME, Password);
        this.CheckAndCreateTable();
    }

    public TodoTask getTask(int id) throws TodoException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try{
            statement = connection.prepareStatement("SELECT * FROM todo_task WHERE id = ?");
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            List<TodoTask> tasks = new ArrayList<>();
            while(resultSet.next()){
                // map the response (manually)
                TodoTask todoTask = new TodoTask();
                todoTask.setId(resultSet.getInt("id"));
                todoTask.setTitle(resultSet.getString("title"));
                //todoTask.setDescription(resultSet.getString("description"));
                todoTask.setStatus(TodoTaskStatus.valueOf(resultSet.getString("status")));
                todoTask.setDueDate(resultSet.getDate("due_date"));
                //todoTask.setCreatedAt(resultSet.getDate("created_at"));
                tasks.add(todoTask);
            }
            return tasks.size()>0 ? tasks.get(0): null;
        }catch (Exception e){
            throw new TodoException(TodoErrorStatus.BAD_REQUEST, e.getMessage());
        }
    }

    public List<TodoTask> getAllTasks() throws TodoException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try{
            statement = connection.prepareStatement("SELECT * FROM todo_task");
            resultSet = statement.executeQuery();
            List<TodoTask> tasks = new ArrayList<>();
            while(resultSet.next()){
                // map the response (manually)
                TodoTask todoTask = new TodoTask();
                todoTask.setId(resultSet.getInt("id"));
                todoTask.setTitle(resultSet.getString("title"));
                //todoTask.setDescription(resultSet.getString("description"));
                todoTask.setStatus(TodoTaskStatus.valueOf(resultSet.getString("status")));
                todoTask.setDueDate(resultSet.getDate("due_date"));
                //todoTask.setCreatedAt(resultSet.getDate("created_at"));
                tasks.add(todoTask);
            }
            return tasks;
        }catch (Exception e){
            throw new TodoException(TodoErrorStatus.BAD_REQUEST, e.getMessage());
        }
    }

    public void delete(int id) throws TodoException{
        PreparedStatement statement = null;
        try{
            // create the statement
            statement = connection.prepareStatement("DELETE FROM todo_task WHERE id = ?");

            // set vars
            statement.setInt(1, id);

            // update the DB
            statement.executeUpdate();
        }catch (Exception e){
            throw new TodoException(TodoErrorStatus.BAD_REQUEST, e.getMessage());
        }
    }

    public TodoTask createOrUpdate(TodoTask todoTask) throws TodoException {
        PreparedStatement statement = null;
        try{
            // create the statement
            statement = connection.prepareStatement("INSERT INTO todo_task (title, description, status, due_date, created_at) VALUES (?, ?, ?, ?, ?)");

            // set vars
            statement.setString(1, todoTask.getTitle());
            //statement.setString(2, todoTask.getDescription());
            statement.setString(3, todoTask.getStatus().toString());
            statement.setDate(4,todoTask.getDueDate() !=null? new java.sql.Date(todoTask.getDueDate().getTime()): null);
            //statement.setDate(5, new java.sql.Date(todoTask.getCreatedAt().getTime()));

            // update the DB
            statement.executeUpdate();
        }catch (Exception e){
            throw new TodoException(TodoErrorStatus.BAD_REQUEST, e.getMessage());
        }
        return todoTask;
    }

    private void CheckAndCreateTable() throws SQLException {
        var dbMetaData = this.connection.getMetaData();
        var tables = dbMetaData.getTables(null, null, "todo_task", null);
        if(!tables.next()){
            var createTableStatement = this.connection.prepareStatement("CREATE TABLE todo_task (id SERIAL PRIMARY KEY, title VARCHAR(255), description VARCHAR(255), status VARCHAR(255), due_date DATE, created_at DATE)");
            createTableStatement.executeUpdate();
        }
    }
}
