package io.io.controller;

import io.io.Exception.*;
import io.io.dto.PollModel;
import io.io.dto.Request.CreateNewPollRequest;

import io.io.dto.Request.DeletePollRequest;
import io.io.dto.Request.ModifyChoicesPollRequest;
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
    public List<PollModel> findByUser(@RequestParam (value = "userid") long userId){
        List<PollModel> response=pollService.findPollByUser(userId);
        return response;
    }
    @GetMapping("/findbyexpr")
    @ResponseStatus(HttpStatus.OK)
    public List<PollModel> findbyExpirationTime(@RequestParam (value = "days") int days) {
        List<PollModel> response=pollService.findPollByExpirationTime(days);
        return response;
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public void updatePollChoice(@RequestBody ModifyChoicesPollRequest modifyChoicesPollRequest) throws NonExistingUser, PollNotAssociatedToUser, ChoiceNotAssociatedToPoll, NonExistingPoll, NonExistingChoice {
        pollService.modifyPollChoice(modifyChoicesPollRequest);
    }
    @DeleteMapping("/delete")
    @ResponseStatus(HttpStatus.OK)
    public void deletePoll(@RequestBody DeletePollRequest deletePollRequest) throws PollNotAssociatedToUser, NonExistingUser, NonExistingPoll {
        pollService.deletePoll(deletePollRequest);
    }
}
