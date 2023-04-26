package io.io.controller;

import io.io.Exception.NoChoiceException;
import io.io.Exception.NoUserException;
import io.io.dto.IdResponse;
import io.io.dto.VoteRequest;
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
    @RequestMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public IdResponse addVote(@RequestBody VoteRequest request) throws NoUserException, NoChoiceException {
        return voteService.votePoll(request);
    }
}
