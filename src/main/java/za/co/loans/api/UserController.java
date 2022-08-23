package za.co.loans.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import za.co.loans.domain.ValidationResponse;
import za.co.loans.domain.user.Token;
import za.co.loans.domain.user.User;
import za.co.loans.service.UserService;

@Api(tags = "Users")
@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @ApiOperation(value = "Registers a new user",
            notes = "Registers a new user on Enviro Bank Limited application")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ValidationResponse signUp(@RequestBody User user) {
        return userService.signUp(user);
    }


    @ApiOperation(value = "Signs in an existing user",
            notes = "Signs in an existing user on Enviro Bank Limited application")
    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Token signIn(@RequestBody User user) {
        return userService.signIn(user);
    }


    @ApiOperation(value = "Removes all users",
            notes = "Removes all users on Enviro Bank Limited application")
    @DeleteMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ValidationResponse deleteAll(@RequestHeader(value = "Authorization") String jwt) {
        userService.validateToken(jwt);
        return userService.deleteAll();
    }

    @ApiOperation(value = "Updates an existing user",
            notes = "Updates an existing user on Enviro Bank Limited application")
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ValidationResponse update(@RequestBody User user) {
        return userService.update(user);
    }
}
