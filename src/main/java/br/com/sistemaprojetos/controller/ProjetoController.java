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

import br.com.sistemaprojetos.model.Projeto;
import br.com.sistemaprojetos.service.ProjetoService;

@RestController
@RequestMapping(value = "/projeto" )
public class ProjetoController {
	
	@Autowired
	private ProjetoService projetoService;
	
	@GetMapping("/")
	public ResponseEntity<?> buscarProjetos() {
		return new ResponseEntity<>(projetoService.buscarProjetos(), HttpStatus.OK);
	}
	@GetMapping("/{nome}")
	public ResponseEntity<?> buscarProjetoPorNome(@PathVariable String nome) {
		return new ResponseEntity<>(projetoService.buscarProjetosPorNome(nome), HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<?> inserirProjeto(@RequestBody Projeto projeto) {
		return new ResponseEntity<>(projetoService.incluirProjeto(projeto).getReasonPhrase(), HttpStatus.valueOf(projetoService.incluirProjeto(projeto).value()) );
	}
	@PutMapping
	public ResponseEntity<?> alterarProjeto(@RequestBody Projeto projeto) {
		return new ResponseEntity<>(projetoService.alterarProjeto(projeto).getReasonPhrase(), HttpStatus.valueOf(projetoService.incluirProjeto(projeto).value()) );
	}
	@DeleteMapping
	public ResponseEntity<?> deletarProjeto(@RequestBody Projeto projeto) {
		return new ResponseEntity<>(projetoService.excluirProjeto(projeto).getReasonPhrase(), HttpStatus.valueOf(projetoService.excluirProjeto(projeto).value()));
	}
}
