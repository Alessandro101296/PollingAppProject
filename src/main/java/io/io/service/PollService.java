package io.io.service;

import io.io.Exception.NoPollException;
import io.io.Exception.NoUserException;
import io.io.Mapper.PollChoicesReturnType;
import io.io.Mapper.PollMapper;
import io.io.dto.IdResponse;
import io.io.dto.PollModel;
import io.io.dto.PollModelCreateRequest;
import io.io.entity.Choice;
import io.io.entity.Poll;
import io.io.entity.User;
import io.io.repository.ChoiceRepo;
import io.io.repository.PollRepo;
import io.io.repository.UserRepo;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PollService {

    private final PollRepo pollRepo;
    private final UserRepo userRepo;
    private final ChoiceRepo choiceRepo;
    private final PollMapper pollMapper;


    public PollService(PollRepo pollRepo, UserRepo userRepo,PollMapper pollMapper,ChoiceRepo choiceRepo) {
        this.pollRepo = pollRepo;
        this.userRepo=userRepo;
        this.pollMapper = pollMapper;
        this.choiceRepo=choiceRepo;
    }

    @Transactional
    public IdResponse createPoll(PollModelCreateRequest pollModelCreateRequest) throws NoUserException {
        User user=userRepo.findById(pollModelCreateRequest.getPoll().getUser()).orElseThrow(()->new NoUserException());
        PollChoicesReturnType pollChoice=pollMapper.reqCreatetoPoll(pollModelCreateRequest);
        Poll poll=pollChoice.getPoll();
        poll.setUser(user);
        Poll pollSaved=pollRepo.save(poll);
        for(Choice choice: pollChoice.getChoice()){
            choice.setPoll(pollSaved);
            choiceRepo.save(choice);
        }
        return new IdResponse(pollSaved.getId());

    }
    public PollModel getPoll(long pollId) throws NoPollException {
        Poll poll=pollRepo.findById(pollId).orElseThrow(()->new NoPollException());
        return pollMapper.pollToModel(poll);

    }
    public List<PollModel> findByUser(long userId) throws NoUserException {
        User user=userRepo.findById(userId).orElseThrow(()->new NoUserException());
        return pollMapper.listPollToListModel(user.getPollList());
    }




}
