package io.io.service;

import io.io.Exception.NoChoiceException;
import io.io.Mapper.ChoiceMapper;
import io.io.dto.Response.ChoiceModel;
import io.io.entity.Choice;
import io.io.repository.ChoiceRepository;
import org.springframework.stereotype.Service;

@Service
public class ChoiceService {

    private final ChoiceRepository choiceRepository;

    private final ChoiceMapper choiceMapper;

    public ChoiceService(ChoiceRepository choiceRepository, ChoiceMapper choiceMapper) {
        this.choiceRepository = choiceRepository;

        this.choiceMapper = choiceMapper;
    }

    public ChoiceModel getChoice(long choiceId) throws NoChoiceException {
        Choice choice = choiceRepository.findById(choiceId).orElseThrow(() -> new NoChoiceException());
        return choiceMapper.choiceToModel(choice);
    }


}
