package br.com.db1.db1start.bancoapi.adapter;

import br.com.db1.db1start.bancoapi.dto.ClienteInputDTO;
import br.com.db1.db1start.bancoapi.dto.ClienteViewDTO;
import br.com.db1.db1start.bancoapi.entity.Cliente;

public class ClienteAdapter {

	public static ClienteViewDTO transformaClienteEmViewDTO(Cliente cliente) {
		ClienteViewDTO clienteDTO =  new ClienteViewDTO();
		
		clienteDTO.setId(cliente.getId());
		clienteDTO.setNome(cliente.getNome());
		
		return clienteDTO;
	}
	
	public static Cliente transformaInputDTOemCliente(ClienteInputDTO clienteDTO) {
		Cliente cliente = new Cliente();
		
		cliente.setNome(clienteDTO.getNome());
		cliente.setCpf(clienteDTO.getCpf());
		cliente.setTelefone(clienteDTO.getTelefone());
		
		return cliente;
		
	}
}
