package io.io.entity;


import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;

@Embeddable
public class VoteId implements Serializable {
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "pollId")
    private Poll poll;

    public VoteId() {
    }

    public VoteId(User user, Poll poll) {
        this.user = user;
        this.poll = poll;
    }
}
