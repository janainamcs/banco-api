package br.com.db1.db1start.bancoapi.dto;


public class CidadeViewDTO {

	private Long id;
	private String nome;
	private EstadoViewDTO estado;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public EstadoViewDTO getEstado() {
		return estado;
	}
	public void setEstado(EstadoViewDTO estado) {
		this.estado = estado;
	}
}
