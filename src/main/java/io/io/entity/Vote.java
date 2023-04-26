package io.io.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Vote")
public class Vote {
    @EmbeddedId
    private VoteId id;

    @ManyToOne
    @JoinColumn(name = "choiceid")
    private Choice choice;


    public Vote() {
    }

    public Vote(VoteId id, Choice choice) {
        this.id = id;
        this.choice = choice;
    }

    public VoteId getId() {
        return id;
    }

    public void setId(VoteId id) {
        this.id = id;
    }

    public Choice getChoice() {
        return choice;
    }

    public void setChoice(Choice choice) {
        this.choice = choice;
    }


}
