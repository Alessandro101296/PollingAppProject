package io.io.controller;

import io.io.Exception.NonExistingUser;
import io.io.dto.Request.CreateNewPollRequest;

import io.io.dto.Response.PollIdResponse;
import io.io.entity.Poll;
import io.io.service.ChoiceService;
import io.io.service.PollService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/poll")
public class PollController {
    private PollService pollService;
    public PollController(PollService pollService,ChoiceService choiceService){
        this.pollService=pollService;
    }

    @PostMapping("/create")
    @ResponseStatus(value = HttpStatus.CREATED)
    public PollIdResponse createNewPoll(@RequestBody CreateNewPollRequest pullRequest) throws NonExistingUser {
        PollIdResponse response=this.pollService.createNewPoll((pullRequest));
        return response;
    }
    @GetMapping("/findbyuser")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Poll> findByUser(@RequestParam (value = "userid") long userId){
        List<Poll> response=pollService.findPollByUser(userId);
        return response;
    }
    @GetMapping("/findbyexpr")
    @ResponseStatus(HttpStatus.OK)
    public List<Poll> findbyExpirationTime(@RequestParam (value = "days") int days) {
        List<Poll> response=pollService.findPollByExpirationTime(days);
        return response;
    }

}
