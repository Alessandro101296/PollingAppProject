package io.io.dto;

public class PollIdResponse {
    private long pollId;

    public long getPollId() {
        return pollId;
    }

    public void setPollId(long pollId) {
        this.pollId = pollId;
    }

    public PollIdResponse(long pollId) {
        this.pollId = pollId;
    }
}
