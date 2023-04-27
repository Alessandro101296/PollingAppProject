package io.io.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Choice",uniqueConstraints = {@UniqueConstraint(columnNames = {"text","pollId"})})
public class Choice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    private String text;

    @ManyToOne
    @JoinColumn(name = "pollId")
    private Poll poll;

    @OneToMany(mappedBy = "choice")
    private List<Vote> listVotes;

    public Choice() {
    }

    public Choice(long id, String text, Poll poll, List<Vote> listVotes) {
        this.id = id;
        this.text = text;
        this.poll = poll;
        this.listVotes = listVotes;
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

    public List<Vote> getListVotes() {
        return listVotes;
    }

    public void setListVotes(List<Vote> listVotes) {
        this.listVotes = listVotes;
    }
}
