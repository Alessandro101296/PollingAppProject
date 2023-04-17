package io.io.service;

import io.io.dto.AddNewVoteRequest;
import io.io.entity.Choice;
import io.io.entity.Poll;
import io.io.entity.User;
import io.io.entity.Vote;
import io.io.repository.ChoiceRepository;
import io.io.repository.PollRepository;
import io.io.repository.UserRepository;
import io.io.repository.VoteRepository;
import org.springframework.stereotype.Service;

@Service
public class VoteService {
    private UserRepository userRepository;
    private PollRepository pollRepository;
    private ChoiceRepository choiceRepository;
    private VoteRepository voteRepository;

    public VoteService(UserRepository userRepository, PollRepository pollRepository, ChoiceRepository choiceRepository, VoteRepository voteRepository){
        this.choiceRepository=choiceRepository;
        this.userRepository=userRepository;
        this.pollRepository=pollRepository;
        this.voteRepository=voteRepository;
    }

    public void addVote(AddNewVoteRequest voteRequest){
        User user=userRepository.findById(voteRequest.getUserid()).get();
        Poll poll=pollRepository.findById(voteRequest.getPollid()).get();
        Choice choice=choiceRepository.findById(voteRequest.getChoiceid()).get();
        Vote newVote=new Vote(poll,choice,user);
        voteRepository.save(newVote);
    }

}
