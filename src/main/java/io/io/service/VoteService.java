package io.io.service;


import io.io.Exception.ExpiredPollException;
import io.io.Exception.NoChoiceException;
import io.io.Exception.NoPollException;
import io.io.Exception.NoUserException;
import io.io.dto.Request.VoteRequest;
import io.io.entity.*;
import io.io.repository.ChoiceRepository;
import io.io.repository.PollRepository;
import io.io.repository.UserRepository;
import io.io.repository.VoteRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;

@Service
public class VoteService {

    private VoteRepository voteRepository;

    private UserRepository userRepository;
    private PollRepository pollRepository;

    private ChoiceRepository choiceRepository;
    public VoteService(VoteRepository voteRepository, UserRepository userRepository, ChoiceRepository choiceRepository, PollRepository pollRepository){
        this.voteRepository = voteRepository;
        this.choiceRepository = choiceRepository;
        this.pollRepository = pollRepository;
        this.userRepository = userRepository;
    }

    public VoteId votePoll(VoteRequest voteRequest) throws NoChoiceException, NoUserException, NoPollException, ExpiredPollException {
        Choice choice= choiceRepository.findById(voteRequest.getChoiceId()).orElseThrow(()->new NoChoiceException());
        User user= userRepository.findById(voteRequest.getUserId()).orElseThrow(()-> new NoUserException());
        Poll poll= pollRepository.findById(voteRequest.getPollId()).orElseThrow(()-> new NoPollException());
        if(Date.from(Instant.now()).after(poll.getExpirationDate())) {
            throw new ExpiredPollException();
        }
        VoteId voteId=new VoteId(user,poll);
        Vote vote=new Vote(voteId,choice);
        return voteRepository.save(vote).getId();
    }
    public void removeVote(){

    }
}
