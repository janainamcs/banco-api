package br.com.db1.db1start.bancoapi.adapter;

import br.com.db1.db1start.bancoapi.dto.ClienteViewDTO;
import br.com.db1.db1start.bancoapi.entity.Cliente;

public class ClienteAdapter {

	public static ClienteViewDTO transformaClienteEmViewDTO(Cliente cliente) {
		ClienteViewDTO dto =  new ClienteViewDTO();
		
		dto.setId(cliente.getId());
		dto.setNome(cliente.getNome());
		
		return dto;
	}
}
