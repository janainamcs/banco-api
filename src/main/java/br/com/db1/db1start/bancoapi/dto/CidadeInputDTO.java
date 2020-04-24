package br.com.db1.db1start.bancoapi.dto;

import br.com.db1.db1start.bancoapi.dto.EstadoInputDTO;

public class CidadeInputDTO {

	private String nome;
	private EstadoInputDTO estado;

	//getters
	public String getNome() {
		return nome;
	}

	public EstadoInputDTO getEstado() {
		return estado;
	}

	//setters
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEstado(EstadoInputDTO estado) {
		this.estado = estado;
	}
}
