package io.io.controller;

import io.io.dto.NewPollRequest;
import io.io.entity.Choice;
import io.io.entity.Poll;
import io.io.service.ChoiceService;
import io.io.service.PollService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/poll")
public class PollController {
    private PollService pollService;
    private ChoiceService choiceService;
    public PollController(PollService pollService,ChoiceService choiceService){
        this.pollService=pollService;
        this.choiceService=choiceService;
    }

    @PostMapping("/create")
    public ResponseEntity createPoll(@RequestBody NewPollRequest pullRequest){
        Poll createdPoll=this.pollService.createNewPoll(pullRequest);
        this.choiceService.createChoicesFromList(pullRequest.getChoiceList(),createdPoll);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(createdPoll.toString());

    }
}
