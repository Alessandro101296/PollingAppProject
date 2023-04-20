package io.io.ExceptionHandler;

import io.io.Exception.ChoiceNotAssociatedToPoll;
import io.io.Exception.NonExistingChoice;
import io.io.Exception.NonExistingPoll;
import io.io.Exception.PollNotAssociatedToUser;
import io.io.dto.Response.ExceptionCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class PollControllerExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ChoiceNotAssociatedToPoll.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    ExceptionCode choiceNotAssociatedToPollHandler(ChoiceNotAssociatedToPoll choiceNotAssociatedToPoll){
        return new ExceptionCode(1);
    }
    @ExceptionHandler(PollNotAssociatedToUser.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ExceptionCode pollNotAssociatedToUserHandler(PollNotAssociatedToUser pollNotAssociatedToUser){
        return new ExceptionCode(2);
    }
    @ExceptionHandler(NonExistingPoll.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ExceptionCode nonExistingPollHandler(NonExistingPoll nonExistingPoll){
        return new ExceptionCode(3);
    }
    @ExceptionHandler(NonExistingChoice.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ExceptionCode nonExistingChoiceHandler(NonExistingChoice nonExistingChoice){
        return new ExceptionCode(4);
    }
}
