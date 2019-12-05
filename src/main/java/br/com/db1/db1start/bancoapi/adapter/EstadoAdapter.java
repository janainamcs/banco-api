package br.com.db1.db1start.bancoapi.adapter;

import br.com.db1.db1start.bancoapi.dto.EstadoInputDTO;
import br.com.db1.db1start.bancoapi.dto.EstadoViewDTO;
import br.com.db1.db1start.bancoapi.entity.Estado;

public class EstadoAdapter {

	public static EstadoViewDTO transformaEstadoParaViewDTO(Estado estado) {
		EstadoViewDTO estadoDTO =  new EstadoViewDTO();
		estadoDTO.setId(estado.getId());
		estadoDTO.setNome(estado.getNome());
		return estadoDTO;
	}
	
	public static Estado transformaInputDTOparaEstado(EstadoInputDTO estadoDTO) {
		Estado estado = new Estado();
		estado.setNome(estadoDTO.getNome());
		return estado;
	}
}
