package br.com.sistemaprojetos.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sistemaprojetos.model.Membros;
import br.com.sistemaprojetos.model.Pessoa;
import br.com.sistemaprojetos.model.Projeto;
import br.com.sistemaprojetos.repository.MembrosRepository;
import br.com.sistemaprojetos.repository.PessoaRepository;
import br.com.sistemaprojetos.repository.ProjetoRepository;
import jakarta.transaction.Transactional;

@Service
public class MembrosService {
	@Autowired
	MembrosRepository repository;
	@Autowired
	ProjetoRepository projetoRepository;
	@Autowired
	PessoaRepository pessoaRepository;
	
	@Transactional
	public Membros incluirMembro(Membros membros) {
		Projeto projeto = projetoRepository.findProjectByIdProjeto(membros.getMembrosId().getIdProjeto());
		Pessoa pessoa = pessoaRepository.findPersonByIdPessoa(membros.getMembrosId().getIdPessoa());
		Set<Membros> s = new HashSet<Membros>();
		membros.setPessoa(pessoa);
		membros.setProjeto(projeto);
		s.add(membros);
		projeto.setMembros(s);
		try {
			repository.save(membros);
			
		} catch (Exception e) {
			e.getMessage();
		}
		return membros;
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
