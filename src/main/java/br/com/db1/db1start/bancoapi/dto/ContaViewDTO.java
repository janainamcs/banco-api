package br.com.db1.db1start.bancoapi.dto;

public class ContaViewDTO {

	private Long id;
	private ClienteViewDTO cliente;
	private AgenciaViewDTO agencia;
	
    //getters
	public Long getId() {
		return id;
	}
	public ClienteViewDTO getCliente() {
		return cliente;
	}
	public AgenciaViewDTO getAgencia() {
		return agencia;
	}

	//setters
	public void setId(Long id) {
		this.id = id;
	}
	public void setCliente(ClienteViewDTO cliente) {
		this.cliente = cliente;
	}
	public void setAgencia(AgenciaViewDTO agencia) {
		this.agencia = agencia;
	}

}
