package br.com.frwk.redesocial.repository;

import br.com.frwk.redesocial.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

    Usuario findByLogin(String login);
}
