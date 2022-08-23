package za.co.loans.service;

import io.jsonwebtoken.Jwts;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import za.co.loans.domain.ValidationResponse;
import za.co.loans.domain.exception.UnauthorisedUserException;
import za.co.loans.domain.user.Token;
import za.co.loans.domain.user.User;
import za.co.loans.repository.UserRepository;

import java.util.Collections;
import java.util.Objects;

import static za.co.loans.service.utils.JwtUtils.JWT_KEY;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository repository;

    public ValidationResponse signUp(User user) {
        if (Objects.nonNull(user) && StringUtils.isNotBlank(user.getEmailAddress()) && StringUtils.isNotBlank(user.getPassword())) {
            repository.add(user);
            return ValidationResponse.builder()
                    .build();
        } else {
            return ValidationResponse.builder()
                    .errors(Collections.singletonList("E-mail address and password are required"))
                    .build();
        }
    }

    public Token signIn(User user) {
        if (repository.exists(user)) {
            String jwt = Jwts.builder()
                    .setSubject(user.getEmailAddress())
                    .signWith(JWT_KEY)
                    .compact();
            return Token.builder()
                    .jwt(jwt)
                    .build();
        } else {
            throw new UnauthorisedUserException("Invalid user");
        }
    }

    public ValidationResponse deleteAll() {
        repository.deleteAll();
        return ValidationResponse.builder().build();
    }
}
