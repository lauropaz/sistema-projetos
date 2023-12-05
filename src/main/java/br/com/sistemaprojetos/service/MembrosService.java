package br.com.sistemaprojetos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sistemaprojetos.model.Membros;
import br.com.sistemaprojetos.repository.MembrosRepository;
import jakarta.transaction.Transactional;

@Service
public class MembrosService {
	@Autowired
	MembrosRepository repository;
	
	@Transactional
	public Membros incluirMembro(Membros membros) {
		
		return repository.save(membros);
	}
	@Transactional
	public Membros alterarMembro(Membros membros) {
		return repository.save(membros);
	}
	@Transactional
	public void excluirMembro(Membros membros) {
		repository.delete(membros);
	}
	public List<Membros> buscarMembros(){
		return repository.findAll();
	}
}
