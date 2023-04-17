package io.io.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.io.dto.CreateNewChoicesRequest;
import io.io.service.ChoiceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/choice")
public class ChoiceController {
    private ChoiceService choiceService;

    public ChoiceController(ChoiceService choiceService) {
        this.choiceService = choiceService;
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void createChoices(@RequestBody CreateNewChoicesRequest newChoises) throws JsonProcessingException {
        this.choiceService.createNewChoises(newChoises);
    }
}
