package br.com.frwk.redesocial.dto;

import br.com.frwk.redesocial.domain.Comentario;
import br.com.frwk.redesocial.domain.Foto;
import br.com.frwk.redesocial.domain.Usuario;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PostagemDTO {
    private Long id;
    private Usuario usuario;
    private String textoPostagem;
    private LocalDateTime datacriacao;
    @JsonIgnore
    private List<ComentarioDTO> comentarios = new ArrayList<ComentarioDTO>();
    private String linkFoto ;
    private FotoDTO foto;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getTextoPostagem() {
        return textoPostagem;
    }

    public void setTextoPostagem(String textoPostagem) {
        this.textoPostagem = textoPostagem;
    }

    public LocalDateTime getDatacriacao() {
        return datacriacao;
    }

    public void setDatacriacao(LocalDateTime datacriacao) {
        this.datacriacao = datacriacao;
    }

    public List<ComentarioDTO> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<ComentarioDTO> comentarios) {
        this.comentarios = comentarios;
    }

    public String getLinkFoto() {
        return linkFoto;
    }

    public void setLinkFoto(String linkFoto) {
        this.linkFoto = linkFoto;
    }

    public FotoDTO getFoto() {
        return foto;
    }

    public void setFoto(FotoDTO foto) {
        this.foto = foto;
    }
}
