package za.co.loans.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import za.co.loans.domain.LoanApplication;
import za.co.loans.domain.LoanApplicationResponse;
import za.co.loans.domain.ValidationResponse;
import za.co.loans.repository.LoanRepository;
import za.co.loans.service.validation.LoanApplicationValidation;

import java.util.UUID;

@Service
@AllArgsConstructor
public class LoanService {

    private final LoanRepository repository;
    private final LoanApplicationValidation validation;

    public LoanApplicationResponse apply(LoanApplication loanApplication) {
        ValidationResponse validationResponse = validation.validate(loanApplication);
        if (validationResponse.isSuccess()) {
            repository.add(loanApplication);
        }
        return LoanApplicationResponse.builder()
                .reference(UUID.randomUUID())
                .errors(validationResponse.getErrors())
                .warnings(validationResponse.getWarnings())
                .build();
    }

    public ValidationResponse deleteAll() {
        repository.deleteAll();
        return ValidationResponse.builder().build();
    }
}
