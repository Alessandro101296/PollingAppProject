package io.io.service;

import io.io.dto.NewPollRequest;
import io.io.entity.Poll;
import io.io.entity.User;
import io.io.repository.PollRepository;
import io.io.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
import java.util.Optional;
@Service
public class PollService {
    private UserRepository userRepository;
    private PollRepository pollRepository;
    public PollService(UserRepository userRepository,PollRepository pollRepository){
        this.userRepository=userRepository;
        this.pollRepository=pollRepository;
    }

    public Poll createNewPoll(NewPollRequest pollRequest){
        Optional<User> findedUser=userRepository.findByUsername(pollRequest.getUsername());
        Poll newPoll=new Poll();
        if(findedUser.isPresent()){
            newPoll.setUser(findedUser.get());
            newPoll.setQuestion(pollRequest.getQuestion());
            Instant instant=Instant.now().plus(Duration.ofDays(pollRequest.getNumberOfDays()));
            newPoll.setExpirationDateTime(instant);
            pollRepository.save(newPoll);
        }
        return newPoll;
    }
}
