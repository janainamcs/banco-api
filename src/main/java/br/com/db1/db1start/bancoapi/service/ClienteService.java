package br.com.db1.db1start.bancoapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.db1.db1start.bancoapi.entity.Cliente;
import br.com.db1.db1start.bancoapi.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;

	//Create
	public Cliente criar(String nome, String cpf, String telefone) {
        Cliente cliente = new Cliente();
        cliente.setNome(nome);
        cliente.setCpf(cpf);
        cliente.setTelefone(telefone);
        return clienteRepository.save(cliente);
    }

    //Read
	public Cliente buscarPorId(Long id) {
        return clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }
	
	public List<Cliente> buscarTodos() {
	    return clienteRepository.findAll();
    }

    public Optional<Cliente> buscarPorNome(String nome){
	    return clienteRepository.findByNome(nome);
    }

    //Update
	public Cliente atualizarTelefone(Long id, String telefone){
	    Cliente cliente = buscarPorId(id);
	    cliente.setTelefone(telefone);
	    return clienteRepository.save(cliente);
    }

    //Delete
	public void deletarTodos() {
	    clienteRepository.deleteAll();
    }

    public void deletarPorId(Long id){
	    clienteRepository.deleteById(id);
    }

    public void deletarPorNome(String nome){
	    Cliente cliente = clienteRepository.findByNome(nome).get();
	    clienteRepository.delete(cliente);
    }

}
