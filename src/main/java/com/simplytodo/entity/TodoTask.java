package com.simplytodo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.simplytodo.enums.TodoTaskStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.Date;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
public class TodoTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private UUID uuid = UUID.randomUUID();

    @NotEmpty(message = "Title cannot be null")
    private String title;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "description_id")
    private DescriptionBlock description; // description for this task, root node.

    private TodoTaskStatus status = TodoTaskStatus.NOT_STARTED; // default value

    @FutureOrPresent(message = "Due date cannot be in the past")
    private Date dueDate; // due date for this task

    @OneToOne(cascade = CascadeType.ALL)
    Metadata metadata = new Metadata(); // metadata for this task

    private Set<String> tags; // set of tags for this task

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user; // user who owns this task
}
