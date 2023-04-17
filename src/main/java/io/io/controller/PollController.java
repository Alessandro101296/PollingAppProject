package io.io.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.io.dto.CreateNewPollRequest;
import io.io.dto.FindPollByUserRequest;

import io.io.service.ChoiceService;
import io.io.service.PollService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/poll")
public class PollController {
    private PollService pollService;
    public PollController(PollService pollService,ChoiceService choiceService){
        this.pollService=pollService;
    }

    @PostMapping("/create")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public String createNewPoll(@RequestBody CreateNewPollRequest pullRequest) throws JsonProcessingException {
        String response=this.pollService.createNewPoll((pullRequest));
        return response;
    }
    @PostMapping("/findbyuser")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public String findByUser(@RequestBody FindPollByUserRequest findPollByUserRequest) throws JsonProcessingException {
        String response=this.pollService.findPollByUser(findPollByUserRequest.getUserId());
        return response;
    }
    @PostMapping("/findbyexpr")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String findbyExpirationTime(@RequestParam (value = "days") int days) throws JsonProcessingException{
        String response=this.pollService.findPollByExpirationTime(days);
        return response;
    }

}
