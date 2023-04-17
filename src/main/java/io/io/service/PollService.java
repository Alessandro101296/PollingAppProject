package io.io.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.io.dto.CreateNewPollRequest;
import io.io.dto.PollIdResponse;
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
    public PollService(UserRepository userRepository,PollRepository pollRepository,ChoiceRepository choiceRepository){
        this.userRepository=userRepository;
        this.pollRepository=pollRepository;
        this.choiceRepository=choiceRepository;
    }

    public String createNewPoll(CreateNewPollRequest pollRequest) throws JsonProcessingException {
        ObjectMapper mapper=new ObjectMapper();
        Optional<User> findedUser=userRepository.findByUsername(pollRequest.getUsername());
        Poll newPoll=new Poll();
        if(findedUser.isPresent()){
            newPoll.setUser(findedUser.get());
            newPoll.setQuestion(pollRequest.getQuestion());
            List<Choice> choiceList=pollRequest.getChoiceList();
            for(Choice choice:choiceList){
                newPoll.addChoice(choice);
            }
            Date instant=Date.from(Instant.now().plus(Duration.ofDays(pollRequest.getNumberOfDays())));
            newPoll.setExpirationDateTime(instant);
            pollRepository.save(newPoll);
        }
        PollIdResponse response=new PollIdResponse(newPoll.getId());
        return mapper.writeValueAsString(response);

    }
    public String findPollByUser(long userId) throws JsonProcessingException {
        ObjectMapper mapper=new ObjectMapper();
        User user=userRepository.findById(userId).get();
        List<Poll> pollList= user.getPollList();
        return mapper.writeValueAsString(pollList);
    }
    public String findPollByExpirationTime(int numberOfDays) throws  JsonProcessingException{
        ObjectMapper mapper=new ObjectMapper();
        Date instant=Date.from(Instant.now().plus(Duration.ofDays(numberOfDays)));
        List<Poll> pollList=pollRepository.findByExpirationDateTimeIsLessThan(instant).get();
        return mapper.writeValueAsString(pollList);
    }

}
