package io.io.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


public class UserModel {
    private long id;

    private String username;

    private String email;

    private String name;

    private List<PollModel> pollList;

    private List<VoteModel> voteList;

    public UserModel() {
    }

    public UserModel(long id, String username, String email, String name, List<PollModel> pollList, List<VoteModel> voteList) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.name = name;
        this.pollList = pollList;
        this.voteList = voteList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PollModel> getPollList() {
        return pollList;
    }

    public void setPollList(List<PollModel> pollList) {
        this.pollList = pollList;
    }

    public List<VoteModel> getVoteList() {
        return voteList;
    }

    public void setVoteList(List<VoteModel> voteList) {
        this.voteList = voteList;
    }
}
