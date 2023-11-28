package com.simplytodo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.simplytodo.annotation.Password;
import com.simplytodo.annotation.Phone;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "user")
@Table(name = "todo_user")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    @NotEmpty(message = "Name cannot be empty")
    private String name;

    @Email
    private String email;

    @Password(message = "Invalid password. Password must be at least 8 characters long, contain an uppercase letter, a number, and a special character.")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @Phone(message = "Invalid phone number")
    private String phone;

    @Transient // this field will not be persisted in the database
    private List<TodoTask> tasks;
}
