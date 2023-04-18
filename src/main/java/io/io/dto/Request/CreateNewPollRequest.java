package io.io.dto.Request;

import io.io.entity.Choice;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class CreateNewPollRequest {
    @NotNull

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
