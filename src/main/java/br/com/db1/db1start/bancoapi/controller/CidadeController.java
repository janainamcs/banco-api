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

import br.com.db1.db1start.bancoapi.adapter.CidadeAdapter;
import br.com.db1.db1start.bancoapi.dto.CidadeInputDTO;
import br.com.db1.db1start.bancoapi.dto.CidadeViewDTO;
import br.com.db1.db1start.bancoapi.dto.EstadoViewDTO;
import br.com.db1.db1start.bancoapi.entity.Cidade;
import br.com.db1.db1start.bancoapi.service.CidadeService;


public class CidadeController {

	@Autowired
	private CidadeService cidadeService;
	
	@GetMapping("/cidades")
	public List<CidadeViewDTO> buscarTodosAsCidades(){
		List<Cidade> cidades = cidadeService.buscarTodos();
		List<CidadeViewDTO> listaDeRetorno = new ArrayList<>();
		
		cidades.forEach(cidade -> {
			CidadeViewDTO meuCidadeDTO = CidadeAdapter.transformaCidadeParaViewDTO(cidade);
			listaDeRetorno.add(meuCidadeDTO);
		});
		
		return listaDeRetorno;
		
	}

	@PostMapping("/cidades")
	public void cadastrarNovoCidade(@RequestBody CidadeInputDTO form){
		EstadoViewDTO estadoDto = form.getEstado();
		Long estadoId = 
		cidadeService.criar(form.getNome());
		
	}
	
	@PutMapping("/cidades/{cidadeId}")
	public void atualizaCidade(@PathVariable Long cidadeId, @RequestBody CidadeInputDTO form){
		cidadeService.atualizar(cidadeId, form);
	}
	
	@DeleteMapping("/cidades/{cidadeId}")
	public void deletaCidade(@PathVariable Long cidadeId){
		cidadeService.deletarPorId(cidadeId);
	}
	
	@DeleteMapping("/cidades/nome/{cidadeNome}")
	public void deletaCidade(@PathVariable String cidadeNome){
		cidadeService.deletarPorNome(cidadeNome);
	}
}
