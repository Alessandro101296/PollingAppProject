package io.io.controller;

import io.io.Exception.NoChoiceException;
import io.io.Exception.NoPollException;
import io.io.Exception.NoUserException;
import io.io.dto.ChoiceModel;
import io.io.dto.CreateChoicesRequest;
import io.io.dto.IdListResp;
import io.io.service.ChoiceService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/choice")
public class ChoiceController {
    private ChoiceService choiceService;

    public ChoiceController(ChoiceService choiceService) {
        this.choiceService = choiceService;
    }

    @GetMapping("/get")
    @ResponseStatus(HttpStatus.OK)
    public ChoiceModel getChoice(@RequestParam (value = "choiceId") long choiceId) throws NoChoiceException {
        return choiceService.getChoice(choiceId);
    }

}
