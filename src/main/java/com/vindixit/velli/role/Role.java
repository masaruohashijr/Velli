package com.vindixit.velli.role;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.vindixit.velli.user.User;

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)    
    private int id;    
    private String name;
    @OneToMany(mappedBy="role", fetch=FetchType.LAZY, cascade = CascadeType.MERGE)
    private List<User> users;   

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
    
}
