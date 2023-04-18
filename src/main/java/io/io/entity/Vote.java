package io.io.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
@Table(name = "Votes")
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "poll_id", nullable = false)
    @JsonBackReference
    private Poll poll;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "choice_id", nullable = false)
    @JsonIgnore
    private Choice choice;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore
    private User user;

    public Vote() {
    }

    public Vote(Poll poll, Choice choice, User user) {
        this.poll = poll;
        this.choice = choice;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public Poll getPoll() {
        return poll;
    }

    public Choice getChoice() {
        return choice;
    }

    public User getUser() {
        return user;
    }

    public void setChoice(Choice choice) {
        this.choice = choice;
    }
}
