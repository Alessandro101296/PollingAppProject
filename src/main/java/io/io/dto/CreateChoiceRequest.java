package io.io.dto;

public class CreateChoiceRequest {

    private long pollId;
    private long userId;
    private ChoiceModel choice;

    public CreateChoiceRequest() {
    }

    public CreateChoiceRequest(long pollId, long userId, ChoiceModel choice) {
        this.pollId = pollId;
        this.userId = userId;
        this.choice = choice;
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

    public ChoiceModel getChoice() {
        return choice;
    }

    public void setChoice(ChoiceModel choice) {
        this.choice = choice;
    }
}
