package io.io.dto.Request;

public class UpdateVoteRequest {
    private long voteId;

    private long userId;
    private long newChoiceId;

    public UpdateVoteRequest(long userId , long newChoiceId,long voteId) {
        this.userId = userId;
        this.newChoiceId = newChoiceId;
        this.voteId=voteId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getNewChoiceId() {
        return newChoiceId;
    }

    public void setNewChoiceId(long newChoiceId) {
        this.newChoiceId = newChoiceId;
    }

    public long getVoteId() {
        return voteId;
    }

    public void setVoteId(long voteId) {
        this.voteId = voteId;
    }
}
