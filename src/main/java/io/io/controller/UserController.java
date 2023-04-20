package io.io.controller;

import io.io.dto.IdResponse;
import io.io.dto.UserModelCreateRequest;
import io.io.dto.UserModel;
import io.io.dto.UserModelUpdateRequest;
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
    @ResponseBody
    public UserModel getUser(@RequestParam (value = "id")long userId){
        return userService.getUser(userId);
    }


    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public IdResponse createUser(@RequestBody UserModelCreateRequest userModelCreateRequest){
        return userService.createUser(userModelCreateRequest);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public void updateUser(@RequestBody UserModelUpdateRequest userModelUpdateRequest){
        userService.updateUser(userModelUpdateRequest);
    }
}
