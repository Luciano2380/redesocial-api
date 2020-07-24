package br.com.frwk.redesocial.dto;

import br.com.frwk.redesocial.domain.Postagem;
import br.com.frwk.redesocial.domain.Usuario;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class FotoDTO {
    private Long id;
    private UsuarioDTO usuario;
    private String linkFoto;

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

    public String getLinkFoto() {
        return linkFoto;
    }

    public void setLinkFoto(String linkFoto) {
        this.linkFoto = linkFoto;
    }
}
