package com.vindixit.velli.plano;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.vindixit.velli.entidade.Entidade;

@Entity
public class Plano {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)    
    private Long id;    
    private String cnpb;
    private String recurso;
    private String name;
    @ManyToOne
    private Entidade entidade;   

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
    public String getCnpb() {
        return cnpb;
    }
    public void setCnpb(String cnpb) {
        this.cnpb = cnpb;
    }
    public String getRecurso() {
        return recurso;
    }
    public void setRecurso(String recurso) {
        this.recurso = recurso;
    }
    public Entidade getEntidade() {
        return entidade;
    }
    public void setEntidade(Entidade entidade) {
        this.entidade = entidade;
    }
}
