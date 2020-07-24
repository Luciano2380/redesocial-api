package br.com.frwk.redesocial.repository;

import br.com.frwk.redesocial.domain.Postagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostagemRepository extends JpaRepository<Postagem,Long> {
}
