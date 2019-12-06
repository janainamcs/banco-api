package br.com.db1.db1start.bancoapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.db1.db1start.bancoapi.dto.AgenciaViewDTO;
import br.com.db1.db1start.bancoapi.service.AgenciaService;



public class AgenciaController {

	@Autowired
	private AgenciaService agenciaService;
	
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

	@PostMapping("/agencias")
	public void cadastrarNovoAgencia(@RequestBody AgenciaInputDTO form){
		agenciaService.criar(form.getNome());
		
	}
	
	@PutMapping("/agencias/{agenciaId}")
	public void atualizaAgencia(@PathVariable Long agenciaId, @RequestBody AgenciaInputDTO form){
		agenciaService.atualizar(agenciaId, form);
	}
	
	@DeleteMapping("/agencias/{agenciaId}")
	public void deletaAgencia(@PathVariable Long agenciaId){
		agenciaService.deletarPorId(agenciaId);
	}
	
	@DeleteMapping("/agencias/nome/{agenciaNome}")
	public void deletaAgencia(@PathVariable String agenciaNome){
		agenciaService.deletarPorNome(agenciaNome);
	}
}
