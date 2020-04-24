package br.com.db1.db1start.bancoapi.dto;


public class CidadeViewDTO {

	private Long id;
	private String nome;
	private EstadoViewDTO estado;
	
	//getters
	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public EstadoViewDTO getEstado() {
		return estado;
	}

	//setters
	public void setId(Long id) {
		this.id = id;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setEstado(EstadoViewDTO estado) {
		this.estado = estado;
	}
}
