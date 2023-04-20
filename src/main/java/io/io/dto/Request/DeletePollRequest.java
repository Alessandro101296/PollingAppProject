package io.io.dto.Request;

public class DeletePollRequest {

    private long userId;
    private long pollId;

    public DeletePollRequest() {
    }

    public DeletePollRequest(long userId, long pollId) {
        this.userId = userId;
        this.pollId = pollId;
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
}
