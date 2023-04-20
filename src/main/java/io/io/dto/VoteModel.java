package io.io.dto;

public class VoteModel {

    private long id;


    private ChoiceModel choice;


    private UserModel user;

    public VoteModel() {
    }

    public VoteModel(long id, ChoiceModel choice, UserModel user) {
        this.id = id;
        this.choice = choice;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
