package io.io.service;


import io.io.Exception.NoChoiceException;
import io.io.Exception.NoPollException;
import io.io.Exception.NoUserException;
import io.io.dto.IdResponse;
import io.io.dto.VoteRequest;
import io.io.entity.*;
import io.io.repository.ChoiceRepo;
import io.io.repository.PollRepo;
import io.io.repository.UserRepo;
import io.io.repository.VoteRepo;
import jakarta.persistence.Id;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VoteService {

    private VoteRepo voteRepo;

    private UserRepo userRepo;
    private PollRepo pollRepo;

    private ChoiceRepo choiceRepo;
    public VoteService(VoteRepo voteRepo,UserRepo userRepo,ChoiceRepo choiceRepo,PollRepo pollRepo){
        this.voteRepo=voteRepo;
        this.choiceRepo=choiceRepo;
        this.pollRepo=pollRepo;
        this.userRepo=userRepo;
    }

    public VoteId votePoll(VoteRequest voteRequest) throws NoChoiceException, NoUserException, NoPollException {
        /*controllare che un utente abbia votato una sola scelta*/
        Choice choice= choiceRepo.findById(voteRequest.getChoiceId()).orElseThrow(()->new NoChoiceException());
        User user=userRepo.findById(voteRequest.getUserId()).orElseThrow(()-> new NoUserException());
        Poll poll=pollRepo.findById(voteRequest.getPollId()).orElseThrow(()-> new NoPollException());
        VoteId voteId=new VoteId(user,poll);
        Vote vote=new Vote(voteId,choice);
        return voteRepo.save(vote).getId();
    }
}
