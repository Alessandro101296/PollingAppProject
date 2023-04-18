package io.io.controller;


import io.io.Exception.WrongUserException;
import io.io.dto.Request.AddNewVoteRequest;
import io.io.dto.Request.RemoveVoteRequest;
import io.io.dto.Request.UpdateVoteRequest;
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
    @ResponseStatus(HttpStatus.CREATED)
    public void addNewVote(@RequestBody AddNewVoteRequest voteRequest){
        voteService.addVote(voteRequest);

    }
    @DeleteMapping("/remove")
    @ResponseStatus(HttpStatus.OK)
    public void removeVote(@RequestBody RemoveVoteRequest removeVoteRequest) throws WrongUserException {
        voteService.removeVote(removeVoteRequest);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public void updateVote(@RequestBody UpdateVoteRequest updateVoteRequest) throws WrongUserException {
        voteService.UpdateVote(updateVoteRequest);
    }

}
