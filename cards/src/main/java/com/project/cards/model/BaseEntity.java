package com.project.cards.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@Data
public class BaseEntity {
    @CreatedDate
    private Date createdAt;
    @LastModifiedDate
    private Date lastModifiedAt;

    @Id
    private String id;

}
