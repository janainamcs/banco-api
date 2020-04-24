package br.com.db1.db1start.bancoapi.dto;


public class AgenciaViewDTO {

	private Long id;
	private String numero;
	private String numBanco;
	private CidadeViewDTO cidade;
	
	//getters
	public Long getId() {
		return id;
	}

	public String getNumero() {
		return numero;
	}

	public String getNumBanco() {
		return numBanco;
	}

	public CidadeViewDTO getCidade() {
		return cidade;
	}

	//setters
	public void setId(Long id) {
		this.id = id;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public void setNumBanco(String numBanco) {
		this.numBanco = numBanco;
	}
	public void setCidade(CidadeViewDTO cidade) {
		this.cidade = cidade;
	}
	
	
}
