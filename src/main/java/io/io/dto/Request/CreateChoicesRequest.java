package io.io.dto.Request;

import io.io.dto.Response.ChoiceModel;
import jakarta.validation.constraints.Size;

import java.util.List;

public class CreateChoicesRequest {

    private long pollId;
    private long userId;

    @Size(min=2,max=5)
    private List<ChoiceModel> choiceModelList;

    public CreateChoicesRequest(long pollId, long userId, List<ChoiceModel> choiceModelList) {
        this.pollId = pollId;
        this.userId = userId;
        this.choiceModelList = choiceModelList;
    }

    public long getPollId() {
        return pollId;
    }

    public void setPollId(long pollId) {
        this.pollId = pollId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public List<ChoiceModel> getChoiceModelList() {
        return choiceModelList;
    }

    public void setChoiceModelList(List<ChoiceModel> choiceModelList) {
        this.choiceModelList = choiceModelList;
    }
}
