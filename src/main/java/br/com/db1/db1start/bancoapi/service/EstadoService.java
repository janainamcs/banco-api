package br.com.db1.db1start.bancoapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.db1.db1start.bancoapi.dto.EstadoInputDTO;
import br.com.db1.db1start.bancoapi.entity.Estado;
import br.com.db1.db1start.bancoapi.repository.EstadoRepository;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository estadoRepository;

    //Create
    public Estado criar(String nome) {
        Estado estado = new Estado();
        estado.setNome(nome);
        return estadoRepository.save(estado);
    }

    //Read
    public List<Estado> buscarTodos() {
        return estadoRepository.findAll();
    }

    public Estado buscarPorId(Long id) {
        return estadoRepository.findById(id).orElseThrow(() -> new RuntimeException("Estado não encontrado"));
    }

    public Optional<Estado> buscarPorNome(String nome){
        return estadoRepository.findByNome(nome);
    }

    //Update
    public Estado atualizar(Long estadoId, String nome) {
    	Estado estado = buscarPorId(estadoId);
    	estado.setNome(nome);
    	return estadoRepository.save(estado);
    	
    }

    //Delete
    public void deletarPorId(Long id) {
        estadoRepository.deleteById(id);
    }
    
    public void deletarPorNome(String nome) {
    	Estado estado = estadoRepository.findByNome(nome).get();
    	estadoRepository.delete(estado);
    }
    
    public void deletarTodos() {
    	estadoRepository.deleteAll();
    }
}
