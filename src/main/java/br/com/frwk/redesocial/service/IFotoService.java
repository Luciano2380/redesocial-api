package br.com.frwk.redesocial.service;

import br.com.frwk.redesocial.dto.FotoDTO;

import java.io.IOException;

public interface IFotoService extends IService<FotoDTO> {
    public String upload(byte[] arquivo, String nome) throws IOException;
}
