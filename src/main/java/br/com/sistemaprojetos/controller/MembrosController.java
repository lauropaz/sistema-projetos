package br.com.sistemaprojetos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sistemaprojetos.model.Membros;
import br.com.sistemaprojetos.service.MembrosService;

@RestController
@RequestMapping(value = "/membros" )
public class MembrosController {
	
	@Autowired
	private MembrosService membrosService;
	
	@GetMapping("/")
	public ResponseEntity<?> buscarMembros() {
		return new ResponseEntity<>(membrosService.buscarMembros(), HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<?> inserirMembro(@RequestBody Membros membro) {
		return new ResponseEntity<>(membrosService.incluirMembro(membro), HttpStatus.OK);
	}
	@PutMapping
	public ResponseEntity<?> alterarMembro(@RequestBody Membros membro) {
		return new ResponseEntity<>(membrosService.alterarMembro(membro), HttpStatus.OK);
	}
	@DeleteMapping
	public ResponseEntity<?> deletarMembro(@RequestBody Membros membro) {
		membrosService.excluirMembro(membro);
		return new ResponseEntity<>("Membro deletado com sucesso!", HttpStatus.OK);
	}
}
