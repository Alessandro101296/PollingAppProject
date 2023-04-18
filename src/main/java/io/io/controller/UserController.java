package io.io.controller;


import io.io.Exception.ExistingUsernameException;
import io.io.dto.Request.CreateNewUserRequest;
import io.io.dto.Response.UserIdResponse;
import io.io.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;
    public UserController(UserService userService){
        this.userService=userService;
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public UserIdResponse createNewUser(@Valid @RequestBody CreateNewUserRequest createNewUserRequest) throws ExistingUsernameException {
        UserIdResponse response=userService.createNewUser(createNewUserRequest);
        return response;
    }
}
