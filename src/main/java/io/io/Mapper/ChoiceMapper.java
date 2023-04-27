package io.io.Mapper;

import io.io.dto.Response.ChoiceModel;
import io.io.entity.Choice;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface ChoiceMapper {

    Choice modelToChoice(ChoiceModel choiceModel);

    ChoiceModel choiceToModel(Choice choice);
}

