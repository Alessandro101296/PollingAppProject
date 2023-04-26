package io.io.service;

import io.io.Exception.NoPollException;
import io.io.Exception.NoUserException;
import io.io.Mapper.ChoiceMapper;
import io.io.dto.ChoiceModel;
import io.io.dto.CreateChoicesRequest;
import io.io.dto.IdListResp;
import io.io.entity.Choice;
import io.io.entity.Poll;
import io.io.entity.User;
import io.io.repository.ChoiceRepo;
import io.io.repository.PollRepo;
import io.io.repository.UserRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ChoiceService {

    private ChoiceRepo choiceRepo;
    private UserRepo userRepo;
    private PollRepo pollRepo;

    private ChoiceMapper choiceMapper;

    public ChoiceService(ChoiceRepo choiceRepo, UserRepo userRepo, PollRepo pollRepo,ChoiceMapper choiceMapper){
        this.choiceRepo=choiceRepo;
        this.userRepo=userRepo;
        this.pollRepo=pollRepo;
        this.choiceMapper=choiceMapper;
    }


    public IdListResp createChoices(CreateChoicesRequest request) throws NoUserException, NoPollException {
        /*aggiungi controllo che tutti i text delle choice devono essere diversi*/
        List<Long> choicesId=new ArrayList<>();
        User user=userRepo.findById(request.getUserId()).orElseThrow(()-> new NoUserException());
        Poll poll=pollRepo.findById(request.getPollId()).orElseThrow(()-> new NoPollException());
        if(poll.getUser().equals(user)){
            for(ChoiceModel choiceModel : request.getChoiceModelList()) {
                Choice choice = choiceMapper.modelToChoice(choiceModel);
                choice.setPoll(poll);
                choicesId.add(choiceRepo.save(choice).getId());
            }
        }
        return new IdListResp(choicesId);
    }


}
