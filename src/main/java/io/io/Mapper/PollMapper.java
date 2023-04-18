package io.io.Mapper;

import io.io.dto.Request.CreateNewPollRequest;
import io.io.dto.Response.PollIdResponse;
import io.io.entity.Poll;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PollMapper {

    @Mapping(target = "user",ignore = true)
    @Mapping(target = "expirationDateTime",expression = "java(java.util.Date.from(java.time.Instant.now().plus(java.time.Duration.ofDays(createNewPollRequest.getNumberOfDays()))))")
    Poll NewPollRequestToPoll(CreateNewPollRequest createNewPollRequest);


    PollIdResponse pollToPollIdResponse(Poll poll);
}
