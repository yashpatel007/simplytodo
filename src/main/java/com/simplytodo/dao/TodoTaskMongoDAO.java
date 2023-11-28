package com.simplytodo.dao;

import com.simplytodo.entity.TodoTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TodoTaskMongoDAO {

    private MongoTemplate mongoTemplate;

    @Autowired
    public TodoTaskMongoDAO(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public List<TodoTask> getAllTasksbytitleForuser(long userId, String title){
        Query query = Query.query(Criteria.where("user_id").is(userId).and("title").is(title));
        return mongoTemplate.find(query, TodoTask.class);
    }
}
