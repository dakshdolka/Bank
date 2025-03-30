package com.project.accounts.model;


import com.project.accounts.utils.BranchAddress;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "accounts")
@AllArgsConstructor
@NoArgsConstructor
public class Account extends BaseEntity{

    private String customerId;
    @Id
    private String accountNumber;

    private String accountType;

    private BranchAddress branchAddress;

}
