package br.com.db1.db1start.bancoapi.dto;

import br.com.db1.db1start.bancoapi.entity.Cidade;

public class AgenciaInputDTO {
	
	private String numero;
	private String numBanco;
	private CidadeInputDTO cidadeDTO;

	public String getNumero() {
		return numero;
	}

	public String getNumBanco() {
		return numBanco;
	}

	public CidadeInputDTO getCidadeDTO() {
		return cidadeDTO;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public void setNumBanco(String numBanco) {
		this.numBanco = numBanco;
	}

	public void setCidadeDTO(CidadeInputDTO cidade) {
		this.cidadeDTO = cidade;
	}

}
