package io.io.controller;

import io.io.Exception.NoPollException;
import io.io.Exception.NoUserException;
import io.io.dto.Response.IdResponse;
import io.io.dto.Response.PollModel;
import io.io.dto.Request.PollModelCreateRequest;
import io.io.service.PollService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/poll")
public class PollController {
    private PollService pollService;

    public PollController(PollService pollService) {
        this.pollService = pollService;
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public IdResponse createPoll(@RequestBody PollModelCreateRequest pollModelCreateRequest) throws NoUserException {
        return pollService.createPoll(pollModelCreateRequest);
    }

    @GetMapping("/get")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public PollModel getPoll(@RequestParam(value = "pollId") long pollId) throws NoPollException {
        return pollService.getPoll(pollId);
    }

    @GetMapping("/getbyuser")
    public List<PollModel> findByUser(@RequestParam(value = "userId") long userId) throws NoUserException {
        return pollService.findByUser(userId);
    }


}
