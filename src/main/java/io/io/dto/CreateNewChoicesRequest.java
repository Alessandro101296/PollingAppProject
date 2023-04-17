package io.io.dto;

import io.io.entity.Choice;
import java.util.List;


public class CreateNewChoicesRequest {

    private Long pollId;

    private List<Choice> choiceList;

    public CreateNewChoicesRequest(Long pollId, List<Choice> choiceList) {
        this.pollId = pollId;
        this.choiceList = choiceList;
    }

    public Long getPollId() {
        return pollId;
    }

    public void setPollId(Long pollId) {
        this.pollId = pollId;
    }

    public List<Choice> getChoiceList() {
        return choiceList;
    }

    public void setChoiceList(List<Choice> choiceList) {
        this.choiceList = choiceList;
    }
}
