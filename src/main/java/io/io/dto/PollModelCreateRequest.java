package io.io.dto;

import io.io.entity.Choice;
import io.io.entity.User;

import java.util.List;

public class PollModelCreateRequest {
    private String question;
    private List<Choice> choiceList;
    private long userId;
    private int expirationDate;

    public PollModelCreateRequest() {
    }

    public PollModelCreateRequest(String question, List<Choice> choiceList, long userId, int expirationDate) {
        this.question = question;
        this.choiceList = choiceList;
        this.userId = userId;
        this.expirationDate = expirationDate;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<Choice> getChoiceList() {
        return choiceList;
    }

    public void setChoiceList(List<Choice> choiceList) {
        this.choiceList = choiceList;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public int getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(int expirationDate) {
        this.expirationDate = expirationDate;
    }
}
