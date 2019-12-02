package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import adapter.EstadoAdapter;
import br.com.db1.db1start.bancoapi.entity.Estado;
import br.com.db1.db1start.bancoapi.service.EstadoService;
import dto.EstadoDTO;

@RestController
public class EstadoController {
	
	@Autowired
	private EstadoService estadoService;
	
	@GetMapping("/estados")
	public List<EstadoDTO> buscarTodosOsEstados(){
		List<Estado>  estados = estadoService.buscarTodos();
		List<EstadoDTO> listaDeRetorno = new ArrayList<>();
		
		estados.forEach(estado -> {
			EstadoDTO meuEstadoDTO = EstadoAdapter.transformaEntidadeParaDTO(estado);
			listaDeRetorno.add(meuEstadoDTO);
		});
		
		return listaDeRetorno;
		
	}

	@PostMapping("/estados")
	public void cadastrarNovoEstado(@RequestBody EstadoFormDTO){
		
		
	}
	
}
