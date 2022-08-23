package za.co.loans.service.validation;

import net.logstash.logback.encoder.org.apache.commons.lang.StringUtils;
import org.joda.time.Years;
import org.springframework.stereotype.Component;
import za.co.loans.domain.Banks;
import za.co.loans.domain.LoanApplication;
import za.co.loans.domain.ValidationResponse;
import za.co.loans.service.utils.IdNumberUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class LoanApplicationValidation {

    public ValidationResponse validate(LoanApplication loanApplication) {
        List<String> errors = new ArrayList<>();
        List<String> warnings = new ArrayList<>();

        validateFirstName(errors, loanApplication.getFirstName());
        validateLastName(errors, loanApplication.getLastName());
        validateIdNumber(loanApplication.getIdNumber(), errors);
        validateBankAccount(loanApplication, errors, warnings);

        return ValidationResponse.builder()
                .errors(errors)
                .warnings(warnings)
                .build();
    }

    private void validateLastName(List<String> errors, String lastName) {
        if (StringUtils.isBlank(lastName)) {
            errors.add("Last name is required");
        } else if (!StringUtils.isAlpha(lastName)) {
            errors.add("Last name must not contain any special characters and/or digits");
        }
    }

    private void validateFirstName(List<String> errors, String firstName) {
        if (StringUtils.isBlank(firstName)) {
            errors.add("First name is required");
        } else if (!StringUtils.isAlpha(firstName)) {
            errors.add("First name must not contain any special characters and/or digits");
        }
    }

    private void validateBankAccount(LoanApplication loanApplication, List<String> errors, List<String> warnings) {
        if (Objects.nonNull(loanApplication.getBankAccount()) && Objects.nonNull(loanApplication.getBankAccount().getAccountNumber())
                && loanApplication.getBankAccount().getAccountNumber().trim().length() != 10) {
            errors.add("Bank account number must be 10 digits");
        }

        if (Objects.nonNull(loanApplication.getBankAccount()) && Objects.nonNull(loanApplication.getBankAccount().getBankName())
                && Objects.equals(loanApplication.getBankAccount().getBankName(), Banks.VBS)) {
            warnings.add("Refer to compliance");
        }
    }

    private void validateIdNumber(String idNumber, List<String> errors) {
        if (Objects.nonNull(idNumber) && idNumber.trim().length() != 13) {
            errors.add("ID Number must be a valid South African ID number (13 digits)");
        } else if (IdNumberUtils.INSTANCE.getAge(idNumber).isLessThan(Years.years(18))) {
            errors.add("The client must be 18 years or older");
        }
    }
}
