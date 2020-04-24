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
import org.springframework.web.bind.annotation.RestController;

import br.com.db1.db1start.bancoapi.adapter.EstadoAdapter;
import br.com.db1.db1start.bancoapi.dto.EstadoViewDTO;
import br.com.db1.db1start.bancoapi.dto.EstadoInputDTO;
import br.com.db1.db1start.bancoapi.entity.Estado;
import br.com.db1.db1start.bancoapi.service.EstadoService;

@RestController
public class EstadoController {
	
	@Autowired
	private EstadoService estadoService;

	//create
	@PostMapping("/estados")
	public void cadastrarNovoEstado(@RequestBody EstadoInputDTO form){
		estadoService.criar(form.getNome());
	}

	//read
	@GetMapping("/estados")
	public List<EstadoViewDTO> buscarTodosOsEstados(){
		List<Estado>  estados = estadoService.buscarTodos();
		List<EstadoViewDTO> listaDeRetorno = new ArrayList<>();

		estados.forEach(estado -> {
			EstadoViewDTO meuEstadoDTO = EstadoAdapter.transformaEstadoParaViewDTO(estado);
			listaDeRetorno.add(meuEstadoDTO);
		});

		return listaDeRetorno;

	}

	//update
	@PutMapping("/estados/{estadoId}")
	public void atualizaEstado(@PathVariable Long estadoId, @RequestBody EstadoInputDTO form){
		estadoService.atualizar(estadoId, form.getNome());
	}

	//delete
	@DeleteMapping("/estados/{estadoId}")
	public void deletaEstado(@PathVariable Long estadoId){
		estadoService.deletarPorId(estadoId);
	}
	
	@DeleteMapping("/estados/nome/{estadoNome}")
	public void deletaEstado(@PathVariable String estadoNome){
		estadoService.deletarPorNome(estadoNome);
	}
	
}
