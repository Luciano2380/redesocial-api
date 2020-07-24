package br.com.frwk.redesocial.service;
import org.springframework.security.core.Authentication;
public interface ISegurancaService {
    String criarToken(Authentication authentication);
     boolean isTokenValido(String token);
     Long getIdUsuario(String token);
}
