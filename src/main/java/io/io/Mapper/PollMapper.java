package io.io.Mapper;

import io.io.dto.Request.PollModelCreateRequest;
import io.io.dto.Response.ChoiceModel;
import io.io.dto.Response.IdResponse;
import io.io.dto.Response.PollModel;
import io.io.entity.Choice;
import io.io.entity.Poll;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PollMapper {

    @Mapping(target = "poll.expirationDate",expression = "java(java.util.Date.from(java.time.Instant.now().plus(java.time.Duration.ofDays(pollModelRequest.getExpirationDate()))))")
    @Mapping(target = "poll.user",ignore = true)
    PollChoicesReturnType reqCreatetoPoll(PollModelCreateRequest pollModelCreateRequest);

    IdResponse pollToId(Poll poll);

    @Mapping(target = "userId",expression = "java(poll.getUser().getId())")
    PollModel pollToModel(Poll poll);
    List<Choice> choiceModelListToChoiceList(List<ChoiceModel> choiceModelList);

    List<PollModel> listPollToListModel(List<Poll> pollList);

}
