package br.com.frwk.redesocial.service;

import br.com.frwk.redesocial.domain.Comentario;
import br.com.frwk.redesocial.domain.Usuario;
import br.com.frwk.redesocial.dto.ComentarioDTO;
import br.com.frwk.redesocial.dto.UsuarioDTO;
import br.com.frwk.redesocial.repository.UsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UsuarioService implements IUsuarioService{

    @Autowired
    UsuarioRepository repository;

    @Autowired
    ModelMapper mapper;

    @Override
    public UsuarioDTO cadastrar(UsuarioDTO to) {
        Usuario usuario = mapper.map(to, Usuario.class);
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        usuario.setSenha(encoder.encode(usuario.getSenha()));
        usuario.setDatacriacao(LocalDateTime.now());
        return mapper.map(repository.save(usuario), UsuarioDTO.class);
    }

    public Usuario getUsuarioLogado(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return repository.findByLogin(((UserDetails)principal).getUsername());
    }
}
