package io.io.dto.Request;

public class RemoveVoteRequest {
    private long userid;
    private long voteId;

    public RemoveVoteRequest(long userid,long voteId) {
        this.userid = userid;

        this.voteId = voteId;
    }

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }



    public long getVoteId() {
        return voteId;
    }

    public void setVoteId(long voteId) {
        this.voteId = voteId;
    }
}
