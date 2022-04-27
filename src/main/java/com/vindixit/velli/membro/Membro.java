package com.vindixit.velli.membro;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.vindixit.velli.escritorio.Escritorio;
import com.vindixit.velli.usuario.Usuario;

@Entity
public class Membro {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)    
    private Long id;    

    @ManyToOne
    @JoinColumn(name = "id_escritorio")
    private Escritorio escritorio;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
    
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
    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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
    
}
