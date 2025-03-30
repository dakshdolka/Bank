package com.project.accounts.model;


import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "customers")
public class Customer extends BaseEntity{
    @Id
    private String id;
    private String name;

    private String email;

    private String phoneNumber;

}
