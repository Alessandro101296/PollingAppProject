package io.io.dto.Request;

public class ModifyChoicesPollRequest {
    private long userId;
    private long pollId;
    private long choiceId;
    private String newChoiceText;

    public ModifyChoicesPollRequest() {
    }

    public ModifyChoicesPollRequest(long userId, long pollId, long choiceId, String newChoiceText) {
        this.userId = userId;
        this.pollId = pollId;
        this.choiceId = choiceId;
        this.newChoiceText = newChoiceText;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getPollId() {
        return pollId;
    }

    public void setPollId(long pollId) {
        this.pollId = pollId;
    }

    public long getChoiceId() {
        return choiceId;
    }

    public void setChoiceId(long choiceId) {
        this.choiceId = choiceId;
    }

    public String getNewChoiceText() {
        return newChoiceText;
    }

    public void setNewChoiceText(String newChoiceText) {
        this.newChoiceText = newChoiceText;
    }
}
