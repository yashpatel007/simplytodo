package com.simplytodo.entity;

import com.simplytodo.enums.TodoTaskStatus;
import java.util.Date;

public class TodoTask {
    private static int idCounter = 0;

    private int id = idCounter++;
    private String title;
    private String description;
    private TodoTaskStatus status = TodoTaskStatus.NOT_STARTED;
    private Date dueDate;
    private Date createdAt = Date.from(java.time.Instant.now());

    public int getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TodoTaskStatus getStatus() {
        return status;
    }

    public void setStatus(TodoTaskStatus status) {
        this.status = status;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
