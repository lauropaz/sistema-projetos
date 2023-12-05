package br.com.sistemaprojetos.model;

import java.io.Serializable;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "membros")
@Data
public class Membros implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private MembrosId membrosId;
	@ManyToOne
    @MapsId("idProjeto")
    @JoinColumn(name = "idProjeto")
	private Projeto projeto;
	
	
	@ManyToOne
    @MapsId("idPessoa")
    @JoinColumn(name = "idPessoa")
	private Pessoa pessoa;
	
}
