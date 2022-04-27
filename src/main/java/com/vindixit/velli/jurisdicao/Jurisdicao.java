package com.vindixit.velli.jurisdicao;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.vindixit.velli.entidade.Entidade;
import com.vindixit.velli.escritorio.Escritorio;

@Entity
public class Jurisdicao {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)    
    private Long id;    

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_escritorio")
    private Escritorio escritorio;

    @ManyToOne(cascade = {CascadeType.ALL, CascadeType.ALL} , fetch = FetchType.EAGER)
    @JoinColumn(name = "id_entidade")
    private Entidade entidade;
    
    LocalDateTime iniciaEm;
    LocalDateTime terminaEm;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Escritorio getEscritorio() {
        return escritorio;
    }
    public void setEscritorio(Escritorio escritorio) {
        this.escritorio = escritorio;
    }
    public LocalDateTime getIniciaEm() {
        return iniciaEm;
    }
    public void setIniciaEm(LocalDateTime iniciaEm) {
        this.iniciaEm = iniciaEm;
    }
    public LocalDateTime getTerminaEm() {
        return terminaEm;
    }
    public void setTerminaEm(LocalDateTime terminaEm) {
        this.terminaEm = terminaEm;
    }
    public Entidade getEntidade() {
        return entidade;
    }
    public void setEntidade(Entidade entidade) {
        this.entidade = entidade;
    }
    
}
