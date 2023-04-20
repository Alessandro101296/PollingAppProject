package io.io.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.io.entity.Choice;
import io.io.entity.User;

public class VoteModel {

    private ChoiceModel choice;

    @JsonIgnore
    private UserModel user;

    public VoteModel( ChoiceModel choice) {
        this.choice = choice;
    }


    public ChoiceModel getChoice() {
        return choice;
    }

    public void setChoice(ChoiceModel choice) {
        this.choice = choice;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }
}
