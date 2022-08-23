package za.co.loans.domain.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @ApiModelProperty(value = "E-mail address", example = "user@email.co.za")
    private String emailAddress;

    @ApiModelProperty(value = "Password", example = "*********")
    private String password;
}
