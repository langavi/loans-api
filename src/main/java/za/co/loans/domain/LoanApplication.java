package za.co.loans.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoanApplication {

    @ApiModelProperty(value = "First name of the applicant", example = "Thembinkosi")
    private String firstName;

    @ApiModelProperty(value = "Last name of the applicant", example = "Lorch")
    private String lastName;

    @ApiModelProperty(value = "ID Number of the applicant", example = "9901025391084")
    private String idNumber;

    @ApiModelProperty(value = "Bank Account")
    private BankAccount bankAccount;

    @ApiModelProperty(value = "Loan amount")
    private BigDecimal amount;

    @ApiModelProperty(value = "Date of collection (debit order)", example = "2022-09-25")
    private LocalDate collectionDate;
}
