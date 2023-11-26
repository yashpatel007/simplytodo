package com.simplytodo.dao;

import com.simplytodo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired // marks that the method can receive a value from the bean, in this case, the dataSource bean
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<User> getAllUserWithTaskTitle(String taskTitle){
        StringBuffer sql = new StringBuffer();
        List<Object> params = new ArrayList<>();
        sql.append("SELECT * FROM todo_user u WHERE u.id IN (");
        sql.append("SELECT t.user_id FROM todo_task t WHERE t.title = ?)");
        params.add(taskTitle);
        return jdbcTemplate.query(sql.toString(), new BeanPropertyRowMapper<User>(User.class), params.toArray());
    }
}
