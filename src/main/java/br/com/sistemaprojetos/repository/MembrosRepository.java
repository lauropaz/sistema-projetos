package br.com.sistemaprojetos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sistemaprojetos.model.Membros;
import br.com.sistemaprojetos.model.MembrosId;

@Repository
public interface MembrosRepository extends JpaRepository<Membros, MembrosId> {
}
