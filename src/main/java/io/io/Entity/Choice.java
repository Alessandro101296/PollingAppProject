package io.io.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="Choises")
public class Choice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    private String text;
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    private Poll poll;

    public Choice() {
    }

    public Choice(String text, Poll poll) {
        this.text = text;
        this.poll = poll;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Poll getPoll() {
        return poll;
    }

    public void setPoll(Poll poll) {
        this.poll = poll;
    }


}
