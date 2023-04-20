package io.io.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Vote")
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "choiceid")
    private Choice choice;

    @ManyToOne
    @JoinColumn(name = "userid")
    private User user;

    public Vote() {
    }

    public Vote(long id, Choice choice, User user) {
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

    public Choice getChoice() {
        return choice;
    }

    public void setChoice(Choice choice) {
        this.choice = choice;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
