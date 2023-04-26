package io.io.service;

import io.io.Exception.NoUserException;
import io.io.Mapper.PollMapper;
import io.io.dto.IdResponse;
import io.io.dto.PollModel;
import io.io.dto.PollModelCreateRequest;
import io.io.entity.Poll;
import io.io.entity.User;
import io.io.repository.PollRepo;
import io.io.repository.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PollService {

    private final PollRepo pollRepo;
    private final UserRepo userRepo;
    private final PollMapper pollMapper;


    public PollService(PollRepo pollRepo, UserRepo userRepo,PollMapper pollMapper) {
        this.pollRepo = pollRepo;
        this.userRepo=userRepo;
        this.pollMapper = pollMapper;
    }

    public IdResponse createPoll(PollModelCreateRequest pollModelCreateRequest) throws NoUserException {
        /* add user control*/
        User user=userRepo.findById(pollModelCreateRequest.getUserId()).orElseThrow(()->new NoUserException());
        Poll createdPoll=pollMapper.reqCreatetoPoll(pollModelCreateRequest);
        createdPoll.setUser(user);
        return pollMapper.pollToId(pollRepo.save(createdPoll));
    }
    public List<PollModel> findByUser(long userId){
        /* add user control*/
        User user=userRepo.findById(userId).get();
        return pollMapper.listPollToListModel(user.getPollList());

    }




}
