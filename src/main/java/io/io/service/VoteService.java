package io.io.service;

import io.io.Exception.NonExistingPoll;
import io.io.Exception.NonExistingUser;
import io.io.Exception.NonExistingVote;
import io.io.Exception.WrongUserException;
import io.io.dto.Request.AddNewVoteRequest;
import io.io.dto.Request.RemoveVoteRequest;
import io.io.dto.Request.UpdateVoteRequest;
import io.io.entity.Choice;
import io.io.entity.Poll;
import io.io.entity.User;
import io.io.entity.Vote;
import io.io.repository.ChoiceRepository;
import io.io.repository.PollRepository;
import io.io.repository.UserRepository;
import io.io.repository.VoteRepository;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

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

    public void addVote(AddNewVoteRequest voteRequest) throws NonExistingUser, NonExistingPoll {
        Optional<User> user=userRepository.findById(voteRequest.getUserid());
        if(user.isPresent()){
            User retriviedUser=user.get();
            Optional<Poll> poll=pollRepository.findById(voteRequest.getPollid());
            if(poll.isPresent()){
                Poll retriviedPoll=poll.get();
                Choice choice=choiceRepository.findById(voteRequest.getChoiceid()).get();
                Vote newVote=new Vote(retriviedPoll,choice,retriviedUser);
                voteRepository.save(newVote);
            }else{
                throw new NonExistingPoll();
            }

        }
        else{
            throw new NonExistingUser();
        }

    }

    public void removeVote(RemoveVoteRequest removeVoteRequest) throws WrongUserException, NonExistingVote {
        Optional<Vote> vote=voteRepository.findById(removeVoteRequest.getVoteId());
        if(vote.isPresent()){
            Vote retriviedVote=vote.get();
            if(retriviedVote.getUser().getId()==removeVoteRequest.getUserid()){
                voteRepository.delete(retriviedVote);
            }
            else {
                throw new WrongUserException();
            }
        }else{
            throw new NonExistingVote();
        }

    }
    public void UpdateVote(UpdateVoteRequest updateVoteRequest) throws WrongUserException, NonExistingVote {
        Optional<Vote> vote=voteRepository.findById(updateVoteRequest.getVoteId());
        if(vote.isPresent()){
            Vote retriviedVote=vote.get();
            if(retriviedVote.getUser().getId()==updateVoteRequest.getUserId()){
                retriviedVote.setChoice(choiceRepository.findById(updateVoteRequest.getNewChoiceId()).get());
                voteRepository.save(retriviedVote);
            }
            else {
                throw new WrongUserException();
            }
        }else{
            throw new NonExistingVote();
        }

    }

}
