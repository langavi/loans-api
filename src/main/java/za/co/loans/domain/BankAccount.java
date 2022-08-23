package za.co.loans.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BankAccount {
    @ApiModelProperty(value = "Name of the bank")
    private Banks bankName;

    @ApiModelProperty(value = "Account number", example = "1234567890")
    private String accountNumber;

    @ApiModelProperty(value = "Branch code", example = "250060")
    private String branchCode;
}
