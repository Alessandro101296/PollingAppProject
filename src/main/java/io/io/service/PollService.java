package io.io.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.io.Exception.NonExistingUser;
import io.io.Mapper.PollMapper;
import io.io.dto.Request.CreateNewPollRequest;
import io.io.dto.Response.PollIdResponse;
import io.io.entity.Choice;
import io.io.entity.Poll;
import io.io.entity.User;
import io.io.repository.ChoiceRepository;
import io.io.repository.PollRepository;
import io.io.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;
@Service
public class PollService {
    private UserRepository userRepository;
    private PollRepository pollRepository;
    private ChoiceRepository choiceRepository;
    private PollMapper pollMapper;
    public PollService(UserRepository userRepository,PollRepository pollRepository,ChoiceRepository choiceRepository,PollMapper pollMapper){
        this.userRepository=userRepository;
        this.pollRepository=pollRepository;
        this.choiceRepository=choiceRepository;
        this.pollMapper=pollMapper;
    }

    public PollIdResponse createNewPoll(CreateNewPollRequest pollRequest) throws NonExistingUser {
        Optional<User> referencedUser=userRepository.findByUsername(pollRequest.getUsername());
        if(referencedUser.isPresent()){
            Poll poll=pollMapper.NewPollRequestToPoll(pollRequest);
            poll.setUser(referencedUser.get());
            Poll createdPoll=pollRepository.save(poll);
            PollIdResponse response=pollMapper.pollToPollIdResponse(createdPoll);
            return response;
        }
        else{
            throw new NonExistingUser();
        }

    }
    public List<Poll> findPollByUser(long userId) {
        ObjectMapper mapper=new ObjectMapper();
        User user=userRepository.findById(userId).get();
        List<Poll> pollList= user.getPollList();
        return pollList;
    }
    public List<Poll> findPollByExpirationTime(int numberOfDays){
        Date instant=Date.from(Instant.now().plus(Duration.ofDays(numberOfDays)));
        List<Poll> pollList=pollRepository.findByExpirationDateTimeIsLessThan(instant).get();
        return pollList;
    }

}
