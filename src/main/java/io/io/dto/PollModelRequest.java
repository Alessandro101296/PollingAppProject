package io.io.dto;

import jakarta.validation.constraints.NotBlank;

import java.util.List;

public class PollModelRequest {
    @NotBlank
    private String question;

    @NotBlank
    private long user;

    @NotBlank
    private long expirationDate;

    public PollModelRequest() {
    }

    public PollModelRequest( String question, long user, long expirationDate) {
        this.question = question;
        this.user = user;
        this.expirationDate = expirationDate;
    }


    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
    public long getUser() {
        return user;
    }

    public void setUser(long user) {
        this.user = user;
    }

    public long getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(long expirationDate) {
        this.expirationDate = expirationDate;
    }
}
