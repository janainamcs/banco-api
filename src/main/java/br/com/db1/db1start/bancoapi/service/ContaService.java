package br.com.db1.db1start.bancoapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	//Create
	public Conta criar(Double saldo, Long agenciaId, Long clienteId) {
		Agencia agencia = agenciaService.buscarPorId(agenciaId);
		Cliente cliente = clienteService.buscarPorId(clienteId);
		Conta conta = new Conta();
		conta.setAgencia(agencia);
		conta.setCliente(cliente);
		conta.setSaldo(saldo);
		return contaRepository.save(conta);
	}

	//Read
	public List<Conta> buscarTodos() {
		return contaRepository.findAll();
	}

	public Optional<Conta> buscarPorId(Long id){
		return contaRepository.findById(id);
	}

	public Optional<Conta> buscarPorNomeDoCliente(String nome){
		Cliente cliente = clienteService.buscarPorNome(nome).get();
		return contaRepository.findById(cliente.getId());
	}

	//Update
	public Conta atualizarSaldo(Long id, Double saldo){
		Conta conta = buscarPorId(id);
		conta.setSaldo(saldo);
		return contaRepository.save(conta);
	}

	//Delete
	public void deletarTodos() {
		contaRepository.deleteAll();
    }



	public void deletarPorNomeDoCliente(String clienteNome) {
		Conta conta = buscarPorNomeDoCliente(clienteNome);
		contaRepository.delete(conta);
	}

	public void deletarPorId(Long contaId) {
		contaRepository.deleteById(contaId);
	}

}
