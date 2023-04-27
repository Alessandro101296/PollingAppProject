package io.io.controller;

import io.io.Exception.ExpiredPollException;
import io.io.Exception.NoChoiceException;
import io.io.Exception.NoPollException;
import io.io.Exception.NoUserException;
import io.io.dto.Request.VoteRequest;
import io.io.entity.VoteId;
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
    public VoteId addVote(@RequestBody VoteRequest request) throws NoUserException, NoChoiceException, NoPollException, ExpiredPollException {
        return voteService.votePoll(request);
    }
}
