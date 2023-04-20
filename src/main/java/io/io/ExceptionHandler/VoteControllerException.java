package io.io.ExceptionHandler;

import io.io.Exception.NonExistingPoll;
import io.io.Exception.NonExistingVote;
import io.io.Exception.WrongUserException;
import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class VoteControllerException  extends ResponseEntityExceptionHandler {

    @ExceptionHandler(WrongUserException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    void WrongUserExceptionHandler(WrongUserException wrongUserException){
        return;
    }
    @ExceptionHandler(NonExistingVote.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    void NonExistingVoteHandler(NonExistingVote nonExistingVote){
        return;
    }
    @ExceptionHandler(NonExistingPoll.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    void NonExistingPollHandler(NonExistingPoll nonExistingPoll){
        return;
    }
}
