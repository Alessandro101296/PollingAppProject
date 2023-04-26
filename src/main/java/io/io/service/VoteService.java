package io.io.service;


import io.io.Exception.NoChoiceException;
import io.io.Exception.NoUserException;
import io.io.dto.IdResponse;
import io.io.dto.VoteRequest;
import io.io.entity.Choice;
import io.io.entity.User;
import io.io.entity.Vote;
import io.io.repository.ChoiceRepo;
import io.io.repository.UserRepo;
import io.io.repository.VoteRepo;
import jakarta.persistence.Id;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VoteService {

    private VoteRepo voteRepo;

    private UserRepo userRepo;

    private ChoiceRepo choiceRepo;
    public VoteService(VoteRepo voteRepo,ChoiceRepo choiceRepo){
        this.voteRepo=voteRepo;
        this.choiceRepo=choiceRepo;
    }

    public IdResponse votePoll(VoteRequest voteRequest) throws NoChoiceException, NoUserException {
        Choice choice= choiceRepo.findById(voteRequest.getChoiceId()).orElseThrow(()->new NoChoiceException());
        User user=userRepo.findById(voteRequest.getUserId()).orElseThrow(()-> new NoUserException());
        Vote vote=new Vote();
        vote.setChoice(choice);
        vote.setUser(user);
        return new IdResponse(voteRepo.save(vote).getId());
    }
}
