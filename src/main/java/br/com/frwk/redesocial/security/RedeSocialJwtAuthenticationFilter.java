package br.com.frwk.redesocial.security;

import br.com.frwk.redesocial.domain.Usuario;
import br.com.frwk.redesocial.repository.UsuarioRepository;
import br.com.frwk.redesocial.service.ISegurancaService;
import br.com.frwk.redesocial.service.SegurancaService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Component
public class RedeSocialJwtAuthenticationFilter extends OncePerRequestFilter {
    private ISegurancaService segurancaService;
    private UsuarioRepository repository;

    public RedeSocialJwtAuthenticationFilter(ISegurancaService segurancaService, UsuarioRepository repository) {
        this.segurancaService = segurancaService;
        this.repository = repository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String token = recuperarToken(request);
        boolean valido = segurancaService.isTokenValido(token);
        if (valido) {
            autenticarCliente(token);
        }

        filterChain.doFilter(request, response);
    }

    private void autenticarCliente(String token) {
        Long idUsuario = segurancaService.getIdUsuario(token);
        Usuario usuario = repository.findById(idUsuario).get();
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    private String recuperarToken(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (token == null || token.isEmpty() || !token.startsWith("Bearer ")) {
            return null;
        }
        return token.replace("Bearer ","");
    }
}
