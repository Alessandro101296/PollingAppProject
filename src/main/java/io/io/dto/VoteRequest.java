package io.io.dto;

public class VoteRequest {

    private long userId;
    private long choiceId;

    public VoteRequest() {
    }

    public VoteRequest(long userId, long choiceId) {
        this.userId = userId;
        this.choiceId = choiceId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getChoiceId() {
        return choiceId;
    }

    public void setChoiceId(long choiceId) {
        this.choiceId = choiceId;
    }
}
