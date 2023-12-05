package br.com.sistemaprojetos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.com.sistemaprojetos.enums.Status;
import br.com.sistemaprojetos.model.Pessoa;
import br.com.sistemaprojetos.model.Projeto;
import br.com.sistemaprojetos.repository.PessoaRepository;
import br.com.sistemaprojetos.repository.ProjetoRepository;
import jakarta.transaction.Transactional;

@Service
public class ProjetoService {
	
	@Autowired
	ProjetoRepository repository;
	@Autowired
	PessoaRepository pessoaRepository;
	
	@Transactional
	public HttpStatus incluirProjeto(Projeto projeto) {
		Pessoa pessoa = pessoaRepository.findPersonById(projeto.getPessoa().getId());
		projeto.setPessoa(pessoa);
		if(projeto.getPessoa().isFuncionario()) {
			repository.save(projeto);
			return HttpStatus.OK;
		}else {
			return HttpStatus.NOT_ACCEPTABLE;
		}
	}
	@Transactional
	public HttpStatus alterarProjeto(Projeto projeto) {
		Pessoa pessoa = pessoaRepository.findPersonById(projeto.getPessoa().getId());
		projeto.setPessoa(pessoa);
		if(projeto.getPessoa().isFuncionario()) {
			repository.save(projeto);
			return HttpStatus.OK;
		}else {
			return HttpStatus.NOT_ACCEPTABLE;
		}
	}
	@Transactional
	public HttpStatus excluirProjeto(Projeto projeto) {
		if(projeto.getStatus() == Status.INICIADO || projeto.getStatus() == Status.EM_ANDAMENTO || projeto.getStatus() == Status.ENCERRERADO ) {
			return HttpStatus.NOT_ACCEPTABLE;
		}else {
			repository.delete(projeto);
			return HttpStatus.OK;
		}
	}
	public List<Projeto> buscarProjetos(){
		return repository.findAll();
	}
	public Projeto buscarProjetosPorId(Long id){
		return repository.findProjectById(id);
	}
	public Projeto buscarProjetosPorNome(String nome){
		return repository.findByNome(nome);
	}
}
