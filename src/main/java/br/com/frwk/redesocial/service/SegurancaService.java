package br.com.frwk.redesocial.service;

import br.com.frwk.redesocial.domain.Usuario;
import br.com.frwk.redesocial.repository.UsuarioRepository;
import br.com.frwk.redesocial.util.RedeSocialConstantes;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SegurancaService implements ISegurancaService, UserDetailsService {


    @Autowired
    UsuarioRepository repository;
    @Override
    public String criarToken(Authentication authentication) {
        Usuario logado = (Usuario) authentication.getPrincipal();
        return Jwts.builder()
                .setSubject(logado.getId().toString())
                .signWith(SignatureAlgorithm.HS256, RedeSocialConstantes.SECRET)
                .compact();
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Usuario usuario = repository.findByLogin(login);
        if (usuario!=null) {
            return usuario;
        }
        throw new UsernameNotFoundException("Dados inválidos!");
    }
    public boolean isTokenValido(String token) {
        try {
            Jwts.parser().setSigningKey(RedeSocialConstantes.SECRET).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public Long getIdUsuario(String token) {
        Claims claims = Jwts.parser().setSigningKey(RedeSocialConstantes.SECRET).parseClaimsJws(token).getBody();
        return Long.parseLong(claims.getSubject());
    }
}
