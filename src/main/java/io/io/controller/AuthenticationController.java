package io.io.controller;

import io.io.Exception.NoRoleException;
import io.io.dto.Request.LogInRequest;
import io.io.dto.Request.SignUpRequest;
import io.io.dto.Response.JwtAuthenticationResponse;
import io.io.service.AuthenticationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService){
        this.authenticationService=authenticationService;
    }
    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public JwtAuthenticationResponse login(@Valid @RequestBody LogInRequest request){
        return authenticationService.login(request);
    }

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public void signup(@Valid @RequestBody SignUpRequest request) throws NoRoleException {
        authenticationService.signup(request);
    }

}
