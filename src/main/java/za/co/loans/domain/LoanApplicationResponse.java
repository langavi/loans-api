package za.co.loans.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoanApplicationResponse {

    @ApiModelProperty(value = "Generated reference number for you application")
    private UUID reference;

    @ApiModelProperty(value = "Validation errors")
    private List<String> errors;

    @ApiModelProperty(value = "Validation warnings")
    private List<String> warnings;

    @ApiModelProperty(example = "false", required = true, value = "Indicates whether the application is approved/declined")
    public boolean isApproved() {
        return CollectionUtils.isEmpty(errors);
    }
}
