package com.simplytodo.entity;

import com.simplytodo.enums.TodoTaskStatus;
import lombok.*;

import java.util.Date;

@Data
public class TodoTask {
    private int id;
    private String title;
    private String description;
    private TodoTaskStatus status = TodoTaskStatus.NOT_STARTED;
    private Date dueDate;
    private Date createdAt = Date.from(java.time.Instant.now());
}
