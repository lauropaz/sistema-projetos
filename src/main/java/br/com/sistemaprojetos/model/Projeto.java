package br.com.sistemaprojetos.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;


import br.com.sistemaprojetos.enums.Risco;
import br.com.sistemaprojetos.enums.Status;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Projeto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column
	private String nome;
	@Column
	private LocalDateTime dataInicio;
	@Column
	private String gerenteResponsavel;
	@Column
	private LocalDateTime dataTermino;
	@Column
	private LocalDateTime dataRealTermino;
	@Column
	private BigDecimal orcamentoTotal;
	@Column
	private String descricao;
	@Column
	private Status status;
	@Column
	private Risco risco;
}
