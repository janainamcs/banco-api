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

import br.com.db1.db1start.bancoapi.adapter.ContaAdapter;
import br.com.db1.db1start.bancoapi.dto.AgenciaInputDTO;
import br.com.db1.db1start.bancoapi.dto.ContaInputDTO;
import br.com.db1.db1start.bancoapi.dto.ContaViewDTO;
import br.com.db1.db1start.bancoapi.entity.Conta;
import br.com.db1.db1start.bancoapi.service.ContaService;

@RestController
public class ContaController {
	
	@Autowired
	ContaService contaService;
	
	@GetMapping("/contas")
	public List<ContaViewDTO> buscarTodasAsContas(){
		List<Conta>  contas = contaService.buscarTodos();
		List<ContaViewDTO> listaDeRetorno = new ArrayList<>();
		
		contas.forEach(conta -> {
			ContaViewDTO minhaContaDTO = ContaAdapter.transformaContaParaViewDTO(conta);
			listaDeRetorno.add(minhaContaDTO);
		});
		
		return listaDeRetorno;
		
	}

	@PostMapping("/contas")
	public void cadastrarNovaConta(@RequestBody ContaInputDTO form){
		
		
	}
	
	@PutMapping("/contas/{contaId}")
	public void atualizaConta(@PathVariable Long contaId, @RequestBody ContaInputDTO form){
		contaService.atualizar(contaId, form);
	}
	
	@DeleteMapping("/contas/{contaId}")
	public void deletaEstado(@PathVariable Long contaId){
		contaService.deletarPorId(contaId);
	}
	
	@DeleteMapping("/contas/nome/{estadoNome}")
	public void deletaEstado(@PathVariable String contaNome){
		contaService.deletarPorNome(contaNome);
	}

}
