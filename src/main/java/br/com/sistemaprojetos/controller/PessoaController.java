package br.com.sistemaprojetos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sistemaprojetos.model.Pessoa;
import br.com.sistemaprojetos.service.PessoaService;

@RestController
@RequestMapping(value = "/pessoa" )
public class PessoaController {
	
	@Autowired
	private PessoaService pessoaService;
	
	@GetMapping("/")
	public ResponseEntity<?> buscarPessoas() {
		return new ResponseEntity<>(pessoaService.buscarPessoas(), HttpStatus.OK);
	}
	@GetMapping("/{nome}")
	public ResponseEntity<?> buscarPessoaPorNome(@PathVariable String nome) {
		return new ResponseEntity<>(pessoaService.buscarPessoasPorNome(nome), HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<?> inserirPessoa(@RequestBody Pessoa pessoa) {
		return new ResponseEntity<>(pessoaService.incluirPessoa(pessoa), HttpStatus.OK);
	}
	@PutMapping
	public ResponseEntity<?> alterarPessoa(@RequestBody Pessoa pessoa) {
		return new ResponseEntity<>(pessoaService.alterarPessoa(pessoa), HttpStatus.OK);
	}
	@DeleteMapping
	public ResponseEntity<?> deletarPessoa(@RequestBody Pessoa pessoa) {
		pessoaService.excluirPessoa(pessoa);
		return new ResponseEntity<>("Pessoa deletado com sucesso!", HttpStatus.OK);
	}
}
