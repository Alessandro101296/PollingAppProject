package io.io.controller;

import io.io.dto.IdResponse;
import io.io.dto.PollModelCreateRequest;
import io.io.service.PollService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
    public IdResponse createPoll(@RequestBody PollModelCreateRequest pollModelCreateRequest){
        return pollService.createPoll(pollModelCreateRequest);
    }
}
