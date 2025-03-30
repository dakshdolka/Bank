package com.project.loans.model;


import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Data
public class BaseDocument {
    @CreatedDate
    private String createdDate;
    @LastModifiedDate
    private String lastModifiedAt;

}
