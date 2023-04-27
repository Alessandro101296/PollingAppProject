package io.io.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.annotations.NaturalId;

import java.util.List;

@Entity
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    @NotBlank
    private String username;

    @Column(unique = true)
    @NotBlank
    private String email;

    private String name;

    @OneToMany(mappedBy = "user")
    private List<Poll> pollList;


    public User() {
    }

    public User(long id, String username, String email, String name, List<Poll> pollList) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.name = name;
        this.pollList = pollList;
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

    public List<Poll> getPollList() {
        return pollList;
    }

    public void setPollList(List<Poll> pollList) {
        this.pollList = pollList;
    }


    @Override
    public boolean equals(Object user){
        if (user == this) {
            return true;
        }
        if(!(user instanceof User)){
            return false;
        }
        User u=(User)user;
        return (id==u.getId())&&(username.equals(u.getUsername()))&&(email.equals(u.getEmail()))&&(name.equals(u.getName()));

    }
}
