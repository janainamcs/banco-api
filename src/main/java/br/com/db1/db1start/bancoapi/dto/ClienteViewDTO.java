package br.com.db1.db1start.bancoapi.dto;

public class ClienteViewDTO {
	
	private Long id;
	private String nome;
	
	//getters
	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	//setters
	public void setId(Long id) {
		this.id = id;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
