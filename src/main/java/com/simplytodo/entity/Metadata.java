package com.simplytodo.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Document(collection = "metadata")
@Data
public class Metadata<T> {

    @Id
    private String id;
    private Date createdAt = Date.from(java.time.Instant.now());

    private Long created_by_user_id;

    private Date modifiedAt = Date.from(java.time.Instant.now());

    private String objectType;
}
