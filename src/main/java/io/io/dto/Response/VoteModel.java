package io.io.dto.Response;

import io.io.entity.VoteId;

public class VoteModel {

    private VoteId id;
    private ChoiceModel choice;
    public VoteModel() {
    }

    public VoteModel(VoteId id, ChoiceModel choice) {
        this.id = id;
        this.choice = choice;
    }

    public VoteId getId() {
        return id;
    }

    public void setId(VoteId id) {
        this.id = id;
    }

    public ChoiceModel getChoice() {
        return choice;
    }

    public void setChoice(ChoiceModel choice) {
        this.choice = choice;
    }
}
