package io.io.service;

import io.io.entity.Choice;
import io.io.entity.Poll;
import io.io.repository.ChoiceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ChoiceService {

    private ChoiceRepository choiceRepository;

    public ChoiceService(ChoiceRepository choiceRepository){
        this.choiceRepository=choiceRepository;
    }

    public void createNewChoice(Choice choice, Poll poll){
        choice.setPoll(poll);
        choiceRepository.save(choice);
    }

    public void createChoicesFromList(List<Choice> choices,Poll poll){
        for(Choice choice:choices){
            this.createNewChoice(choice,poll);
        }
    }

}
