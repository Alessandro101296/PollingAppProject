package io.io.service;

import io.io.Mapper.PollMapper;
import io.io.dto.IdResponse;
import io.io.dto.PollModelCreateRequest;
import io.io.entity.Poll;
import io.io.entity.User;
import io.io.repository.PollRepo;
import io.io.repository.UserRepo;
import org.springframework.stereotype.Service;

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

    public IdResponse createPoll(PollModelCreateRequest pollModelCreateRequest){
        User user=userRepo.findById(pollModelCreateRequest.getUserId()).get();
        Poll createdPoll=pollMapper.reqCreatetoPoll(pollModelCreateRequest);
        createdPoll.setUser(user);
        return pollMapper.pollToId(pollRepo.save(createdPoll));
    }

}
