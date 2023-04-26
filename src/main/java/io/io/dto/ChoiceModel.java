package io.io.dto;

import java.util.List;

public class ChoiceModel {

    private long id;

    private String text;


    private List<VoteModel> listVotes;

    public ChoiceModel() {
    }

    public ChoiceModel(long id, String text,  List<VoteModel> listVotes) {
        this.id = id;
        this.text = text;
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

    public List<VoteModel> getListVotes() {
        return listVotes;
    }

    public void setListVotes(List<VoteModel> listVotes) {
        this.listVotes = listVotes;
    }
}
