package io.io.service;

import io.io.Exception.NoPollException;
import io.io.Exception.NoUserException;
import io.io.Mapper.PollChoicesReturnType;
import io.io.Mapper.PollMapper;
import io.io.dto.Response.IdResponse;
import io.io.dto.Response.PollModel;
import io.io.dto.Request.PollModelCreateRequest;
import io.io.entity.Choice;
import io.io.entity.Poll;
import io.io.entity.User;
import io.io.repository.ChoiceRepository;
import io.io.repository.PollRepository;
import io.io.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PollService {

    private final PollRepository pollRepository;
    private final UserRepository userRepository;
    private final ChoiceRepository choiceRepository;
    private final PollMapper pollMapper;


    public PollService(PollRepository pollRepository, UserRepository userRepository, PollMapper pollMapper, ChoiceRepository choiceRepository) {
        this.pollRepository = pollRepository;
        this.userRepository = userRepository;
        this.pollMapper = pollMapper;
        this.choiceRepository = choiceRepository;
    }

    @Transactional
    public IdResponse createPoll(PollModelCreateRequest pollModelCreateRequest) throws NoUserException {
        User user = userRepository.findById(pollModelCreateRequest.getPoll().getUser()).orElseThrow(() -> new NoUserException());
        PollChoicesReturnType pollChoice = pollMapper.reqCreatetoPoll(pollModelCreateRequest);
        Poll poll = pollChoice.getPoll();
        poll.setUser(user);
        Poll pollSaved = pollRepository.save(poll);
        for (Choice choice : pollChoice.getChoice()) {
            choice.setPoll(pollSaved);
            choiceRepository.save(choice);
        }
        return new IdResponse(pollSaved.getId());
    }

    public PollModel getPoll(long pollId) throws NoPollException {
        Poll poll = pollRepository.findById(pollId).orElseThrow(() -> new NoPollException());
        return pollMapper.pollToModel(poll);

    }

    public List<PollModel> findByUser(long userId) throws NoUserException {
        User user = userRepository.findById(userId).orElseThrow(() -> new NoUserException());
        return pollMapper.listPollToListModel(user.getPollList());
    }
    public void removePoll(){
        
    }


}
