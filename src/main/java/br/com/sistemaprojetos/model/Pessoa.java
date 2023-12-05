package br.com.sistemaprojetos.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "pessoa")
public class Pessoa implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column
	@Length(max = 100)
	@NotNull
	private String nome;
	@Column
	private LocalDateTime dataNascimento;
	@Column
	@Length(max = 14)
	private String cpf;
	@Column
	private boolean isFuncionario;
	@OneToMany(mappedBy = "pessoa")
	Set<Membros> membros;
}
