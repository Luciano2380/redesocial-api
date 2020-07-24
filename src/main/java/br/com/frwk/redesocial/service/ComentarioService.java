package br.com.frwk.redesocial.service;

import br.com.frwk.redesocial.domain.Comentario;
import br.com.frwk.redesocial.dto.ComentarioDTO;
import br.com.frwk.redesocial.repository.ComentarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ComentarioService implements IComentarioService {

    @Autowired
    ComentarioRepository repository;
    @Autowired
    IUsuarioService usuarioService;
    @Autowired
    ModelMapper mapper;

    @Override
    public ComentarioDTO salvar(ComentarioDTO to) {
        Comentario comentario = mapper.map(to, Comentario.class);
        comentario.setUsuario(usuarioService.getUsuarioLogado());
        comentario.setDataCriacao(LocalDateTime.now());
        return mapper.map(repository.save(comentario),ComentarioDTO.class);
    }

    @Override
    public void excluir(Long id) {
      repository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ComentarioDTO> consultar() {
        List<Comentario> comentarios = repository.findAll();
        return comentarios.stream().map(c->mapper.map(c,ComentarioDTO.class)).collect(Collectors.toList());
    }
}
