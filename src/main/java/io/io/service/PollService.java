package io.io.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.io.Exception.*;
import io.io.Mapper.MapperEntityModel;
import io.io.Mapper.PollMapper;
import io.io.dto.PollModel;
import io.io.dto.Request.CreateNewPollRequest;
import io.io.dto.Request.DeletePollRequest;
import io.io.dto.Request.ModifyChoicesPollRequest;
import io.io.dto.Response.PollIdResponse;
import io.io.entity.Choice;
import io.io.entity.Poll;
import io.io.entity.User;
import io.io.repository.ChoiceRepository;
import io.io.repository.PollRepository;
import io.io.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
@Service
public class PollService {
    private UserRepository userRepository;
    private PollRepository pollRepository;
    private ChoiceRepository choiceRepository;
    private PollMapper pollMapper;
    private MapperEntityModel mapperEntityModel;
    public PollService(UserRepository userRepository,PollRepository pollRepository,ChoiceRepository choiceRepository,PollMapper pollMapper,MapperEntityModel mapperEntityModel){
        this.userRepository=userRepository;
        this.pollRepository=pollRepository;
        this.choiceRepository=choiceRepository;
        this.pollMapper=pollMapper;
        this.mapperEntityModel=mapperEntityModel;
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
    public List<PollModel> findPollByUser(long userId) {
        User user=userRepository.findById(userId).get();
        List<Poll> pollList= user.getPollList();
        List<PollModel> response=new ArrayList<>();
        for(Poll poll:pollList){
            response.add(mapperEntityModel.pollToPollModel(poll));
        }
        return response;
    }
    public List<PollModel> findPollByExpirationTime(int numberOfDays){
        Date instant=Date.from(Instant.now().plus(Duration.ofDays(numberOfDays)));
        List<Poll> pollList=pollRepository.findByExpirationDateTimeIsLessThan(instant).get();
        List<PollModel> response=new ArrayList<>();
        for(Poll poll:pollList){
            response.add(mapperEntityModel.pollToPollModel(poll));
        }
        return response;
    }
    public void modifyPollChoice(ModifyChoicesPollRequest modifyChoicesPollRequest) throws NonExistingUser, NonExistingPoll, ChoiceNotAssociatedToPoll, NonExistingChoice, PollNotAssociatedToUser {
        Optional<User> user=userRepository.findById(modifyChoicesPollRequest.getUserId());
        if(user.isPresent()){
            User retriviedUser=user.get();
            Optional<Poll> poll=pollRepository.findById(modifyChoicesPollRequest.getPollId());
            if(poll.isPresent()){
                Poll retriviedPoll=poll.get();
                if(retriviedUser.getPollList().contains(retriviedPoll)){
                    Optional<Choice> choice=choiceRepository.findById(modifyChoicesPollRequest.getChoiceId());
                    if(choice.isPresent()){
                        Choice retriviedChoice=choice.get();
                        if(retriviedPoll.getChoiceList().contains(retriviedChoice)){
                            retriviedChoice.setText(modifyChoicesPollRequest.getNewChoiceText());
                            choiceRepository.save(retriviedChoice);
                        }else{
                            throw new ChoiceNotAssociatedToPoll();
                        }

                    }else{
                        throw new NonExistingChoice();
                    }
                }else{
                    throw new PollNotAssociatedToUser();
                }
            }else{
                throw new NonExistingPoll();
            }

        }else{
            throw new NonExistingUser();
        }
    }
    public void deletePoll(DeletePollRequest deletePollRequest) throws PollNotAssociatedToUser, NonExistingPoll, NonExistingUser {
        Optional<User> user=userRepository.findById(deletePollRequest.getUserId());
        if(user.isPresent()){
            User retriviedUser=user.get();
            Optional<Poll> poll=pollRepository.findById(deletePollRequest.getPollId());
            if(poll.isPresent()){
                Poll retriviedPoll=poll.get();
                if(retriviedUser==retriviedPoll.getUser()){
                    pollRepository.delete(retriviedPoll);
                }else{
                    throw new PollNotAssociatedToUser();
                }
            }else{
                throw new NonExistingPoll();
            }
        }else{
            throw new NonExistingUser();
        }
    }
}
