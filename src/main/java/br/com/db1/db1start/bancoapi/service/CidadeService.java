package br.com.db1.db1start.bancoapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.db1.db1start.bancoapi.entity.Cidade;
import br.com.db1.db1start.bancoapi.entity.Estado;
import br.com.db1.db1start.bancoapi.repository.CidadeRepository;

import javax.swing.text.html.Option;

@Service
public class CidadeService {

	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private EstadoService estadoService;

	//Create
	public Cidade criar(String nome, Long estadoId) {
		Estado estado = estadoService.buscarPorId(estadoId);
		Cidade cidade = new Cidade();
		cidade.setNome(nome);
		cidade.setEstado(estado);
		return cidadeRepository.save(cidade);
	}

	///Read
	public List<Cidade> buscarTodos() {
		return cidadeRepository.findAll();
	}

	public List<Cidade> buscarTodosPeloEstado(Estado estado) {
		return cidadeRepository.findByEstado(estado);
	}

	public Cidade buscarPorId(Long id) {
		return cidadeRepository.findById(id).orElseThrow(() -> new RuntimeException("Cidade não encontrada"));
	}

	public Optional<Cidade> buscarPorNome(String nome){
		return cidadeRepository.findByNome(nome);
	}

	//Update
	public Cidade atualizar(Long cidadeId, String novoNome) {
        Cidade cidade = buscarPorId(cidadeId);
        cidade.setNome(novoNome);
        return cidadeRepository.save(cidade);
    }

    //Delete
    public void deletarPorId(Long id) {
		cidadeRepository.deleteById(id);
    }
	
	public void deletarTodos() {
		cidadeRepository.deleteAll();
    }

	public void deletarPorNome(String cidadeNome) {
		Cidade cidade = cidadeRepository.findByNome(cidadeNome).get();
    	cidadeRepository.delete(cidade);
	}
}
