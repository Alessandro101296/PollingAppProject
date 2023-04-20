package io.io.Mapper;

import io.io.dto.ChoiceModel;
import io.io.dto.PollModel;
import io.io.dto.UserModel;
import io.io.dto.VoteModel;
import io.io.entity.Choice;
import io.io.entity.Poll;
import io.io.entity.User;
import io.io.entity.Vote;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MapperEntityModel {
    @Mapping(target = "user",ignore = true)
    PollModel pollToPollModel(Poll poll);
    UserModel userToUserModel(User user);
    VoteModel voteToVoteModel(Vote vote);
    @Mapping(target = "poll",ignore = true)
    @Mapping(target = "votes",ignore = true)
    ChoiceModel choicheToChoiceModel(Choice choice);

}
