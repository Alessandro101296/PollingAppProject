package io.io.controller;


import io.io.dto.Request.AddNewVoteRequest;
import io.io.service.VoteService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vote")
public class VoteController {
    private VoteService voteService;

    public VoteController(VoteService voteService){
        this.voteService=voteService;
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void addNewVote(@RequestBody AddNewVoteRequest voteRequest){
        voteService.addVote(voteRequest);

    }
}
