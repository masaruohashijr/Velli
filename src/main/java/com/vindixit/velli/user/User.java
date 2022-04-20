package com.vindixit.velli.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.vindixit.velli.office.Office;
import com.vindixit.velli.role.Role;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)    
    private int id;    
    private String name;    
    private String email;
    @ManyToOne
    @JoinColumn(name = "id_office")
    private Office office;
    
    @OneToOne(mappedBy = "chief")    
    private Office headedOffice;

    @ManyToOne
    @JoinColumn(name = "id_role")    
    private Role role;

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
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Office getOffice() {
        return office;
    }
    public void setOffice(Office office) {
        this.office = office;
    }
    public Office getHeadedOffice() {
        return headedOffice;
    }
    public void setHeadedOffice(Office headedOffice) {
        this.headedOffice = headedOffice;
    }
    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
        this.role = role;
    }    
    
}
