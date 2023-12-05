package br.com.sistemaprojetos.enums;

import org.hibernate.validator.constraints.Length;

public enum Status {
	EM_ANALISE("em analise"), ANALISE_REALIZADA("em analise"),ANALIZE_APROVADA("em analise"), INICIADO("em analise"), PLANEJADO("em analise"), EM_ANDAMENTO("em analise"), ENCERRERADO("em analise"), CANCELADO("em analise");
	@Length(max = 45)
	private String status;
	
	private Status(String status) {
		this.status = status;
	}
	  	
}
