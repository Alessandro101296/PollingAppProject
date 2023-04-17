package io.io.dto;

import io.io.entity.Choice;

import java.util.List;

public class CreateNewPollRequest {
    private String username;
    private String question;
    private List<Choice> choiceList;
    private int numberOfDays;

    public List<Choice> getChoiceList() {
        return choiceList;
    }


    public String getUsername() {
        return username;
    }


    public String getQuestion() {
        return question;
    }


    public int getNumberOfDays() {
        return numberOfDays;
    }

}
