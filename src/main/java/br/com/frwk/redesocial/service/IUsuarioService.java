package br.com.frwk.redesocial.service;

import br.com.frwk.redesocial.domain.Usuario;
import br.com.frwk.redesocial.dto.UsuarioDTO;

public interface IUsuarioService {
    UsuarioDTO cadastrar (UsuarioDTO to);
    public Usuario getUsuarioLogado();
}
