package io.io.Mapper;

import io.io.dto.ChoiceModel;
import io.io.entity.Choice;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")

public interface ChoiceMapper {

    Choice modelToChoice(ChoiceModel choiceModel);

    ChoiceModel choiceToModel(Choice choice);
}

