package io.io.dto;

import java.util.List;

public class ChoiceModel {

    private long id;

    private String text;

    private PollModel poll;

    private List<VoteModel> listVotes;

    public ChoiceModel() {
    }

    public ChoiceModel(long id, String text, PollModel poll, List<VoteModel> listVotes) {
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

    public PollModel getPoll() {
        return poll;
    }

    public void setPoll(PollModel poll) {
        this.poll = poll;
    }

    public List<VoteModel> getListVotes() {
        return listVotes;
    }

    public void setListVotes(List<VoteModel> listVotes) {
        this.listVotes = listVotes;
    }
}
