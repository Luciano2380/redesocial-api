package br.com.frwk.redesocial.service;

import java.util.List;

public interface IService<DTO>{
    DTO salvar(DTO to);
    void excluir(Long id);
    List<DTO> consultar();

}
