package com.simplytodo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Metadata<T> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date createdAt = Date.from(java.time.Instant.now());

    @ManyToOne
    @JoinColumn(name = "created_by")
    private User createdBy;

    private Date modifiedAt = Date.from(java.time.Instant.now());

    private String objectType;
}
