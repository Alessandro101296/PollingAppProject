package io.io.controller;

import io.io.Exception.NoPollException;
import io.io.Exception.NoUserException;
import io.io.dto.CreateChoicesRequest;
import io.io.dto.IdListResp;
import io.io.service.ChoiceService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/choice")
public class ChoiceController {
    private ChoiceService choiceService;

    public ChoiceController(ChoiceService choiceService) {
        this.choiceService = choiceService;
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public IdListResp createChoices(@RequestBody CreateChoicesRequest request) throws NoUserException, NoPollException {
        return choiceService.createChoices(request);
    }

}
