package io.io.Mapper;

import io.io.entity.Choice;
import io.io.entity.Poll;

import java.util.List;

public class PollChoicesReturnType {
    private Poll poll;
    private List<Choice> choice;

    public PollChoicesReturnType() {
    }

    public PollChoicesReturnType(Poll poll, List<Choice> choice) {
        this.poll = poll;
        this.choice = choice;
    }

    public Poll getPoll() {
        return poll;
    }

    public void setPoll(Poll poll) {
        this.poll = poll;
    }

    public List<Choice> getChoice() {
        return choice;
    }

    public void setChoice(List<Choice> choiceList) {
        this.choice = choiceList;
    }
}
