package io.io.dto.Response;

import io.io.entity.Choice;

import java.util.List;

public class PollIdResponse {
    private long id;
    private List<Choice> choiceList;

    public PollIdResponse(long id, List<Choice> choiceList) {
        this.id = id;
        this.choiceList = choiceList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Choice> getChoiceList() {
        return choiceList;
    }

    public void setChoiceList(List<Choice> choiceList) {
        this.choiceList = choiceList;
    }
}
