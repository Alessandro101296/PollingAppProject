package io.io.controller;

import io.io.Exception.NoUserException;
import io.io.dto.Response.IdResponse;
import io.io.dto.Request.UserModelCreateRequest;
import io.io.dto.Response.UserModel;
import io.io.dto.Request.UserModelUpdateRequest;
import io.io.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService=userService;
    }

    @GetMapping("/get")
    @ResponseStatus(HttpStatus.OK)
    public UserModel getUser(@RequestParam (value = "id")long userId) throws NoUserException {
        return userService.getUser(userId);
    }


    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public IdResponse createUser(@RequestBody UserModelCreateRequest userModelCreateRequest){
        return userService.createUser(userModelCreateRequest);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public void updateUser(@RequestBody UserModelUpdateRequest userModelUpdateRequest) throws NoUserException {
        userService.updateUser(userModelUpdateRequest);
    }
}
