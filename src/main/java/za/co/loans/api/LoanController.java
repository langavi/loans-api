package za.co.loans.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.loans.domain.LoanApplication;
import za.co.loans.domain.LoanApplicationResponse;
import za.co.loans.domain.ValidationResponse;
import za.co.loans.service.LoanService;
import za.co.loans.service.UserService;

@Api(tags = "Loans")
@RestController
@AllArgsConstructor
@RequestMapping("/loans")
public class LoanController {

    private final LoanService loanService;
    private final UserService userService;

    @ApiOperation(value = "Apply for a loan",
            notes = "One loan application request supported in the body.")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LoanApplicationResponse> applyForALoan(@RequestHeader(value = "Authorization") String jwt, @RequestBody LoanApplication loanApplication) {
        userService.validateToken(jwt);
        LoanApplicationResponse response = loanService.applyForALoan(loanApplication);
        return new ResponseEntity<>(response, response.isApproved() ? HttpStatus.CREATED : HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ApiOperation(value = "Removes all loan applications",
            notes = "Removes all loan applications on Enviro Bank Limited")
    @DeleteMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ValidationResponse deleteAll(@RequestHeader(value = "Authorization") String accessToken) {
        return loanService.deleteAll();
    }
}
