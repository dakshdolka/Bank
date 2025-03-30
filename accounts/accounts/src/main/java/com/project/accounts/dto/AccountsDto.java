package com.project.accounts.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccountsDto {
    @NotBlank
    private String accountNumber;
    @NotBlank
    private String accountType;
    @NotBlank
    private String branchAddress;
}
