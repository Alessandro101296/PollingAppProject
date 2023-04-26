package io.io.Mapper;

import io.io.dto.IdResponse;
import io.io.dto.PollModel;
import io.io.dto.PollModelCreateRequest;
import io.io.entity.Poll;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PollMapper {

    @Mapping(target = "expirationDate",expression = "java(java.util.Date.from(java.time.Instant.now().plus(java.time.Duration.ofDays(pollModelCreateRequest.getExpirationDate()))))")
    Poll reqCreatetoPoll(PollModelCreateRequest pollModelCreateRequest);
    IdResponse pollToId(Poll poll);

    @Mapping(target = "userId",expression = "java(poll.getUser().getId())")
    PollModel pollToModel(Poll poll);


    List<PollModel> listPollToListModel(List<Poll> pollList);

}
