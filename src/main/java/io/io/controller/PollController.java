package io.io.controller;

import io.io.Exception.NoPollException;
import io.io.Exception.NoUserException;
import io.io.dto.IdResponse;
import io.io.dto.PollModel;
import io.io.dto.PollModelCreateRequest;
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
    @ResponseBody
    public IdResponse createPoll(@RequestBody PollModelCreateRequest pollModelCreateRequest) throws NoUserException {
        return pollService.createPoll(pollModelCreateRequest);
    }

    @GetMapping("/get")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @ResponseBody
    public PollModel getPoll(@RequestParam(value = "poll") long pollId) throws NoPollException {
        return pollService.getPoll(pollId);
    }

    @GetMapping("/getbyuser")
    public List<PollModel> findByUser(@RequestParam(value = "user") long userId) throws NoUserException {
        return pollService.findByUser(userId);
    }


}
