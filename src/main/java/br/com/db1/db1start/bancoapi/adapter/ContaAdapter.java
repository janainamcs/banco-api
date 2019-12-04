package br.com.db1.db1start.bancoapi.adapter;

import br.com.db1.db1start.bancoapi.dto.AgenciaViewDTO;
import br.com.db1.db1start.bancoapi.dto.ClienteViewDTO;
import br.com.db1.db1start.bancoapi.dto.ContaViewDTO;
import br.com.db1.db1start.bancoapi.entity.Conta;

public class ContaAdapter {

	public static ContaViewDTO transformaEntidadeParaDTO(Conta conta) {
		ContaViewDTO dto =  new ContaViewDTO();
		ClienteViewDTO clienteDTO = new ClienteViewDTO();
		AgenciaViewDTO agenciaDTO = new AgenciaViewDTO();
		
		clienteDTO = ClienteAdapter.transformaClienteEmViewDTO(conta.getCliente());
		agenciaDTO = AgenciaAdapter.transformaAgenciaParaViewDTO(conta.getAgencia());
		dto.setId(conta.getId());
		dto.setAgencia(agenciaDTO);
		dto.setCliente(clienteDTO);
		return dto;
	}
}
