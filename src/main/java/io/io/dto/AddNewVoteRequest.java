package io.io.dto;

import io.io.entity.Choice;
import io.io.entity.Poll;
import io.io.entity.User;

public class AddNewVoteRequest {

    private long pollid;
    private long userid;
    private long choiceid;

    public long getPollid() {
        return pollid;
    }

    public long getUserid() {
        return userid;
    }

    public long getChoiceid() {
        return choiceid;
    }
}
