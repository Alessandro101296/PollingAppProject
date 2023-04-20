package io.io.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.io.entity.Poll;

import java.util.List;

public class ChoiceModel {
    private String text;

    @JsonIgnore
    private PollModel poll;
    @JsonIgnore
    private List<VoteModel> votes;

    public ChoiceModel() {
    }

    public ChoiceModel(String text,PollModel poll) {
        this.text = text;
        this.poll=poll;
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<VoteModel> getVotes() {
        return votes;
    }

    public void setVotes(List<VoteModel> votes) {
        this.votes = votes;
    }

    public PollModel getPoll() {
        return poll;
    }

    public void setPoll(PollModel poll) {
        this.poll = poll;
    }
}
