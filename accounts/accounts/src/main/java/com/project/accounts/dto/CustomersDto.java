package com.project.accounts.dto;


import com.project.accounts.utils.BranchAddress;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class CustomersDto {
    @NotBlank
    private String name;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    @Pattern(regexp="(^$|[0-9]{10})")
    private String phoneNumber;

    private BranchAddress branchAddress;

    private AccountsDto accountsDto;
}
