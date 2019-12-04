package br.com.db1.db1start.bancoapi.dto;


public class AgenciaViewDTO {

	private Long id;
	private String numero;
	private String numBanco;
	private CidadeViewDTO cidade;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getNumBanco() {
		return numBanco;
	}
	public void setNumBanco(String numBanco) {
		this.numBanco = numBanco;
	}
	public CidadeViewDTO getCidade() {
		return cidade;
	}
	public void setCidade(CidadeViewDTO cidade) {
		this.cidade = cidade;
	}
	
	
}
