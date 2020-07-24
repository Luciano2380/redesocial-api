package br.com.frwk.redesocial.service;

import br.com.frwk.redesocial.domain.Comentario;
import br.com.frwk.redesocial.domain.Foto;
import br.com.frwk.redesocial.dto.ComentarioDTO;
import br.com.frwk.redesocial.dto.FotoDTO;
import br.com.frwk.redesocial.repository.FotoRepository;
import liquibase.util.file.FilenameUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class FotoService implements IFotoService {

    @Autowired
    FotoRepository repository;

    @Autowired
    ModelMapper mapper;

    @Autowired
    IUsuarioService usuarioService;

    @Override
    public FotoDTO salvar(FotoDTO to) {
        Foto foto = mapper.map(to, Foto.class);
        foto.setUsuario(usuarioService.getUsuarioLogado());
        foto.setDatacriacao(LocalDateTime.now());
        return mapper.map(repository.save(foto), FotoDTO.class);
    }

    @Override
    public void excluir(Long id) {
      repository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<FotoDTO> consultar() {
        List<Foto> fotos = repository.findAll();
        return fotos.stream().map(f->mapper.map(f,FotoDTO.class)).collect(Collectors.toList());
    }


    public String upload(byte[] arquivo, String nome) throws IOException {
        UUID uuid  = UUID.randomUUID();
        String extensao = FilenameUtils.getExtension(nome);
        File sourceFile = File.createTempFile(uuid.toString(),"." + extensao);
        FileOutputStream outputStream = new FileOutputStream(sourceFile);
        outputStream.write(arquivo);
        outputStream.close();
        return sourceFile.getAbsolutePath();
    }
}
