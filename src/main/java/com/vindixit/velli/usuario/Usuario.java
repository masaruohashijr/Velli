package com.vindixit.velli.usuario;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.vindixit.velli.escritorio.Escritorio;
import com.vindixit.velli.membro.Membro;
import com.vindixit.velli.perfil.Perfil;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)    
    private Long id;    
    private String name;    
    private String email;
    
    @OneToMany(mappedBy="escritorio", fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Membro> membros;
    
    @OneToOne(mappedBy = "chefe", fetch=FetchType.LAZY, cascade = CascadeType.PERSIST)   
    private Escritorio headedOffice;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "id_perfil")    
    private Perfil perfil;

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
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Escritorio getHeadedOffice() {
        return headedOffice;
    }
    public void setHeadedOffice(Escritorio headedOffice) {
        this.headedOffice = headedOffice;
    }
    public List<Membro> getMembros() {
        return membros;
    }
    public void setMembros(List<Membro> membros) {
        this.membros = membros;
    }
    public Perfil getPerfil() {
        return perfil;
    }
    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }
    
}
