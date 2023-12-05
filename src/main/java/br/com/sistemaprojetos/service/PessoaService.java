package br.com.sistemaprojetos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sistemaprojetos.model.Pessoa;
import br.com.sistemaprojetos.repository.PessoaRepository;
import jakarta.transaction.Transactional;

@Service
public class PessoaService {
	
	@Autowired
	PessoaRepository repository;
	
	@Transactional
	public Pessoa incluirPessoa(Pessoa Pessoa) {
		return repository.save(Pessoa);
	}
	@Transactional
	public Pessoa alterarPessoa(Pessoa Pessoa) {
		return repository.save(Pessoa);
	}
	@Transactional
	public void excluirPessoa(Pessoa Pessoa) {
		repository.delete(Pessoa);
	}
	public List<Pessoa> buscarPessoas(){
		return repository.findAll();
	}
	public Pessoa buscarPessoasPorNome(String nome){
		return repository.findByNome(nome);
	}
}
