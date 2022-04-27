package com.vindixit.velli.entidade;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.vindixit.velli.jurisdicao.Jurisdicao;
import com.vindixit.velli.plano.Plano;

@Entity
public class Entidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    
    @OneToMany(mappedBy = "escritorio", cascade = CascadeType.ALL)
    private List<Jurisdicao> jurisdicoes;

    @OneToMany(mappedBy = "entidade", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Plano> planos;

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

    public List<Jurisdicao> getJurisdicoes() {
        return jurisdicoes;
    }

    public void setJurisdicoes(List<Jurisdicao> jurisdicoes) {
        this.jurisdicoes = jurisdicoes;
    }

    public List<Plano> getPlanos() {
        return planos;
    }

    public void setPlanos(List<Plano> planos) {
        this.planos = planos;
    }

}
