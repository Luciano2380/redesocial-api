package br.com.frwk.redesocial.dto;

import br.com.frwk.redesocial.domain.Postagem;
import br.com.frwk.redesocial.domain.Usuario;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

public class ComentarioDTO {

    private Long id;
    private UsuarioDTO usuario;
    private PostagemDTO postagem;
    private LocalDateTime dataCriacao;
    private String textoComentario;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UsuarioDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
    }

    public PostagemDTO getPostagem() {
        return postagem;
    }

    public void setPostagem(PostagemDTO postagem) {
        this.postagem = postagem;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getTextoComentario() {
        return textoComentario;
    }

    public void setTextoComentario(String textoComentario) {
        this.textoComentario = textoComentario;
    }
}
