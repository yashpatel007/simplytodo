package com.simplytodo.entity;

import com.simplytodo.enums.TodoTaskStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.Set;

@Document(collection = "todo_task")
@Data
public class TodoTask {

    @Id
    private String id;

    @NotEmpty(message = "Title cannot be null")
    private String title;

    private DescriptionBlock description;

    private TodoTaskStatus status = TodoTaskStatus.NOT_STARTED; // default value

    @FutureOrPresent(message = "Due date cannot be in the past")
    private Date dueDate; // due date for this task

    Metadata metadata = new Metadata(); // metadata for this task

    private Set<String> tags; // set of tags for this task

    private long user_id; // user who owns this task
}
