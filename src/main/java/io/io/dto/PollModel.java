package io.io.dto;

import java.util.Date;
import java.util.List;

public class PollModel {

    private long id;

    private String question;


    private List<ChoiceModel> choiceList;


    private UserModel user;

    private Date expirationDate;

    public PollModel() {
    }

    public PollModel(long id, String question, List<ChoiceModel> choiceList, UserModel user, Date expirationDate) {
        this.id = id;
        this.question = question;
        this.choiceList = choiceList;
        this.user = user;
        this.expirationDate = expirationDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }
}
