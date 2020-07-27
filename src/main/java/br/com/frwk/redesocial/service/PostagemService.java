package br.com.frwk.redesocial.service;

import br.com.frwk.redesocial.domain.Postagem;
import br.com.frwk.redesocial.dto.FotoDTO;
import br.com.frwk.redesocial.dto.PostagemDTO;
import br.com.frwk.redesocial.repository.FotoRepository;
import br.com.frwk.redesocial.repository.PostagemRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostagemService implements IPostagemService{
    @Autowired
    PostagemRepository repository;
    @Autowired
    IUsuarioService usuarioService;
    @Autowired
    IFotoService fotoService;

    @Autowired
    ModelMapper mapper;


    @Override
    public PostagemDTO salvar(PostagemDTO to) {
        FotoDTO fotoDTO = new FotoDTO();
        fotoDTO.setLinkFoto(to.getLinkFoto());
        to.setFoto(fotoService.salvar(fotoDTO));
        Postagem post = mapper.map(to,Postagem.class);
        post.setUsuario(usuarioService.getUsuarioLogado());
        post.setDatacriacao(LocalDateTime.now());
        return mapper.map(repository.save(post),PostagemDTO.class);
    }

    @Override
    public void excluir(Long id) {
          repository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PostagemDTO> consultar() {
        List<Postagem> postagems = repository.findAll();
        return postagems.stream().map(p->mapper.map(p,PostagemDTO.class)).collect(Collectors.toList());
    }
}
