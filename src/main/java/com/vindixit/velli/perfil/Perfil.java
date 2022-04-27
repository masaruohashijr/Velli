package com.vindixit.velli.perfil;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.vindixit.velli.usuario.Usuario;

@Entity
public class Perfil {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)    
    private Long id;    
    private String name;
    @OneToMany(mappedBy="perfil", fetch=FetchType.LAZY, cascade = {CascadeType.MERGE})
    private List<Usuario> users;   

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<Usuario> getUsers() {
        return users;
    }
    public void setUsers(List<Usuario> users) {
        this.users = users;
    }
    
}
