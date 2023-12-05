package br.com.sistemaprojetos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sistemaprojetos.model.Projeto;

@Repository
public interface ProjetoRepository extends JpaRepository<Projeto, Long> {
 Projeto findByNome(String nomeProjeto);
 Projeto findProjectById(Long id);
}
