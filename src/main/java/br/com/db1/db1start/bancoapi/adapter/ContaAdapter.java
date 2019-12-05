package br.com.db1.db1start.bancoapi.adapter;

import br.com.db1.db1start.bancoapi.dto.AgenciaViewDTO;
import br.com.db1.db1start.bancoapi.dto.ClienteViewDTO;
import br.com.db1.db1start.bancoapi.dto.ContaInputDTO;
import br.com.db1.db1start.bancoapi.dto.ContaViewDTO;
import br.com.db1.db1start.bancoapi.entity.Agencia;
import br.com.db1.db1start.bancoapi.entity.Cliente;
import br.com.db1.db1start.bancoapi.entity.Conta;

public class ContaAdapter {

	public static ContaViewDTO transformaContaParaViewDTO(Conta conta) {
		ContaViewDTO contaDTO =  new ContaViewDTO();
		ClienteViewDTO clienteDTO = new ClienteViewDTO();
		AgenciaViewDTO agenciaDTO = new AgenciaViewDTO();
		
		clienteDTO = ClienteAdapter.transformaClienteEmViewDTO(conta.getCliente());
		agenciaDTO = AgenciaAdapter.transformaAgenciaParaViewDTO(conta.getAgencia());
		contaDTO.setId(conta.getId());
		contaDTO.setAgencia(agenciaDTO);
		contaDTO.setCliente(clienteDTO);
		return contaDTO;
	}
	
	public static Conta transformaInputDTOParaConta(ContaInputDTO contaDTO) {
		Conta conta = new Conta();
		Agencia agencia = AgenciaAdapter.transformaInputDTOparaAgencia(contaDTO.getAgenciaDTO());
		Cliente cliente = ClienteAdapter.transformaInputDTOemCliente(contaDTO.getClienteDTO());
		
		conta.setAgencia(agencia);
		conta.setCliente(cliente);
		conta.setSaldo(contaDTO.getSaldo());
		return conta;
	}
}
