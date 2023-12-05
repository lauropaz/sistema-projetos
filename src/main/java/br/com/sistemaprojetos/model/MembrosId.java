package br.com.sistemaprojetos.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Embeddable
@Data
@EqualsAndHashCode
public class MembrosId implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name = "idProjeto")
	private Long idProjeto;
	@Column(name = "idPessoa")
	private Long idPessoa;
	
}
