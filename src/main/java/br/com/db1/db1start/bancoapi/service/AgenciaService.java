package br.com.db1.db1start.bancoapi.service;

import java.util.List;

import br.com.db1.db1start.bancoapi.dto.AgenciaInputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.db1.db1start.bancoapi.entity.Agencia;
import br.com.db1.db1start.bancoapi.entity.Cidade;
import br.com.db1.db1start.bancoapi.repository.AgenciaRepository;

@Service
public class AgenciaService {
	
	@Autowired
	private AgenciaRepository agenciaRepository;
	@Autowired
	private CidadeService cidadeService;

	//Create
	public Agencia criar(String numero, String numeroBanco, Long cidadeId) {
		Cidade cidade = cidadeService.buscarPorId(cidadeId);
		Agencia agencia = new Agencia();
		agencia.setCidade(cidade);
		agencia.setNumero(numero);
		agencia.setNumeroBanco(numeroBanco);
		return agenciaRepository.save(agencia);
	}

	//Read
	public List<Agencia> buscarTodos() {
		return agenciaRepository.findAll();
	}

	public Agencia buscarPorId(Long id) {
        return agenciaRepository.findById(id).orElseThrow(() -> new RuntimeException("Agência não encontrada"));
    }
	
	public List<Agencia> buscarTodasPeloIdDaCidade(Long cidadeId) {
		return agenciaRepository.findByCidadeId(cidadeId);
    }

    public List<Agencia> buscarTodasPeloNomeDaCidade(String nome){
		Cidade cidade = cidadeService.buscarPorNome(nome).get();
		return agenciaRepository.findByCidadeId(cidade.getId());
	}

	//Update
	//Não é necessário?

	//Delete
	public void deletarTodos() {
		agenciaRepository.deleteAll();
    }

	public void deletarPorId(Long agenciaId) {
		agenciaRepository.deleteById(agenciaId);
	}

}
