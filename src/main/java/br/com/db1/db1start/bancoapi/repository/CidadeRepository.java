package br.com.db1.db1start.bancoapi.repository;

import java.util.List;
import java.util.Optional;

import br.com.db1.db1start.bancoapi.entity.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.db1.db1start.bancoapi.entity.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {
	
	List<Cidade> findByEstado(Estado estado);

	Optional<Cidade> findByNome(String nome);
}
