package io.io.service;

import io.io.Exception.NoChoiceException;
import io.io.Exception.NoPollException;
import io.io.Exception.NoUserException;
import io.io.Mapper.ChoiceMapper;
import io.io.dto.ChoiceModel;
import io.io.dto.CreateChoicesRequest;
import io.io.dto.IdListResp;
import io.io.dto.IdResponse;
import io.io.entity.Choice;
import io.io.entity.Poll;
import io.io.entity.User;
import io.io.repository.ChoiceRepo;
import io.io.repository.PollRepo;
import io.io.repository.UserRepo;
import jakarta.transaction.Transactional;
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

    public ChoiceModel getChoice(long choiceId) throws NoChoiceException {
        Choice choice=choiceRepo.findById(choiceId).orElseThrow(()->new NoChoiceException());
        return choiceMapper.choiceToModel(choice);
    }



}
