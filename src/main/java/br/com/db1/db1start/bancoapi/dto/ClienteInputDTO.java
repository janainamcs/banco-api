package br.com.db1.db1start.bancoapi.dto;

public class ClienteInputDTO {
	
	private String nome;
	private String cpf;
	private String telefone;

	//getters
	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	//Setters
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


}
