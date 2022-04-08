package com.vindixit.velli.office;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.vindixit.velli.user.User;

import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity
public class Office {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)    
    private int id;    

    private String name;
    
    @OneToMany(mappedBy="office", fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    private List<User> users;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_chief", referencedColumnName = "id")
    private User chief;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<User> getUsers() {
        return users;
    }
    public void setUsers(List<User> users) {
        this.users = users;
    }
    public User getChief() {
        return chief;
    }
    public void setChief(User chief) {
        this.chief = chief;
    }    
    
}
