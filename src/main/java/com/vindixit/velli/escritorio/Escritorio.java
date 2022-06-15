package com.vindixit.velli.escritorio;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.vindixit.velli.jurisdicao.Jurisdicao;
import com.vindixit.velli.membro.Membro;
import com.vindixit.velli.usuario.Usuario;

import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity
public class Escritorio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String abreviatura;
    private String descricao;

    @OneToMany(mappedBy = "escritorio", cascade = CascadeType.ALL)
    private List<Membro> membros;

    @OneToMany(mappedBy = "escritorio", cascade = CascadeType.ALL)
    private List<Jurisdicao> jurisdicoes;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_chefe", referencedColumnName = "id")
    private Usuario chefe;

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

    public List<Membro> getMembros() {
        return membros;
    }

    public void setMembros(List<Membro> membros) {
        this.membros = membros;
    }

    public Usuario getChefe() {
        return chefe;
    }

    public void setChefe(Usuario chefe) {
        this.chefe = chefe;
    }

    public List<Jurisdicao> getJurisdicoes() {
        return jurisdicoes;
    }

    public void setJurisdicoes(List<Jurisdicao> jurisdicoes) {
        this.jurisdicoes = jurisdicoes;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
