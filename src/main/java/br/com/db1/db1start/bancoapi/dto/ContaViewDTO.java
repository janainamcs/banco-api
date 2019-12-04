package br.com.db1.db1start.bancoapi.dto;

public class ContaViewDTO {

	private Long id;
	private ClienteViewDTO cliente;
	private AgenciaViewDTO agencia;
	
    
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public ClienteViewDTO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteViewDTO cliente) {
		this.cliente = cliente;
	}

	public AgenciaViewDTO getAgencia() {
		return agencia;
	}

	public void setAgencia(AgenciaViewDTO agencia) {
		this.agencia = agencia;
	}

}
