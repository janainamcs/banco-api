package br.com.db1.db1start.bancoapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.db1.db1start.bancoapi.dto.ContaInputDTO;
import br.com.db1.db1start.bancoapi.entity.Agencia;
import br.com.db1.db1start.bancoapi.entity.Cliente;
import br.com.db1.db1start.bancoapi.entity.Conta;
import br.com.db1.db1start.bancoapi.repository.ContaRepository;

@Service
public class ContaService {

	@Autowired
	private AgenciaService agenciaService;
	@Autowired
	private ClienteService clienteService;
	@Autowired
	private ContaRepository contaRepository;
	
	public Conta criar(Double saldo, Long agenciaId, Long clienteId) {
		Agencia agencia = agenciaService.buscarPorId(agenciaId);
		Cliente cliente = clienteService.buscarPorId(clienteId);
		Conta conta = new Conta();
		conta.setAgencia(agencia);
		conta.setCliente(cliente);
		conta.setSaldo(saldo);
		return contaRepository.save(conta);
	}
	
	public void deletarTodos() {
    	contaRepository.deleteAll();
    }

	public List<Conta> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	public void deletarPorNome(String contaNome) {
		// TODO Auto-generated method stub
		
	}

	public void deletarPorId(Long contaId) {
		// TODO Auto-generated method stub
		
	}

	public void atualizar(Long contaId, ContaInputDTO form) {
		// TODO Auto-generated method stub
		
	}
}
