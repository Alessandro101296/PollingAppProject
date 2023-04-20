package io.io.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.util.List;

public class PollModel {
    private String question;
    private List<ChoiceModel> choiceList;
    private Date expirationDateTime;
    @JsonIgnore
    private UserModel user;

    public PollModel() {
    }

    public PollModel(String question, List<ChoiceModel> choiceList, Date date) {

        this.question = question;
        this.choiceList = choiceList;
        this.expirationDateTime = date;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<ChoiceModel> getChoiceList() {
        return choiceList;
    }

    public void setChoiceList(List<ChoiceModel> choiceList) {
        this.choiceList = choiceList;
    }

    public Date getExpirationDateTime() {
        return expirationDateTime;
    }

    public void setExpirationDateTime(Date date) {
        this.expirationDateTime = date;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }
}

