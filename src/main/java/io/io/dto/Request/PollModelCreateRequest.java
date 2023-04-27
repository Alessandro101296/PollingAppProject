package io.io.dto.Request;

import io.io.dto.Response.ChoiceModel;
import jakarta.validation.constraints.Size;

import java.util.List;

public class PollModelCreateRequest {
    private PollModelRequest poll;
    @Size(min=2,max=6)
    private List<ChoiceModel> choice;

    public PollModelCreateRequest() {
    }

    public PollModelCreateRequest(PollModelRequest poll, List<ChoiceModel> choice) {
        this.poll = poll;
        this.choice = choice;
    }

    public PollModelRequest getPoll() {
        return poll;
    }

    public void setPoll(PollModelRequest poll) {
        this.poll = poll;
    }

    public List<ChoiceModel> getChoice() {
        return choice;
    }

    public void setChoice(List<ChoiceModel> choice) {
        this.choice = choice;
    }
}
