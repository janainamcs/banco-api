package br.com.db1.db1start.bancoapi.service;

import br.com.db1.db1start.bancoapi.entity.Estado;
import br.com.db1.db1start.bancoapi.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository estadoRepository;

    public Estado criar(String nome) {
        Estado estado = new Estado();
        estado.setNome(nome);
        return estadoRepository.save(estado);
    }

    public Estado atualizar(Long id, String novoNome) {
        Optional<Estado> estado = estadoRepository.findById(id);
        Estado salvo = estado.map(est -> {
            est.setNome(novoNome);
            return estadoRepository.save(est);
        }).orElseThrow(() -> new RuntimeException("Estado não encontrado"));

        return salvo;
    }

    public Estado buscarPorId(Long id) {
        return estadoRepository.findById(id).orElseThrow(() -> new RuntimeException("Estado não encontrado"));
    }

    public Estado buscarPorNome(String nome) {
        return estadoRepository.findByNome(nome).orElseThrow(() -> new RuntimeException("Estado não encontrado"));
    }

    public List<Estado> buscarTodos() {
        return estadoRepository.findAll();
    }

    public void deletarPorId(Long id) {
        estadoRepository.deleteById(id);
    }
}
