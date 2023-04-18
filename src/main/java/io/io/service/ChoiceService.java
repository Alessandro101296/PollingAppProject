package io.io.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.io.dto.Request.CreateNewChoicesRequest;
import io.io.entity.Choice;
import io.io.entity.Poll;
import io.io.repository.ChoiceRepository;
import io.io.repository.PollRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ChoiceService {

    private PollRepository pollRepository;
    private ChoiceRepository choiceRepository;

    public ChoiceService(ChoiceRepository choiceRepository,PollRepository pollRepository){
        this.choiceRepository=choiceRepository;
        this.pollRepository=pollRepository;
    }

    public Choice createNewChoice(Choice choice, Poll poll){
        choice.setPoll(poll);
        return choiceRepository.save(choice);
    }

    public void createNewChoises(CreateNewChoicesRequest choices) throws JsonProcessingException {
        Poll poll=pollRepository.findById(choices.getPollId()).get();
        List<Choice> createdchoices=new ArrayList<>();
        for(Choice choice:choices.getChoiceList()){
            createdchoices.add(this.createNewChoice(choice,poll));
        }
    }

}
