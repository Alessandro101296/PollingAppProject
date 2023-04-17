package io.io.dto;

public class FindPollByUserRequest {

    private long userId;

    public FindPollByUserRequest() {
    }

    public FindPollByUserRequest(long userId) {
        this.userId = userId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }


}
