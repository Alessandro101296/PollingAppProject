package io.io.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Polls")
public class Poll {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    private String question;
    @OneToMany(mappedBy = "poll")
    @Fetch(FetchMode.SELECT)
    @Size(min = 2, max = 6)

    private List<Choice> choiceList = new ArrayList();

    private Date expirationDateTime;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)

    private User user;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<Choice> getChoiceList() {
        return choiceList;
    }

    public Date getExpirationDateTime() {
        return expirationDateTime;
    }

    public void setExpirationDateTime(Date expirationDateTime) {
        this.expirationDateTime = expirationDateTime;
    }
    public void addChoice(Choice choice){
        choice.setPoll(this);
        this.choiceList.add(choice);
    }
    public void setChoiceList(List<Choice> choiceList){
        this.choiceList=choiceList;
    }
}
