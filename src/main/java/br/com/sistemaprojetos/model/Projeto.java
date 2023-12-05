package br.com.sistemaprojetos.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

import org.hibernate.validator.constraints.Length;

import br.com.sistemaprojetos.enums.Risco;
import br.com.sistemaprojetos.enums.Status;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "projeto")
@Getter
@Setter
public class Projeto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull
	private Long id;
	@Column
	@Length(max = 200)
	private String nome;
	@Column
	private LocalDateTime dataInicio;
	@OneToMany(mappedBy = "projeto")
	Set<Membros> membros;
	@Column
	private LocalDateTime dataTermino;
	@Column
	private LocalDateTime dataRealTermino;
	@Column
	private BigDecimal orcamentoTotal;
	@Column
	@Length(max = 5000)
	private String descricao;
	@Column
	@Length(max = 45)
	private Status status;
	@Column
	@Length(max = 45)
	private Risco risco;
	@ManyToOne
    @JoinColumn(name = "fk_gerente")
	private Pessoa pessoa;
}
