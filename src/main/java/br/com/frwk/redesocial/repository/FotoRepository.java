package br.com.frwk.redesocial.repository;

import br.com.frwk.redesocial.domain.Foto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FotoRepository extends JpaRepository<Foto,Long> {
}
