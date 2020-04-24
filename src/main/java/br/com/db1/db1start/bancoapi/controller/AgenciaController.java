package br.com.db1.db1start.bancoapi.controller;

import br.com.db1.db1start.bancoapi.adapter.AgenciaAdapter;
import br.com.db1.db1start.bancoapi.adapter.CidadeAdapter;
import br.com.db1.db1start.bancoapi.dto.AgenciaInputDTO;
import java.util.ArrayList;
import java.util.List;

import br.com.db1.db1start.bancoapi.dto.CidadeInputDTO;
import br.com.db1.db1start.bancoapi.dto.CidadeViewDTO;
import br.com.db1.db1start.bancoapi.entity.Cidade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.db1.db1start.bancoapi.dto.AgenciaViewDTO;
import br.com.db1.db1start.bancoapi.entity.Agencia;
import br.com.db1.db1start.bancoapi.service.AgenciaService;



public class AgenciaController {

	@Autowired
	private AgenciaService agenciaService;

	//create
	@PostMapping("/agencias")
	public void cadastrarNovoAgencia(@RequestBody AgenciaInputDTO form){
		Cidade cidade = CidadeAdapter.transformaInputDTOParaCidade(form.getCidadeDTO());
		agenciaService.criar(form.getNumero(), form.getNumBanco(), cidade.getId());
		
	}

	//read
	@GetMapping("/agencias")
	public List<AgenciaViewDTO> buscarTodosOsAgencias(){
		List<Agencia>  agencias = agenciaService.buscarTodos();
		List<AgenciaViewDTO> listaDeRetorno = new ArrayList<>();

		agencias.forEach(agencia -> {
			AgenciaViewDTO meuAgenciaDTO = AgenciaAdapter.transformaAgenciaParaViewDTO(agencia);
			listaDeRetorno.add(meuAgenciaDTO);
		});

		return listaDeRetorno;

	}

	//delete
	@DeleteMapping("/agencias/{agenciaId}")
	public void deletaAgenciaPorId(@PathVariable Long agenciaId){
		agenciaService.deletarPorId(agenciaId);
	}
	
	@DeleteMapping("/agencias/deletar")
	public void deletaTodasAsAgencias(){
		agenciaService.deletarTodos();
	}
}
