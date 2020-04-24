package br.com.db1.db1start.bancoapi.dto;

public class ContaInputDTO {
	
	private Double saldo;
	private AgenciaInputDTO agenciaDTO;
	private ClienteInputDTO clienteDTO;

	//getters
	public Double getSaldo() {
		return saldo;
	}
	public AgenciaInputDTO getAgenciaDTO() {
		return agenciaDTO;
	}
	public ClienteInputDTO getClienteDTO() {
		return clienteDTO;
	}

	//setters
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	public void setAgenciaDTO(AgenciaInputDTO agenciaDTO) {
		this.agenciaDTO = agenciaDTO;
	}
	public void setClienteDTO(ClienteInputDTO clienteDTO) {
		this.clienteDTO = clienteDTO;
	}


	
}
