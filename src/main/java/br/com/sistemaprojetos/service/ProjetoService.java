package br.com.sistemaprojetos.service;

import java.net.http.HttpResponse;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.com.sistemaprojetos.enums.Status;
import br.com.sistemaprojetos.model.Projeto;
import br.com.sistemaprojetos.repository.ProjetoRepository;
import jakarta.transaction.Transactional;

@Service
public class ProjetoService {
	
	@Autowired
	ProjetoRepository repository;
	
	@Transactional
	public Projeto incluirProjeto(Projeto projeto) {
		return repository.save(projeto);
	}
	@Transactional
	public Projeto alterarProjeto(Projeto projeto) {
		return repository.save(projeto);
	}
	@Transactional
	public HttpStatus excluirProjeto(Projeto projeto) {
		if(projeto.getStatus() == Status.INICIADO || projeto.getStatus() == Status.EM_ANDAMENTO || projeto.getStatus() == Status.ENCERRERADO ) {
			return HttpStatus.BAD_REQUEST;
		}else {
			repository.delete(projeto);
			return HttpStatus.OK;
		}
	}
	public List<Projeto> buscarProjetos(){
		return repository.findAll();
	}
	public Projeto buscarProjetosPorNome(String nome){
		return repository.findByNome(nome);
	}
}
