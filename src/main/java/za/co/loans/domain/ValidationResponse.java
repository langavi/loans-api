package za.co.loans.domain;

import lombok.Builder;
import lombok.Data;

import java.util.List;

import static java.util.Objects.isNull;

@Data
@Builder
public class ValidationResponse {

    List<String> errors;
    List<String> warnings;

    public boolean isValid() {
        return isNull(errors) || errors.isEmpty();
    }
}
